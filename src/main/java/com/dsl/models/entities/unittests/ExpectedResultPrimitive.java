package com.dsl.models.entities.unittests;

import com.dsl.models.entities.valuetypes.ValueType;

public class ExpectedResultPrimitive extends ExpectedResult {

    private ValueType valueType;

    public ExpectedResultPrimitive(ValueType valueType){
        this.valueType = valueType;
    }

    public ValueType getValueType() {
        return valueType;
    }

}
