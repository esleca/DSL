package models.entities.unittests;

import models.entities.valuetypes.ValueType;

public abstract class ExpectedResult {

    private ValueType valueType;

//    public ExpectedResult(ValueType valueType){
//        this.valueType = valueType;
//    }

    public ValueType getValueType() {
        return valueType;
    }

}
