package com.dsl.models.entities.parameters;

import com.dsl.models.entities.valuetypes.ValueType;

public class ParameterScenario {

    private ParameterFunction parameterFunction;
    private ValueType valueType;

    public ParameterScenario(ParameterFunction parameterFunction, ValueType valueType){
        this.parameterFunction = parameterFunction;
        this.valueType = valueType;
    }

    public ParameterFunction getParameterFunction() {
        return parameterFunction;
    }

    public void setParameterFunction(ParameterFunction parameterFunction) {
        this.parameterFunction = parameterFunction;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }
}
