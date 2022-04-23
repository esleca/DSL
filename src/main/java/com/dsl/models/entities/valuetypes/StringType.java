package com.dsl.models.entities.valuetypes;

public class StringType extends ValueType {

    private String value;

    @Override
    public void setValue(Object value) {
        this.value = (String) value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
