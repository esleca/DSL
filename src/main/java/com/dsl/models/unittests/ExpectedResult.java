package com.dsl.models.unittests;

import com.dsl.models.valuetypes.ValueType;

public abstract class ExpectedResult {
	
	public abstract ValueType getValueType();
	
	public abstract String getExpectedType();
}
