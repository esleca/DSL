package com.dsl.models.valuetypes;

import static com.dsl.utils.Constants.VALUE_TYPE_LONG;

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

	@Override
	public String getType() {
		return VALUE_TYPE_LONG;
	}
}
