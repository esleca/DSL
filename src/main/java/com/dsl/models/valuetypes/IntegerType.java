package com.dsl.models.valuetypes;

import static com.dsl.utils.Constants.VALUE_TYPE_INTEGER;

public class IntegerType extends ValueType {

    private int value;

    @Override
    public void setValue(Object value) {
    	this.value = Integer.parseInt(String.valueOf(value));
    }

    @Override
    public Object getValue() {
        return value;
    }

	@Override
	public String getType() {
		return VALUE_TYPE_INTEGER;
	}
}
