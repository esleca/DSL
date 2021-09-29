package testrun.config;

import models.entities.parameters.ParameterScenario;
import java.util.ArrayList;

public class TestScenarioRun {

    private final String function;
    private final String name;
    private final ArrayList<ParameterScenario> parameters;
    private final String expected;
    private final String assertion;

    public TestScenarioRun(String function, String name, ArrayList<ParameterScenario> parameters, String expected, String assertion) {
        this.function = function;
        this.name = name;
        this.parameters = parameters;
        this.expected = expected;
        this.assertion = assertion;
    }

    public String getFunction() {
        return this.function;
    }

    public String getTestName(){
        return this.name;
    }

    public ArrayList<ParameterScenario> getParameters() {
        return this.parameters;
    }

    public String getExpected() {
        return this.expected;
    }

    public String getAssertion() {
        return this.assertion;
    }
}
