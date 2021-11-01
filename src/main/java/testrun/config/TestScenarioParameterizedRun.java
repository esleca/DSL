package testrun.config;

import models.entities.parameters.ParameterScenario;
import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class TestScenarioParameterizedRun extends TestScenarioRun {

    private final ArrayList<ValueType> expected;

    public TestScenarioParameterizedRun(String function, String name, ArrayList<ParameterScenario> parameters, ArrayList<ValueType> expected, String assertion) {
        super(function, name, parameters, assertion);
        this.expected = expected;
    }

    public  ArrayList<ValueType> getExpected() {
        return this.expected;
    }

}
