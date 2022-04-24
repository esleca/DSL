package com.dsl.models.entities.valuetypes;

public class CharType extends ValueType {

    private char value;

    @Override
    public void setValue(Object value) {
    	String valueCast = (String) value;
        this.value = valueCast.charAt(0);
    }

    @Override
    public Object getValue() {
        return value;
    }
}
