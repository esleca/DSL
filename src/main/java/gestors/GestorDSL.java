package gestors;

import ASTMCore.ASTMSource.CompilationUnit;
import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.Mapper;
import gastmappers.MapperFactory;
import gastmappers.exceptions.UnsupportedLanguageException;

import processor.configfiles.IProcessorHandlerRunner;
import processor.configfiles.ProcessorHandlerRunner;
import processor.gastgateway.visitors.VisitorBase;
import processor.gastgateway.visitors.VisitorDSL;
import processor.gastgateway.IProcessorHandlerReadable;
import processor.gastgateway.ProcessorHandlerReadable;
import processor.testscenarios.IProcessorHandlerTestScenario;
import processor.testscenarios.ProcessorHandlerTestScenario;
import processor.unittests.IProcessorHandlerTestable;
import processor.unittests.IProcessorHandlerUnitTester;
import processor.unittests.ProcessorHandlerTestable;
import processor.unittests.ProcessorHandlerUnitTester;
import utils.*;
import testrun.config.ConfigurationTestRun;

import java.awt.*;
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
        IProcessorHandlerRunner handlerRunner = new ProcessorHandlerRunner();
        dslModel.setConfigurationsRunFiles(handlerRunner.processConfigurationFiles(dslModel.getConfigurationPath()));
    }

    /**
     * This method create a handler in memory to process
     * GAST and return the root compilation units.
     *
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws SecurityException
     * @throws HeadlessException
     * @throws UnsupportedLanguageException
     */
    @Override
    public void beginTransformation() throws IOException, UnsupportedLanguageException {
        MapperFactory factory = new MapperFactory();

        for (ConfigurationTestRun testRun : dslModel.getConfigurationsRunFiles()) {
            Mapper mapper = factory.createMapper(testRun.getSourceLanguage());
            IProcessorHandlerReadable handlerReadable = new ProcessorHandlerReadable(testRun.getInputDirectory(), testRun.getOutputDirectory(),
                                                                                     testRun.getSourceLanguage(), mapper, testRun.isValidateMap());
            dslModel.setCompilationUnits(handlerReadable.processFilesInDir(dslModel.isWriteToDisk()));
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
     * Create a transformation handler for testable units
     * This method filter the functions in order to obtain
     * the valid testable units.
     */
    @Override
    public void processTestableUnits(){
        IProcessorHandlerTestable handlerTestable = new ProcessorHandlerTestable();
        dslModel.setTestableUnits(handlerTestable.getTestableUnits(dslModel.getCompilationUnitFunctions()));
    }

    /**
     * Use a processor handler test scenario to define
     * the test scenario object representations.
     */
    @Override
    public void readTestScenarios() throws ValueTypeNotFoundException, AssertNotFoundException {
        IProcessorHandlerTestScenario handlerTestScenario = new ProcessorHandlerTestScenario();
        dslModel.setTestScenariosRunFiles(handlerTestScenario.readTestScenariosRun(dslModel.getTestScenariosPath()));
        dslModel.setTestScenarios(handlerTestScenario.getTestScenarios(dslModel.getTestScenariosRunFiles(), dslModel.getTestableUnits()));
    }

    /**
     * Use the unit test handler to convert from the
     * test scenarios to the unit test object representations
     *
     */
    @Override
    public void processUnitTests() throws AssertNotFoundException {
        IProcessorHandlerUnitTester handlerUnitTester = new ProcessorHandlerUnitTester();
        dslModel.setUnitTests(handlerUnitTester.getUnitTests(dslModel.getTestScenarios()));
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
