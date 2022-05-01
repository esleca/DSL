package com.dsl.testrun.config;

import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.valuetypes.ValueType;

import java.util.ArrayList;

public class TestScenarioParameterizedRun extends TestScenarioRun {

    private ArrayList<ValueType> expected;

    public TestScenarioParameterizedRun(String function, String name, ArrayList<ParameterScenario> parameters, String assertion) {
        super(function, name, parameters, assertion);
    }

    public  ArrayList<ValueType> getExpected() {
        return this.expected;
    }

    public void setExpected(ArrayList<ValueType> expected) {
        this.expected = expected;
    }

}
