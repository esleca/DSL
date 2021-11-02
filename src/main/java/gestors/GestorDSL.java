package gestors;

import ASTMCore.ASTMSource.CompilationUnit;
import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import factories.*;
import factories.gastfactories.GastFactory;
import factories.gastfactories.IGastFactory;
import gastmappers.Mapper;
import gastmappers.MapperFactory;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import models.entities.unittests.UnitTest;
import processor.gastgateway.CompilationUnitTestHandler;
import processor.gastgateway.ICompilationUnitTestHandler;
import processor.gastgateway.visitors.VisitorBase;
import processor.gastgateway.visitors.VisitorDSL;
import processor.configfiles.ITestRunHandler;
import processor.configfiles.TestRunHandler;
import processor.gastgateway.ICompilationUnitHandler;
import processor.gastgateway.CompilationUnitHandler;
import processor.testscenarios.*;
import processor.unittests.*;
import testrun.config.TestScenarioRun;
import utils.*;
import testrun.config.ConfigurationTestRun;

import java.io.IOException;
import java.util.ArrayList;

public class GestorDSL implements IGestorDSL{

    private GestorModel dslModel;

    public GestorDSL(){
        dslModel = new GestorModel();
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
        MapperFactory factory = new MapperFactory();

        for (ConfigurationTestRun testRun : dslModel.getConfigurationsRunFiles()) {
            Mapper mapper = factory.createMapper(testRun.getSourceLanguage());

            ICompilationUnitHandler compilationUnitHandler = new CompilationUnitHandler(testRun.getInputDirectory(),
                        testRun.getOutputDirectory(), testRun.getSourceLanguage(), mapper, testRun.isValidateMap());

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
        ArrayList<TestableUnit> testableUnits = testableUnitHandler.processTestableUnits(functions);

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
        IExpectablePrimitive expPrimitive = new ExpectablePrimitiveHandler();
        IExpectableParameterized expParameterized = new ExpectableParameterizedHandler();

        ITestScenarioHandler handler = new TestScenarioHandler(expPrimitive, expParameterized);

        String path = dslModel.getTestScenariosPath();
        ArrayList<TestScenarioRun> testScenarioRuns = handler.processTestScenariosRun(path);
        ArrayList<TestableUnit> testableUnits = dslModel.getTestableUnits();
        ArrayList<TestScenario> testScenarios = handler.processTestScenarios(testScenarioRuns, testableUnits);

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
     *
     */
    @Override
    public void processCompilationUnitsTests(){
        IGastFactory gastFactory = new GastFactory();
        ICompilationUnitTestHandler compilationUnitTestHandler = new CompilationUnitTestHandler(gastFactory);

        ArrayList<CompilationUnit> compilationUnitTests = compilationUnitTestHandler.processCompilationUnitTests(dslModel);

        dslModel.setCompilationUnitsTests(compilationUnitTests);
    }


    /**
     * Use the console printer to print unit tests
     * on the console screen.
     */
    private void printUnitTests(){
        IPrinter printer = new ConsolePrinter();
        for (var ut : dslModel.getUnitTests()){
            printer.printUnitTest(ut);
        }
    }

}
