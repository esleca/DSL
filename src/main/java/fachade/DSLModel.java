package fachade;

import ASTMCore.ASTMSource.CompilationUnit;
import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.unittests.TestScenario;
import models.entities.unittests.UnitTest;

import java.util.ArrayList;

public class DSLModel {

    private Class lClass;
    private ArrayList<CompilationUnit> compilationUnits;
    private ArrayList<CompilationUnit> compilationUnitsTests;
    private ArrayList<Function> compilationUnitFunctions;
    private ArrayList<Function> testableUnits;
    private ArrayList<TestScenario> testScenarios;
    private ArrayList<UnitTest> unitTests;

    public DSLModel(){
        compilationUnits = new ArrayList<>();
        compilationUnitsTests = new ArrayList<>();
        compilationUnitFunctions = new ArrayList<>();
        testableUnits = new ArrayList<>();
        testScenarios = new ArrayList<>();
        unitTests = new ArrayList<>();
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
