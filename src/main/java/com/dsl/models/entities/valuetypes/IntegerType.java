package com.dsl.models.entities.valuetypes;

public class IntegerType extends ValueType {

    private int value;

    @Override
    public void setValue(Object value) {
        this.value = (int) value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
