package com.dsl.logic.expectedresults;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.valuetypes.ValueType;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public interface IExpectedParameterizedHandler {

    ArrayList<ValueType> getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException;

}
