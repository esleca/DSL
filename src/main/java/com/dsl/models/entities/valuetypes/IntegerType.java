package com.dsl.models.entities.valuetypes;

public class IntegerType extends ValueType {

    private int value;

    @Override
    public void setValue(Object value) {
    	this.value = Integer.parseInt((String) value);
    }

    @Override
    public Object getValue() {
        return value;
    }
}
