package com.dsl.fachade.local;

import ASTMCore.ASTMSource.CompilationUnit;
import com.dsl.logic.unittests.action.IUnitTestActionHandler;
import com.dsl.logic.unittests.action.UnitTestActionHandler;
import com.dsl.logic.unittests.arrange.IUnitTestArrangeHandler;
import com.dsl.logic.unittests.arrange.UnitTestArrangeHandler;
import com.dsl.logic.unittests.asserts.IUnitTestAssertHandler;
import gastmappers.exceptions.UnsupportedLanguageException;

import com.dsl.exceptions.*;
import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.PrintersFactory;
import com.dsl.factories.UnitTestAssertsFactory;
import com.dsl.models.aggregates.*;
import com.dsl.models.aggregates.Class;
import com.dsl.models.unittests.*;
import com.dsl.logic.gast.*;
import com.dsl.logic.parameterscenarios.*;
import com.dsl.logic.printers.*;
import com.dsl.logic.visitors.*;
import com.dsl.logic.configfiles.*;
import com.dsl.logic.expectedresults.*;
import com.dsl.logic.testableunits.*;
import com.dsl.logic.testscenarios.*;
import com.dsl.logic.unittests.*;
import com.dsl.testrun.config.*;
import com.dsl.utils.*;

import java.io.IOException;
import java.util.ArrayList;

public class GestorDSL implements IGestorDSL{

    private IPrinter printer;
    private DSLModel dslModel;

    public GestorDSL(IPrinter printer){
        this.printer = printer;
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
            IUnitTestAssertHandler assertHandler = UnitTestAssertsFactory.createAssertHandler(language);
            IUnitTestHandler unitTestHandler = new UnitTestHandler(arrangeHandler, actionHandler, assertHandler);

            ArrayList<TestScenario> testScenarios = dslModel.getTestScenarios();
            ArrayList<UnitTest> unitTests = unitTestHandler.processUnitTests(testScenarios, language);

            dslModel.addUnitTests(unitTests);
            
            //printUnitTests();	
    	}
    }

    @Override
    public void processCompilationUnitsTests(){
        ArrayList<String> outputLanguages = dslModel.getConfigurationsRunFiles().get(0).getOutputLanguages();
    	
    	for(String language : outputLanguages) {
            ICompilationUnitTestHandler handler = new CompilationUnitTestHandler();
    		ArrayList<CompilationUnit> compilationUnitTests = handler.processCompilationUnitTests(dslModel, language);
           
    		dslModel.addCompilationUnitsTests(compilationUnitTests);
    	}
    }

    @Override
    public void generateCode() throws UnsupportedLanguageException{
    	ArrayList<String> outputLanguages = dslModel.getConfigurationsRunFiles().get(0).getOutputLanguages();
    	String outputPath = dslModel.getConfigurationsRunFiles().get(0).getOutputCodeDirectory();
        
    	for(String language : outputLanguages) {
    		IPrinterHandler handler = PrintersFactory.createPrinterHandler(language);
            
    		ArrayList<CompilationUnit> compilationUnits = dslModel.getCompilationUnitsTests(language);
        	
            handler.generateCode(compilationUnits.get(0), outputPath);
    	}
    }
    
    
    @Override
    public void testgenerateCode() throws UnsupportedLanguageException, IOException{
    	ITestRunHandler dslRunner = new TestRunHandler();
        IPrinterHandler handlerJ = new PrinterJavaHandler();
        IPrinterHandler handlerC = new PrinterCSharpHandler();
        ArrayList<ConfigurationTestRun> configFiles = dslRunner.processConfigFiles(dslModel.getConfigurationPath());        
        dslModel.setConfigurationsRunFiles(configFiles);
        for (ConfigurationTestRun testRun : configFiles) {
        	ICompilationUnitFileHandler compilationUnitHandler = new CompilationUnitFileHandler(testRun);
            ArrayList<CompilationUnit> compilationUnits = compilationUnitHandler.processFilesInDir(true);
            for (CompilationUnit compilationUnit : compilationUnits) {
            	String outputPath = dslModel.getConfigurationsRunFiles().get(0).getOutputCodeDirectory();
                handlerJ.generateCode(compilationUnit, outputPath);
                handlerC.generateCode(compilationUnit, outputPath);
            }
        }
    }
    

//    private void printUnitTests(){
//        for (var ut : dslModel.getUnitTests()){
//            printer.printUnitTest(ut.iterator());
//        }
//    }

}
