package com.dsl.models.entities.valuetypes;

public class CharType extends ValueType {

    private char value;

    @Override
    public void setValue(Object value) {
        this.value = (char) value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
