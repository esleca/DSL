package models.entities.unittests;

import models.entities.valuetypes.ValueType;

public class ExpectedResult {

    private ValueType valueType;

    public ExpectedResult(ValueType valueType){
        this.valueType = valueType;
    }

    public ValueType getValueType() {
        return valueType;
    }

}
