package testrun.config;

import models.entities.parameters.ParameterScenario;
import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class TestScenarioPrimitiveRun extends TestScenarioRun {

    private ValueType expected;

    public TestScenarioPrimitiveRun(String function, String name, ArrayList<ParameterScenario> parameters, String assertion) {
        super(function, name, parameters, assertion);
    }

    public ValueType getExpected() {
        return this.expected;
    }

    public void setExpected(ValueType expected) {
        this.expected = expected;
    }

}
