package gestors;

import ASTMCore.ASTMSource.CompilationUnit;
import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.Mapper;
import gastmappers.MapperFactory;
import gastmappers.exceptions.UnsupportedLanguageException;

import processor.configfiles.ITestRunHandler;
import processor.configfiles.TestRunHandler;
import processor.gastgateway.visitors.VisitorBase;
import processor.gastgateway.visitors.VisitorDSL;
import processor.gastgateway.ICompilationUnitHandler;
import processor.gastgateway.CompilationUnitHandler;
import processor.testscenarios.ITestScenarioHandler;
import processor.testscenarios.TestScenarioHandler;
import processor.unittests.ITestableUnitHandler;
import processor.unittests.IUnitTestHandler;
import processor.unittests.TestableUnitHandler;
import processor.unittests.UnitTestHandler;
import utils.*;
import testrun.config.ConfigurationTestRun;

import java.io.IOException;


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
        dslModel.setConfigurationsRunFiles(dslRunner.processConfigurationFiles(dslModel.getConfigurationPath()));
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
            ICompilationUnitHandler compilationUnitHandler = new CompilationUnitHandler(testRun.getInputDirectory(), testRun.getOutputDirectory(),
                                                                                     testRun.getSourceLanguage(), mapper, testRun.isValidateMap());
            dslModel.setCompilationUnits(compilationUnitHandler.processFilesInDir(dslModel.isWriteToDisk()));
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
            dslModel.setCompilationUnitFunctions(dslVisitor.getFrameDSL().getFunctions());
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
        dslModel.setTestableUnits(testableUnitHandler.processTestableUnits(dslModel.getCompilationUnitFunctions()));
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
        ITestScenarioHandler testScenarioHandler = new TestScenarioHandler();
        dslModel.setTestScenariosRunFiles(testScenarioHandler.processTestScenariosRun(dslModel.getTestScenariosPath()));
        dslModel.setTestScenarios(testScenarioHandler.processTestScenarios(dslModel.getTestScenariosRunFiles(), dslModel.getTestableUnits()));
    }

    /**
     * Use the unit test dsl to convert from the
     * test scenarios to the unit test object representations
     *
     * @throws AssertNotFoundException
     */
    @Override
    public void processUnitTests() throws AssertNotFoundException {
        IUnitTestHandler unitTestHandler = new UnitTestHandler();
        dslModel.setUnitTests(unitTestHandler.processUnitTests(dslModel.getTestScenarios()));
        printUnitTests();
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

    /**
     *
     */
    @Override
    public void writeGastUnitTests(){

    }

}
