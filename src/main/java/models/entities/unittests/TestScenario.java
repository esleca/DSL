package models.entities.unittests;

import models.entities.parameters.ParameterScenario;
import models.entities.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class TestScenario {

    private String testName;
    private TestableUnit testableUnit;
    private ArrayList<ParameterScenario> parameters;
    private ExpectedResult expectedResult;
    private AssertType assertType;
    private UnitTest testUnit;


    public TestScenario(String testName, TestableUnit testableUnit, ArrayList<ParameterScenario> parameters, ExpectedResult expectedResult, AssertType assertType) {
        this.testName = testName;
        this.testableUnit = testableUnit;
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

    public TestableUnit getTestableUnit() {
        return testableUnit;
    }

    public void setTestableUnit(TestableUnit testableUnit) {
        this.testableUnit = testableUnit;
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

    public UnitTest getTestUnit() {
        return testUnit;
    }

    public void setTestUnit(UnitTest testUnit) {
        this.testUnit = testUnit;
    }
}
