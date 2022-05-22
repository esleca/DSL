package com.dsl.models.valuetypes;

import static com.dsl.utils.Constants.VALUE_TYPE_STRING;

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
    
	@Override
	public String getType() {
		return VALUE_TYPE_STRING;
	}
}
