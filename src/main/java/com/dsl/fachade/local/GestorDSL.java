package com.dsl.fachade.local;

import ASTMCore.ASTMSource.CompilationUnit;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.UnitTest;
import com.dsl.logic.gast.CompilationUnitTestHandler;
import com.dsl.logic.gast.ICompilationUnitTestHandler;
import com.dsl.logic.printers.IPrinterHandler;
import com.dsl.logic.printers.*;
import com.dsl.logic.visitors.VisitorBase;
import com.dsl.logic.visitors.VisitorDSL;
import com.dsl.logic.configfiles.ITestRunHandler;
import com.dsl.logic.configfiles.TestRunHandler;
import com.dsl.logic.expectedresults.*;
import com.dsl.logic.gast.ICompilationUnitFileHandler;
import com.dsl.logic.gast.CompilationUnitFileHandler;
import com.dsl.logic.testableunits.*;
import com.dsl.logic.testscenarios.*;
import com.dsl.logic.unittests.*;
import com.dsl.testrun.config.TestScenarioRun;
import com.dsl.testrun.config.ConfigurationTestRun;
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
    public void processUnitTests() throws AssertNotFoundException, ValueTypeNotFoundException {
        IUnitTestArrangeHandler arrangeHandler = new UnitTestArrangeHandler();
        IUnitTestActionHandler actionHandler = new UnitTestActionHandler();
        IUnitTestAssertHandler assertHandler = new UnitTestAssertHandler();
        IUnitTestHandler unitTestHandler = new UnitTestHandler(arrangeHandler, actionHandler, assertHandler);

        ArrayList<TestScenario> testScenarios = dslModel.getTestScenarios();
        ArrayList<UnitTest> unitTests = unitTestHandler.processUnitTests(testScenarios);

        dslModel.setUnitTests(unitTests);

        printUnitTests();
    }

    @Override
    public void processCompilationUnitsTests(){
        ICompilationUnitTestHandler handler = new CompilationUnitTestHandler();

        ArrayList<CompilationUnit> compilationUnitTests = handler.processCompilationUnitTests(dslModel);

        dslModel.setCompilationUnitsTests(compilationUnitTests);
    }

    @Override
    public void generateCode(){
        IPrinterHandler handlerJ = new PrinterJavaHandler();
        IPrinterHandler handlerC = new PrinterCSharpHandler();
        
        CompilationUnit compilationUnit = dslModel.getCompilationUnitsTests().get(0);
        String outputPath = dslModel.getConfigurationsRunFiles().get(0).getOutputCodeDirectory();
        
        handlerJ.generateCode(compilationUnit, outputPath);
        handlerC.generateCode(compilationUnit, outputPath);
    }

    private void printUnitTests(){
        for (var ut : dslModel.getUnitTests()){
            printer.printUnitTest(ut);
        }
    }

}
