package com.dsl.models.entities.valuetypes;

public class IntegerType extends ValueType {

    private long value;

    @Override
    public void setValue(Object value) {
        this.value = (long) value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
