package gestors;

import ASTMCore.ASTMSource.CompilationUnit;
import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.unittests.TestScenario;
import models.entities.unittests.UnitTest;
import testrun.config.ConfigurationTestRun;

import java.util.ArrayList;

public class GestorModel {

    private final boolean writeToDisk;
    private final String configurationPath;
    private final String testScenariosPath;


    private Class aClass;
    private ArrayList<ConfigurationTestRun> configurationsRunFiles;
    private ArrayList<CompilationUnit> compilationUnits;
    private ArrayList<CompilationUnit> compilationUnitsTests;
    private ArrayList<Function> compilationUnitFunctions;
    private ArrayList<Function> testableUnits;
    private ArrayList<TestScenario> testScenarios;
    private ArrayList<UnitTest> unitTests;

    public GestorModel(){
        writeToDisk = true;
        configurationsRunFiles = new ArrayList<>();
        compilationUnits = new ArrayList<>();
        compilationUnitsTests = new ArrayList<>();
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

    public Class getaClass() {
        return aClass;
    }

    public void setClass(Class aClass) {
        this.aClass = aClass;
    }

    public ArrayList<ConfigurationTestRun> getConfigurationsRunFiles() {
        return configurationsRunFiles;
    }

    public void setConfigurationsRunFiles(ArrayList<ConfigurationTestRun> configurationsRunFiles){
        this.configurationsRunFiles = configurationsRunFiles;
    }

    public ArrayList<CompilationUnit> getCompilationUnits() {
        return compilationUnits;
    }

    public void setCompilationUnits(ArrayList<CompilationUnit> compilationUnits) {
        this.compilationUnits = compilationUnits;
    }

    public ArrayList<CompilationUnit> getCompilationUnitsTests() {
        return compilationUnitsTests;
    }

    public void setCompilationUnitsTests(ArrayList<CompilationUnit> compilationUnitsTests) {
        this.compilationUnitsTests = compilationUnitsTests;
    }

    public ArrayList<Function> getCompilationUnitFunctions() {
        return compilationUnitFunctions;
    }

    public void setCompilationUnitFunctions(ArrayList<Function> compilationUnitFunctions) {
        this.compilationUnitFunctions = compilationUnitFunctions;
    }

    public ArrayList<Function> getTestableUnits() {
        return testableUnits;
    }

    public void setTestableUnits(ArrayList<Function> testableUnits) {
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
