package com.dsl.fachade.local;

import ASTMCore.ASTMSource.CompilationUnit;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.GestorModel;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.entities.aggregates.Class;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.UnitTest;
import com.dsl.logic.gast.CompilationUnitTestFileHandler;
import com.dsl.logic.gast.ICompilationUnitTestFileHandler;
import com.dsl.logic.gast.visitors.VisitorBase;
import com.dsl.logic.gast.visitors.VisitorDSL;
import com.dsl.logic.configfiles.ITestRunHandler;
import com.dsl.logic.configfiles.TestRunHandler;
import com.dsl.logic.gast.ICompilationUnitFileHandler;
import com.dsl.logic.gast.CompilationUnitFileHandler;
import com.dsl.logic.testscenarios.*;
import com.dsl.logic.unittests.*;
import com.dsl.testrun.config.TestScenarioRun;
import testrun.config.ConfigurationTestRun;
import com.dsl.utils.*;

import java.io.IOException;
import java.util.ArrayList;

public class GestorDSL implements IGestorDSL{

    private IPrinter printer;
    private GestorModel dslModel;

    public GestorDSL(IPrinter printer){
        this.printer = printer;
        this.dslModel = new GestorModel();
    }


    /**
     * Read the configuration file for initial specifications
     * Set the configuration objects
     *
     * @throws UnsupportedLanguageException
     */
    @Override
    public void readConfigurationFile() throws UnsupportedLanguageException {
        ITestRunHandler dslRunner = new TestRunHandler();

        ArrayList<ConfigurationTestRun> configFiles = dslRunner.processConfigFiles(dslModel.getConfigurationPath());

        dslModel.setConfigurationsRunFiles(configFiles);
    }

    /**
     * This method create a dsl in memory to process
     * GAST and return the root compilation units.
     *
     * @throws IOException
     * @throws UnsupportedLanguageException
     */
    @Override
    public void beginTransformation() throws IOException, UnsupportedLanguageException {
        for (ConfigurationTestRun testRun : dslModel.getConfigurationsRunFiles()) {
            ICompilationUnitFileHandler compilationUnitHandler = new CompilationUnitFileHandler(testRun);

            ArrayList<CompilationUnit> compilationUnits = compilationUnitHandler.processFilesInDir(dslModel.isWriteToDisk());

            dslModel.setCompilationUnits(compilationUnits);
        }
    }

    /**
     * Create a visitor DSL to visit the entire compilation unit
     * This method set a list of the compilation unit functions
     */
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

    /**
     * Create a transformation dsl for testable units
     * This method filter the functions in order to obtain
     * the valid testable units.
     */
    @Override
    public void processTestableUnits(){
        ITestableUnitHandler testableUnitHandler = new TestableUnitHandler();

        ArrayList<Function> functions = dslModel.getCompilationUnitFunctions();
        ArrayList<Function> testableUnits = testableUnitHandler.processTestableUnits(functions);

        dslModel.setTestableUnits(testableUnits);
    }

    /**
     * Use a processor dsl test scenario to define
     * the test scenario object representations.
     *
     * @throws ValueTypeNotFoundException
     * @throws AssertNotFoundException
     */
    @Override
    public void readTestScenarios() throws ValueTypeNotFoundException, AssertNotFoundException {
        IExpectedPrimitiveHandler expPrimitive = new ExpectedPrimitiveHandler();
        IExpectedParameterizedHandler expParameterized = new ExpectedParameterizedHandler();

        ITestScenarioFileHandler handler = new TestScenarioFileHandler(expPrimitive, expParameterized);

        ArrayList<TestScenarioRun> testScenarioRuns = handler.processTestScenariosRun(dslModel.getTestScenariosPath());
        ArrayList<TestScenario> testScenarios = handler.processTestScenarios(testScenarioRuns, dslModel.getTestableUnits());

        dslModel.setTestScenarios(testScenarios);
    }

    /**
     * Use the unit test dsl to convert from the
     * test scenarios to the unit test object representations
     *
     * @throws AssertNotFoundException
     */
    @Override
    public void processUnitTests() throws AssertNotFoundException {
        IUnitTestArrangeHandler arrangeHandler = new UnitTestArrangeHandler();
        IUnitTestActionHandler actionHandler = new UnitTestActionHandler();
        IUnitTestAssertHandler assertHandler = new UnitTestAssertHandler();
        IUnitTestHandler unitTestHandler = new UnitTestHandler(arrangeHandler, actionHandler, assertHandler);

        ArrayList<TestScenario> testScenarios = dslModel.getTestScenarios();
        ArrayList<UnitTest> unitTests = unitTestHandler.processUnitTests(testScenarios);

        dslModel.setUnitTests(unitTests);

        printUnitTests();
    }

    /**
     *  Create the compilation units of the unit tests
     *  generated by the handler.
     */
    @Override
    public void processCompilationUnitsTests(){
        ICompilationUnitTestFileHandler compilationUnitTestHandler = new CompilationUnitTestFileHandler();

        ArrayList<CompilationUnit> compilationUnitTests = compilationUnitTestHandler.processCompilationUnitTests(dslModel);

        dslModel.setCompilationUnitsTests(compilationUnitTests);
    }


    /**
     * Use the console printer to print unit tests
     * on the console screen.
     */
    private void printUnitTests(){
        for (var ut : dslModel.getUnitTests()){
            printer.printUnitTest(ut);
        }
    }

}