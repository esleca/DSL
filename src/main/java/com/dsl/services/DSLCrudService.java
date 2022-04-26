package com.dsl.services;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.entities.aggregates.Class;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.UnitTest;
import com.dsl.logic.gast.*;
import com.dsl.logic.visitors.*;
import com.dsl.logic.testableunits.*;
import com.dsl.logic.testscenarios.*;
import com.dsl.logic.unittests.*;
import com.dsl.repositories.IDSLRepo;
import com.dsl.utils.IPrinter;

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
    private IPrinter _printer;
    private IDSLRepo _Repository;
    
    private DSLModel model;
    
    public DSLCrudService(ICompilationUnitHandler inCompUnitHandler, ITestableUnitHandler intestableUnitHandler, 
    		IUnitTestHandler inUnitTestHandler, ICompilationUnitTestHandler inCompUnitTestHandler, 
    		ITestScenarioHandler inTestScenarioHandler, IPrinter printer, IDSLRepo repository){
    	this._compUnitHandler = inCompUnitHandler;
    	this._testableUnitHandler = intestableUnitHandler;
    	this._unitTestHandler = inUnitTestHandler;
    	this._testScenarioHandler = inTestScenarioHandler;
    	this._compUnitTestHandler = inCompUnitTestHandler;
        this._printer = printer;
        this._Repository = repository;
        this.model = new DSLModel();
    }

    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        createCompilationUnits(unitTestRequest);
        visitCompilationUnits();
        processTestableUnits();
        processTestScenario(unitTestRequest);
        processUnitTest();
        processCompilationUnitsTests();
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



    /**
     * Call the compilation units handler in order
     * to generate compilation units based on input path
     *
     * @param unitTestRequest
     * @throws IOException
     * @throws UnsupportedLanguageException
     */
    private void createCompilationUnits(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException {
        _compUnitHandler.setLanguage(unitTestRequest.getLanguage());
        ArrayList<CompilationUnit> compUnits = _compUnitHandler.createCompilationUnits(unitTestRequest.getClassPath());

        model.setCompilationUnits(compUnits);
    }

    /**
     *  Create a visitor DSL to visit the entire compilation unit
     *  This method set a list of the compilation unit functions
     */
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

    /**
     * Create a transformation dsl for testable units
     * This method filter the functions in order to obtain
     * the valid testable units.
     */
    private void processTestableUnits(){
        ArrayList<Function> functions = model.getCompilationUnitFunctions();
        ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);

        model.setTestableUnits(testableUnits);
    }

    /**
     * Use a test scenario handler to define
     * the test scenario object representations.
     *
     * @throws ValueTypeNotFoundException
     * @throws AssertNotFoundException
     */
    private void processTestScenario(UnitTestRequest unitTestRequest) throws ValueTypeNotFoundException, AssertNotFoundException {
        TestScenario testScenario = _testScenarioHandler.processTestScenario(unitTestRequest, model.getTestableUnits());

        model.setTestScenario(testScenario);
    }

    /**
     * Use the unit test dsl to convert from the
     * test scenario to the unit test object representation
     *
     * @throws AssertNotFoundException
     */
    private void processUnitTest() throws AssertNotFoundException {
        TestScenario testScenario = model.getTestScenario();
        UnitTest unitTest = _unitTestHandler.processUnitTest(testScenario);

        model.setUnitTest(unitTest);

        _printer.printUnitTest(model.getUnitTest());
    }

    /**
     * Process the unit tests in order to write them
     * into the GAST structure, create compilation units
     * with the unit tests objects.
     */
    private void processCompilationUnitsTests(){
        ArrayList<CompilationUnit> compilationUnitTests = _compUnitTestHandler.processCompilationUnitTests(model);

        model.setCompilationUnitsTests(compilationUnitTests);
    }

    /**
     * Use the repository to delegate saving the unit test
     * to a local data store.
     *
     * @param unitTestRequest
     */
    private void saveToDataStore(UnitTestRequest unitTestRequest) {
        _Repository.saveToDataStore(unitTestRequest);
    }

}
