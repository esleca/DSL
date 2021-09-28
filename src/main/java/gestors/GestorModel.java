package gestors;

import ASTMCore.ASTMSource.CompilationUnit;
import models.entities.aggregates.Function;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import models.entities.unittests.UnitTest;
import testrun.config.ConfigurationTestRun;
import testrun.config.TestScenarioRun;

import java.util.ArrayList;

public class GestorModel {

    private boolean writeToDisk;
    private final String configurationPath;
    private final String testScenariosPath;

    private ArrayList<ConfigurationTestRun> configurationsRunFiles;
    private ArrayList<TestScenarioRun> testScenariosRunFiles;
    private ArrayList<CompilationUnit> compilationUnits;
    private ArrayList<Function> compilationUnitFunctions;
    private ArrayList<TestableUnit> testableUnits;
    private ArrayList<TestScenario> testScenarios;
    private ArrayList<UnitTest> unitTests;

    public GestorModel(){
        writeToDisk = true;
        configurationsRunFiles = new ArrayList<>();
        testScenariosRunFiles = new ArrayList<>();
        compilationUnits = new ArrayList<>();
        compilationUnitFunctions = new ArrayList<>();
        testableUnits = new ArrayList<>();
        unitTests = new ArrayList<>();
        configurationPath = "./src/main/java/testrun/config/configurationTestRun.json";
        testScenariosPath = "./src/main/java/testrun/config/testScenariosRun.json";
    }

    public boolean isWriteToDisk() {
        return writeToDisk;
    }

    public String getConfigurationPath() {
        return configurationPath;
    }

    public String getTestScenariosPath() {
        return testScenariosPath;
    }

    public ArrayList<ConfigurationTestRun> getConfigurationsRunFiles() {
        return configurationsRunFiles;
    }

    public void setConfigurationsRunFiles(ArrayList<ConfigurationTestRun> configurationsRunFiles){
        this.configurationsRunFiles = configurationsRunFiles;
    }

    public ArrayList<TestScenarioRun> getTestScenariosRunFiles() {
        return testScenariosRunFiles;
    }

    public void setTestScenariosRunFiles(ArrayList<TestScenarioRun> testScenariosRunFiles) {
        this.testScenariosRunFiles = testScenariosRunFiles;
    }

    public ArrayList<CompilationUnit> getCompilationUnits() {
        return compilationUnits;
    }

    public void setCompilationUnits(ArrayList<CompilationUnit> compilationUnits) {
        this.compilationUnits = compilationUnits;
    }

    public ArrayList<Function> getCompilationUnitFunctions() {
        return compilationUnitFunctions;
    }

    public void setCompilationUnitFunctions(ArrayList<Function> compilationUnitFunctions) {
        this.compilationUnitFunctions = compilationUnitFunctions;
    }

    public ArrayList<TestableUnit> getTestableUnits() {
        return testableUnits;
    }

    public void setTestableUnits(ArrayList<TestableUnit> testableUnits) {
        this.testableUnits = testableUnits;
    }

    public ArrayList<TestScenario> getTestScenarios() {
        return testScenarios;
    }

    public void setTestScenarios(ArrayList<TestScenario> testScenarios) {
        this.testScenarios = testScenarios;
    }

    public ArrayList<UnitTest> getUnitTests() {
        return unitTests;
    }

    public void setUnitTests(ArrayList<UnitTest> unitTests) {
        this.unitTests = unitTests;
    }
}
