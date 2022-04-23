package com.dsl.logic.testscenarios;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

public interface IExpectedPrimitiveHandler {

    ValueType getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException;

}
