package com.dsl.models.unittests;

import com.dsl.models.valuetypes.ValueType;

public class ExpectedResultPrimitive extends ExpectedResult {

    private ValueType valueType;

    public ExpectedResultPrimitive(ValueType valueType){
        this.valueType = valueType;
    }

    @Override
    public ValueType getValueType() {
        return valueType;
    }
    
    @Override
    public String getExpectedType() {
    	return valueType.getType();
    }

}
