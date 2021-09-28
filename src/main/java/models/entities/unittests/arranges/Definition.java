package models.entities.unittests.arranges;

import models.entities.valuetypes.ValueType;

public class Definition {

    private ValueType valueType;

    public Definition (ValueType valueType){
        this.valueType = valueType;
    }


    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

}
