package com.dsl.models.valuetypes;

public class LongType extends ValueType {

    private long value;

    @Override
    public void setValue(Object value) {
    	this.value = Long.parseLong((String) value);
    }

    @Override
    public Object getValue() {
        return value;
    }
}
