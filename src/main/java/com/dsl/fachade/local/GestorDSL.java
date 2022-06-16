package com.dsl.fachade.local;

import ASTMCore.ASTMSource.CompilationUnit;
import com.dsl.logic.unittests.action.IUnitTestActionHandler;
import com.dsl.logic.unittests.action.UnitTestActionHandler;
import com.dsl.logic.unittests.arrange.IUnitTestArrangeHandler;
import com.dsl.logic.unittests.arrange.UnitTestArrangeHandler;
import com.dsl.logic.unittests.asserts.IUnitTestAssertHandler;
import com.dsl.logic.unittests.asserts.UnitTestAssertHandler;

import gastmappers.exceptions.UnsupportedLanguageException;

import com.dsl.exceptions.*;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.aggregates.*;
import com.dsl.models.aggregates.Class;
import com.dsl.models.unittests.*;
import com.dsl.logic.gast.*;
import com.dsl.logic.imports.IImportsHandler;
import com.dsl.logic.imports.ImportsHandler;
import com.dsl.logic.packages.IPackagesHandler;
import com.dsl.logic.packages.PackagesHandler;
import com.dsl.logic.parameterscenarios.*;
import com.dsl.logic.printers.*;
import com.dsl.logic.programscopes.FunctionActionHandler;
import com.dsl.logic.programscopes.FunctionArrangeHandler;
import com.dsl.logic.programscopes.FunctionAssertHandler;
import com.dsl.logic.programscopes.FunctionModifiersHandler;
import com.dsl.logic.programscopes.FunctionReturnHandler;
import com.dsl.logic.programscopes.FunctionScopeHandler;
import com.dsl.logic.programscopes.IFunctionActionHandler;
import com.dsl.logic.programscopes.IFunctionArrangeHandler;
import com.dsl.logic.programscopes.IFunctionAssertHandler;
import com.dsl.logic.programscopes.IFunctionModifiersHandler;
import com.dsl.logic.programscopes.IFunctionReturnHandler;
import com.dsl.logic.programscopes.IFunctionScopeHandler;
import com.dsl.logic.programscopes.IProgramScopeHandler;
import com.dsl.logic.programscopes.ProgramScopeHandler;
import com.dsl.logic.visitors.*;
import com.dsl.logic.annotations.AnnotationsHandler;
import com.dsl.logic.annotations.IAnnotationsHandler;
import com.dsl.logic.configfiles.*;
import com.dsl.logic.expectedresults.*;
import com.dsl.logic.testableunits.*;
import com.dsl.logic.testscenarios.*;
import com.dsl.logic.unittests.*;
import com.dsl.testrun.config.*;

import java.io.IOException;
import java.util.ArrayList;

public class GestorDSL implements IGestorDSL{

    private DSLModel dslModel;

    public GestorDSL(){
        this.dslModel = new DSLModel();
    }


    @Override
    public void readConfigurationFile() throws UnsupportedLanguageException {
        ITestRunHandler dslRunner = new TestRunHandler();

        ArrayList<ConfigurationTestRun> configFiles = dslRunner.processConfigFiles(dslModel.getConfigurationPath());

        dslModel.setConfigurationsRunFiles(configFiles);
    }

    @Override
    public void beginTransformation() throws IOException, UnsupportedLanguageException {
        for (ConfigurationTestRun testRun : dslModel.getConfigurationsRunFiles()) {
            ICompilationUnitFileHandler compilationUnitHandler = new CompilationUnitFileHandler(testRun);

            ArrayList<CompilationUnit> compilationUnits = compilationUnitHandler.processFilesInDir(dslModel.isWriteToDisk());

            dslModel.setCompilationUnits(compilationUnits);
        }
    }

    @Override
    public void processGastFunctions(){
        for (CompilationUnit compilationUnit : dslModel.getCompilationUnits()) {

            VisitorBase dslVisitor = new VisitorDSL();
            dslVisitor.visitCompilationUnit(compilationUnit);

            Class fileClass = dslVisitor.getFrameDSL().getCompilationUnit();
            dslModel.setClass(fileClass);

            ArrayList<Function> functions = fileClass.getFunctions();

            dslModel.setCompilationUnitFunctions(functions);
        }
    }

    @Override
    public void processTestableUnits(){
        ITestableUnitHandler testableUnitHandler = new TestableUnitHandler();

        ArrayList<Function> functions = dslModel.getCompilationUnitFunctions();
        ArrayList<Function> testableUnits = testableUnitHandler.processTestableUnits(functions);

        dslModel.setTestableUnits(testableUnits);
    }

    @Override
    public void readTestScenarios() throws ValueTypeNotFoundException, AssertNotFoundException {
    	IParameterScenarioHandler paramScenarioHandler = new ParameterScenarioHandler();
    	IExpectedPrimitiveHandler expPrimitive = new ExpectedPrimitiveHandler();
        IExpectedParameterizedHandler expParameterized = new ExpectedParameterizedHandler();

        ITestScenarioFileHandler handler = new TestScenarioFileHandler(paramScenarioHandler, expPrimitive, expParameterized);

        ArrayList<TestScenarioRun> testScenarioRuns = handler.processTestScenariosRun(dslModel.getTestScenariosPath());
        ArrayList<TestScenario> testScenarios = handler.processTestScenarios(testScenarioRuns, dslModel.getTestableUnits());

        dslModel.setTestScenarios(testScenarios);
    }

    @Override
    public void processUnitTests() throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException {
    	ArrayList<String> outputLanguages = dslModel.getConfigurationsRunFiles().get(0).getOutputLanguages();
    	
    	for(String language : outputLanguages) {
    		IUnitTestArrangeHandler arrangeHandler = new UnitTestArrangeHandler();
            IUnitTestActionHandler actionHandler = new UnitTestActionHandler();
            IUnitTestAssertHandler assertHandler = new UnitTestAssertHandler();
            IUnitTestHandler unitTestHandler = new UnitTestHandler(arrangeHandler, actionHandler, assertHandler);

            ArrayList<TestScenario> testScenarios = dslModel.getTestScenarios();
            ArrayList<UnitTest> unitTests = unitTestHandler.processUnitTests(testScenarios, language);

            dslModel.addUnitTests(unitTests);
    	}
    }

    @Override
    public void processCompilationUnitsTests() throws UnsupportedLanguageException{
        ArrayList<String> outputLanguages = dslModel.getConfigurationsRunFiles().get(0).getOutputLanguages();
    	
        IAnnotationsHandler annotationsHandler = new AnnotationsHandler();
        IFunctionModifiersHandler modifiersHandler = new FunctionModifiersHandler(annotationsHandler);
    	IFunctionReturnHandler returnHandler = new FunctionReturnHandler();
    	IFunctionArrangeHandler arrangeHandler = new FunctionArrangeHandler();
    	IFunctionActionHandler actionHandler = new FunctionActionHandler();
    	IFunctionAssertHandler assertHandler = new FunctionAssertHandler();
        IFunctionScopeHandler functionHandler = new FunctionScopeHandler(modifiersHandler, returnHandler, arrangeHandler, actionHandler, assertHandler);
        IPackagesHandler packagesHandler = new PackagesHandler();
        IImportsHandler importsHandler = new ImportsHandler();
        IProgramScopeHandler programHandler = new ProgramScopeHandler(functionHandler);
        
    	for(String language : outputLanguages) {
            ICompilationUnitTestHandler handler = new CompilationUnitTestHandler(packagesHandler, importsHandler, programHandler);
    		ArrayList<CompilationUnit> compilationUnitTests = handler.processCompilationUnitTests(dslModel, language);
           
    		dslModel.addCompilationUnitsTests(compilationUnitTests);
    	}
    }

    @Override
    public void generateCode() throws UnsupportedLanguageException{
    	ArrayList<String> outputLanguages = dslModel.getConfigurationsRunFiles().get(0).getOutputLanguages();
    	String outputPath = dslModel.getConfigurationsRunFiles().get(0).getOutputCodeDirectory();
        
    	IPrinterHandler handler = new PrinterHandler();
    	
    	for(String language : outputLanguages) {
    		CompilationUnit compilationUnit = dslModel.getCompilationUnitsTests(language).get(0);
            handler.generateCode(compilationUnit, language, outputPath);
    	}
    }
    
    
    
    
    
    
    
    
    
    //TODO: REMOVE THIS METHOD, TEST PURPOSE
    @Override
    public void testgenerateCode() throws UnsupportedLanguageException, IOException{
    	ITestRunHandler dslRunner = new TestRunHandler();
        IPrinterHandler handler = new PrinterHandler();
        
        ConfigurationTestRun configuration = dslRunner.processConfigFiles(dslModel.getConfigurationPath()).get(0);
        ICompilationUnitFileHandler compilationUnitHandler = new CompilationUnitFileHandler(configuration);
        ArrayList<CompilationUnit> compilationUnits = compilationUnitHandler.processFilesInDir(true);
        
        for (CompilationUnit compilationUnit : compilationUnits) {
        	String outputPath = configuration.getOutputCodeDirectory();	
        	ArrayList<String> outputLanguages = configuration.getOutputLanguages();
        
        	for(String language : outputLanguages) {
        		handler.generateCode(compilationUnit, language, outputPath);
        	}
        }
    }
}
