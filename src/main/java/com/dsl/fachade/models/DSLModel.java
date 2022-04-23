package com.dsl.fachade.models;

import ASTMCore.ASTMSource.CompilationUnit;
import com.dsl.models.entities.aggregates.Class;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.UnitTest;

import java.util.ArrayList;

public class DSLModel {

    private Class lClass;
    private ArrayList<CompilationUnit> compilationUnits;
    private ArrayList<CompilationUnit> compilationUnitsTests;
    private ArrayList<Function> compilationUnitFunctions;
    private ArrayList<Function> testableUnits;
    private TestScenario testScenario;
    private UnitTest unitTest;
    private ArrayList<UnitTest> unitTests;

    public DSLModel(){
        compilationUnits = new ArrayList<>();
        compilationUnitsTests = new ArrayList<>();
        compilationUnitFunctions = new ArrayList<>();
        testableUnits = new ArrayList<>();
        //testScenario = new ArrayList<>();
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

    public TestScenario getTestScenario() {
        return testScenario;
    }

    public void setTestScenario(TestScenario testScenario) {
        this.testScenario = testScenario;
    }

    public UnitTest getUnitTest() {
        return unitTest;
    }

    public void setUnitTest(UnitTest unitTest) {
        this.unitTest = unitTest;
    }

    public ArrayList<UnitTest> getUnitTests() {
        return unitTests;
    }
}
