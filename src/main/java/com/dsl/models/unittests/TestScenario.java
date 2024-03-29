package com.dsl.models.unittests;

import com.dsl.models.aggregates.Function;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class TestScenario {

    private String testName;
    private Function function;
    private ArrayList<ParameterScenario> parameters;
    private ExpectedResult expectedResult;
    private String assertion;
    private AssertType assertType;


    public TestScenario(String testName, Function function, ArrayList<ParameterScenario> parameters, ExpectedResult expectedResult, String initialAssert, AssertType assertType) {
        this.testName = testName;
        this.function = function;
        this.parameters = parameters;
        this.expectedResult = expectedResult;
        this.assertion = initialAssert;
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

    public String getAssertion() {
        return assertion;
    }

    public void setAssertType(String initialAssert) {
        this.assertion = initialAssert;
    }
    
    public AssertType getAssertType() {
        return assertType;
    }

    public void setAssertType(AssertType assertType) {
        this.assertType = assertType;
    }
}
