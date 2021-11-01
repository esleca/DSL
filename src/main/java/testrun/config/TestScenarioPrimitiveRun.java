package testrun.config;

import models.entities.parameters.ParameterScenario;

import java.util.ArrayList;

public class TestScenarioPrimitiveRun extends TestScenarioRun {

    private final String expected;

    public TestScenarioPrimitiveRun(String function, String name, ArrayList<ParameterScenario> parameters, String expected, String assertion) {
        super(function, name, parameters, assertion);
        this.expected = expected;
    }

    public String getExpected() {
        return this.expected;
    }

}
