package com.dsl.logic.expectedresults;

import org.json.simple.JSONObject;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.valuetypes.ValueType;

public interface IExpectedInstanceHandler {
	
	ValueType getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException;
}
