package com.dsl.services;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.UnitTest;
import com.dsl.logic.gast.*;
import com.dsl.logic.printers.*;
import com.dsl.logic.visitors.*;
import com.dsl.logic.testableunits.*;
import com.dsl.logic.testscenarios.*;
import com.dsl.logic.unittests.*;
import com.dsl.repositories.IDSLRepo;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.stereotype.Component;


@Component
public class DSLCrudService implements IDSLCrudService {
    
    private ICompilationUnitHandler _compUnitHandler;
    private ITestableUnitHandler _testableUnitHandler;
    private IUnitTestHandler _unitTestHandler;
    private ITestScenarioHandler _testScenarioHandler;
    private ICompilationUnitTestHandler _compUnitTestHandler;
    private IPrinterHandler _printerHandler;
    private IDSLRepo _Repository;
    
    private DSLModel model;
    
    public DSLCrudService(ICompilationUnitHandler inCompUnitHandler, ITestableUnitHandler intestableUnitHandler, 
    		IUnitTestHandler inUnitTestHandler, ICompilationUnitTestHandler inCompUnitTestHandler, 
    		ITestScenarioHandler inTestScenarioHandler, IPrinterHandler printerHandler, IDSLRepo repository){
    	this._compUnitHandler = inCompUnitHandler;
    	this._testableUnitHandler = intestableUnitHandler;
    	this._unitTestHandler = inUnitTestHandler;
    	this._testScenarioHandler = inTestScenarioHandler;
    	this._compUnitTestHandler = inCompUnitTestHandler;
        this._printerHandler = printerHandler;
        this._Repository = repository;
        this.model = new DSLModel();
    }

    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	// transform file to GAST
    	createCompilationUnits(unitTestRequest);
        
        // Visit GAST functions
        visitCompilationUnits();
     
        // Create testable units
        processTestableUnits();
        
        // Process user test scenarios
        processTestScenario(unitTestRequest);
     
        // Create functions unit tests
        processUnitTest();
     
        // Write unit tests to GAST
        processCompilationUnitsTests();
        
        // Write code to files
        generateCode(unitTestRequest);
        
        // Write unit test into database
        saveToDataStore(unitTestRequest);

        return model.getUnitTest();
    }

    @Override
    public UnitTest editUnitTest(UnitTestRequest unitTestRequest) {
        return null;
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
    }


    private void createCompilationUnits(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException {
        _compUnitHandler.setLanguage(unitTestRequest.getLanguage());
        
        ArrayList<CompilationUnit> compUnits = _compUnitHandler.createCompilationUnits(unitTestRequest.getClassPath());

        model.setCompilationUnits(compUnits);
    }


    private void visitCompilationUnits(){
        for (CompilationUnit compilationUnit : model.getCompilationUnits()) {

            VisitorBase dslVisitor = new VisitorDSL();
            dslVisitor.visitCompilationUnit(compilationUnit);

            Class fileClass = dslVisitor.getFrameDSL().getCompilationUnit();
            model.setClass(fileClass);

            ArrayList<Function> functions = fileClass.getFunctions();

            model.setCompilationUnitFunctions(functions);
        }
    }


    private void processTestableUnits(){
        ArrayList<Function> functions = model.getCompilationUnitFunctions();
        
        ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);

        model.setTestableUnits(testableUnits);
    }


    private void processTestScenario(UnitTestRequest unitTestRequest) throws ValueTypeNotFoundException, AssertNotFoundException {
        TestScenario testScenario = _testScenarioHandler.processTestScenario(unitTestRequest, model.getTestableUnits());

        model.setTestScenario(testScenario);
    }


    private void processUnitTest() throws AssertNotFoundException, ValueTypeNotFoundException {
        TestScenario testScenario = model.getTestScenario();
        
        UnitTest unitTest = _unitTestHandler.processUnitTest(testScenario);

        model.setUnitTest(unitTest);
    }


    private void processCompilationUnitsTests(){
        ArrayList<CompilationUnit> compilationUnitTests = _compUnitTestHandler.processCompilationUnitTests(model);

        model.setCompilationUnitsTests(compilationUnitTests);
    }
    
    
    private void generateCode(UnitTestRequest unitTestRequest) {
    	CompilationUnit compilationUnit = model.getCompilationUnitsTests().get(0);
    	
    	_printerHandler.generateCode(compilationUnit, unitTestRequest.getOutputPath());
    }


    private void saveToDataStore(UnitTestRequest unitTestRequest) {
        _Repository.saveToDataStore(unitTestRequest);
    }

}
