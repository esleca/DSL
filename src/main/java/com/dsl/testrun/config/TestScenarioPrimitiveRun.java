package com.dsl.testrun.config;

import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.valuetypes.ValueType;

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
