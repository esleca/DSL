package com.dsl.logic.expectedresults;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.valuetypes.ValueType;
import org.json.simple.JSONObject;

public interface IExpectedPrimitiveHandler {

    ValueType getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException;

}
