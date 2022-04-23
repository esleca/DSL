package com.dsl.models.entities.valuetypes;

public class FloatType extends ValueType {

    private float value;

    @Override
    public void setValue(Object value) {
        this.value = (float) value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
