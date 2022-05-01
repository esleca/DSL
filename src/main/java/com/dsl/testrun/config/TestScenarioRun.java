package com.dsl.testrun.config;

import com.dsl.models.parameters.ParameterScenario;
import java.util.ArrayList;

public abstract class TestScenarioRun {

    private final String function;
    private final String name;
    private final ArrayList<ParameterScenario> parameters;
    private final String assertion;

    public TestScenarioRun(String function, String name, ArrayList<ParameterScenario> parameters, String assertion) {
        this.function = function;
        this.name = name;
        this.parameters = parameters;
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

    public String getAssertion() {
        return this.assertion;
    }
}
