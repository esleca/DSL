package testrun.config;

import models.entities.parameters.ParameterScenario;
import java.util.ArrayList;

public class TestScenarioRun {

    private final String function;
    private final String name;
    private final ArrayList<ParameterScenario> parameters;
    private final String expected;

    public TestScenarioRun(String function, String name, ArrayList<ParameterScenario> parameters, String expected) {
        this.function = function;
        this.name = name;
        this.parameters = parameters;
        this.expected = expected;
    }

    public String getFunction() {
        return function;
    }

    public ArrayList<ParameterScenario> getParameters() {
        return parameters;
    }

    public String getExpected() {
        return expected;
    }
}
