package com.dsl.models.valuetypes;

import static com.dsl.utils.Constants.VALUE_TYPE_BOOLEAN;

public class BooleanType extends ValueType {

    private boolean value;

    @Override
    public void setValue(Object value) {
        if (value.equals("true")) {
            this.value = true;
        }else{
            this.value = false;
        }
    }

    @Override
    public Object getValue() {
        return value;
    }

	@Override
	public String getType() {
		return VALUE_TYPE_BOOLEAN;
	}

}
