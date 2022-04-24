package com.dsl.fachade.models;

import ASTMCore.ASTMSource.CompilationUnit;
import com.dsl.models.entities.aggregates.Class;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.UnitTest;
import testrun.config.ConfigurationTestRun;
import java.util.ArrayList;

public class GestorModel{

    private final boolean writeToDisk;
    private final String configurationPath;
    private final String testScenariosPath;

    private Class lClass;
    private ArrayList<CompilationUnit> compilationUnits;
    private ArrayList<CompilationUnit> compilationUnitsTests;
    private ArrayList<Function> compilationUnitFunctions;
    private ArrayList<Function> testableUnits;
    private ArrayList<TestScenario> testScenarios;
    private ArrayList<UnitTest> unitTests;
    private ArrayList<ConfigurationTestRun> configurationsRunFiles;


    public GestorModel(){
        writeToDisk = true;

        compilationUnits = new ArrayList<>();
        compilationUnitsTests = new ArrayList<>();
        compilationUnitFunctions = new ArrayList<>();
        testableUnits = new ArrayList<>();
        testScenarios = new ArrayList<>();
        unitTests = new ArrayList<>();
        configurationsRunFiles = new ArrayList<>();

        configurationPath = "./src/main/java/com/dsl/testrun/config/configurationTestRun.json";
        testScenariosPath = "./src/main/java/com/dsl/testrun/config/testScenariosRun.json";
    }

    public ArrayList<UnitTest> getUnitTests() {
        return unitTests;
    }

    public void setUnitTests(ArrayList<UnitTest> unitTests) {
        this.unitTests = unitTests;
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

    public Class getlClass() {
        return lClass;
    }

    public void setClass(Class inClass) {
        this.lClass = inClass;
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

    public ArrayList<TestScenario> getTestScenarios() {
        return testScenarios;
    }

    public void setTestScenarios(ArrayList<TestScenario> testScenarios) {
        this.testScenarios = testScenarios;
    }

    public ArrayList<Function> getTestableUnits() {
        return testableUnits;
    }

    public void setTestableUnits(ArrayList<Function> testableUnits) {
        this.testableUnits = testableUnits;
    }

}
