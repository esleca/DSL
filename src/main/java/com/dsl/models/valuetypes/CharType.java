package com.dsl.models.valuetypes;

import static com.dsl.utils.Constants.VALUE_TYPE_CHAR;

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

	@Override
	public String getType() {
		return VALUE_TYPE_CHAR;
	}
}
