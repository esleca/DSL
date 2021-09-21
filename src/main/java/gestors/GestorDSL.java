package gestors;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.Language;
import gastmappers.Mapper;
import gastmappers.MapperFactory;
import gastmappers.exceptions.UnsupportedLanguageException;

import models.entities.aggregates.Function;
import models.entities.unittests.TestScenario;
import models.entities.unittests.UnitTest;
import models.entities.unittests.TestableUnit;

import processor.*;

import gastgateway.visitors.VisitorBase;
import gastgateway.visitors.VisitorDSL;
import testrun.config.TestScenarioRun;
import testrun.config.ConfigurationTestRun;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class GestorDSL {

    private boolean writeToDisk;

    private ArrayList<ConfigurationTestRun> configurationsRun;
    private ArrayList<TestScenarioRun> testScenariosRun;

    private ArrayList<CompilationUnit> compilationUnits;
    private ArrayList<Function> compilationUnitFunctions;

    private ArrayList<TestableUnit> testableUnits;
    private ArrayList<TestScenario> testScenarios;
    private ArrayList<UnitTest> unitTests;

    private final String configurationPath;
    private final String testScenariosPath;

    public GestorDSL(){
        writeToDisk = true;
        configurationsRun = new ArrayList<>();
        testScenariosRun = new ArrayList<>();
        compilationUnits = new ArrayList<>();
        compilationUnitFunctions = new ArrayList<>();
        testableUnits = new ArrayList<>();
        unitTests = new ArrayList<>();
        configurationPath = "./src/main/java/testrun/config/configurationTestRun.json";
        testScenariosPath = "./src/main/java/testrun/config/testScenariosRun.json";
    }


    /**
     *
     * @throws UnsupportedLanguageException
     */
    public void readConfigurationFile() throws UnsupportedLanguageException {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(configurationPath)) {
            JSONArray configurationsArray = (JSONArray) jsonParser.parse(reader);

            for (Object configurationRawObject : configurationsArray) {

                JSONObject configurationObject = (JSONObject) configurationRawObject;
                ConfigurationTestRun testRun = getConfigurationTestRun(configurationObject);

                configurationsRun.add(testRun);
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading the configuration file.");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param configurationObject
     * @return
     * @throws UnsupportedLanguageException
     */
    private ConfigurationTestRun getConfigurationTestRun(JSONObject configurationObject) throws UnsupportedLanguageException {
        String inputDirectory = (String) configurationObject.get("inputDirectory");
        String outputDirectory = (String) configurationObject.get("outputDirectory");
        String sourceLanguageRaw = (String) configurationObject.get("sourceLanguage");
        Language sourceLanguage = Language.getLanguageFromString(sourceLanguageRaw);
        boolean validateMap = (boolean) configurationObject.get("validateMap");
        boolean semantic = (boolean) configurationObject.get("semantic");

        return new ConfigurationTestRun(inputDirectory, outputDirectory, sourceLanguage, validateMap, semantic);
    }


    /**
     *
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws SecurityException
     * @throws HeadlessException
     * @throws UnsupportedLanguageException
     */
    public void beginTransformation() throws IOException, IllegalArgumentException, SecurityException, HeadlessException, UnsupportedLanguageException {
        MapperFactory factory = new MapperFactory();

        for (ConfigurationTestRun testRun : configurationsRun) {
            Mapper mapper = factory.createMapper(testRun.getSourceLanguage());

            IProcessorHandlerInMemory handlerInMemory =
                    new ProcessorHandlerInMemory(testRun.getInputDirectory(), testRun.getOutputDirectory(), testRun.getSourceLanguage(), mapper, testRun.isValidateMap(), testRun.isSemantic());

            compilationUnits = handlerInMemory.processFilesInDir(writeToDisk);
        }
    }

    /**
     *
     * Create a visitor DSL to visit the entire compilation unit
     * This method set a list of the compilation unit functions
     */
    public void processGastFunctions(){
        for (CompilationUnit compilationUnit : compilationUnits) {

            VisitorBase dslVisitor = new VisitorDSL();
            dslVisitor.visitCompilationUnit(compilationUnit);

            compilationUnitFunctions = dslVisitor.getFrameDSL().getFunctions();
        }
    }

    /**
     *
     * Create a transformation handler for testable units
     * This method filter the functions in order to obtain
     * the valid testable units.
     */
    public void processTestableUnits(){
        IProcessorHandlerTestable handlerTestable = new ProcessorHandlerTestable();

        testableUnits = handlerTestable.getTestableUnits(compilationUnitFunctions);
    }

    /**
     *
     */
    public void readTestScenarios() {
        IProcessorHandlerTestScenario handlerTestScenario = new ProcessorHandlerTestScenario();

        testScenariosRun = handlerTestScenario.readTestScenariosRun(testScenariosPath);

        testScenarios = handlerTestScenario.getTestScenarios(testScenariosRun, testableUnits);
    }

    /**
     *
     */
    public void processUnitTests(){
        IProcessorHandlerUnitTester handlerUnitTester = new ProcessorHandlerUnitTester();
        ConsolePrinter consolePrinter = new ConsolePrinter();

        unitTests = handlerUnitTester.getUnitTests(testScenarios);

        for (UnitTest ut : unitTests){
            consolePrinter.printUnitTest(ut);
        }

    }



    /**
     *
     */
    public void writeGastUnitTests(){

    }

}
