package models.entities.unittests;

import models.entities.valuetypes.ValueType;

public class PrimitiveExpectedResult extends ExpectedResult {

    private ValueType valueType;

    public PrimitiveExpectedResult(ValueType valueType){
        this.valueType = valueType;
    }

    public ValueType getValueType() {
        return valueType;
    }

}
