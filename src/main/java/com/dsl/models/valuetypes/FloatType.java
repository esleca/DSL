package com.dsl.models.valuetypes;

import static com.dsl.utils.Constants.VALUE_TYPE_FLOAT;

public class FloatType extends ValueType {

    private float value;

    @Override
    public void setValue(Object value) {
        this.value = Float.parseFloat((String) value);
    }

    @Override
    public Object getValue() {
        return value;
    }

	@Override
	public String getType() {
		return VALUE_TYPE_FLOAT;
	}
}
