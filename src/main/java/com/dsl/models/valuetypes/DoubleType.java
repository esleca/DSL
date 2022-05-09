package com.dsl.models.valuetypes;

import static com.dsl.utils.Constants.VALUE_TYPE_DOUBLE;

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

	@Override
	public String getType() {
		return VALUE_TYPE_DOUBLE;
	}
}
