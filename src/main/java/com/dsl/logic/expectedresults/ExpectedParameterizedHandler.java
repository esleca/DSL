package com.dsl.logic.expectedresults;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.models.valuetypes.ValueType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ExpectedParameterizedHandler implements IExpectedParameterizedHandler {

    @Override
    public ArrayList<ValueType> getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException {
        ArrayList<ValueType> valueTypes = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) configurationObject.get("expected");

        for (Object rawObject : jsonArray) {
            JSONObject expectedObject = (JSONObject) rawObject;

            String type = (String) expectedObject.get("type");
            Object objValue = expectedObject.get("value");

            ValueType valueType = ValueTypeFactory.createValueType(type, objValue);
            valueTypes.add(valueType);
        }

        return valueTypes;
    }

}
