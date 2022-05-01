package com.dsl.models.valuetypes;

public class DoubleType extends ValueType {

    private double value;

    @Override
    public void setValue(Object value) {
    	this.value = Double.parseDouble((String) value);
    }

    @Override
    public Object getValue() {
        return value;
    }
}
