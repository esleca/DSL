package models.entities.unittests;

import models.entities.aggregates.Function;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class TestScenario {

    private String testName;
    private Function function;
    private ArrayList<ParameterScenario> parameters;
    private ExpectedResult expectedResult;
    private AssertType assertType;
    private UnitTest unitTest;


    public TestScenario(String testName, Function function, ArrayList<ParameterScenario> parameters, ExpectedResult expectedResult, AssertType assertType) {
        this.testName = testName;
        this.function = function;
        this.parameters = parameters;
        this.expectedResult = expectedResult;
        this.assertType = assertType;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public ArrayList<ParameterScenario> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<ParameterScenario> parameters) {
        this.parameters = parameters;
    }

    public ExpectedResult getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(ExpectedResult expectedResult) {
        this.expectedResult = expectedResult;
    }

    public AssertType getAssertType() {
        return assertType;
    }

    public void setAssertType(AssertType assertType) {
        this.assertType = assertType;
    }

    public UnitTest getUnitTest() {
        return unitTest;
    }

    public void setUnitTest(UnitTest unitTest) {
        this.unitTest = unitTest;
    }
}
