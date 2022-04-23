package com.dsl.logic.testscenarios;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;

import com.dsl.models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

import org.springframework.stereotype.Component;

@Component
public class ExpectedPrimitiveHandler implements IExpectedPrimitiveHandler {

    @Override
    public ValueType getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException {
        JSONObject expectedObject = (JSONObject) configurationObject.get("expected");

        String type = (String) expectedObject.get("type");
        Object objValue = expectedObject.get("value");

        return ValueTypeFactory.createValueType(type, objValue);
    }

}
