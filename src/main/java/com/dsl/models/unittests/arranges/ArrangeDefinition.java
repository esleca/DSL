package com.dsl.models.unittests.arranges;

import com.dsl.models.valuetypes.ValueType;

public class ArrangeDefinition {

    private ValueType valueType;

    public ArrangeDefinition(ValueType valueType){
        this.valueType = valueType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

}
