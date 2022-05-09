package com.dsl.logic.expectedresults;

import org.json.simple.JSONObject;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.models.valuetypes.ValueType;

public class ExpectedInstanceHandler implements IExpectedInstanceHandler {

	@Override
	public ValueType getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException {
		JSONObject expectedObject = (JSONObject) configurationObject.get("expected");

        String type = (String) expectedObject.get("type");
        Object objValue = expectedObject.get("value");

        return ValueTypeFactory.createValueType(type, objValue);
	}

}
