package com.dsl.logic.testscenarios;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ParametersFactory;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.valuetypes.ValueType;


@Component
public class ParameterScenarioHandler implements IParameterScenarioHandler {

	@Override
	public ArrayList<ParameterScenario> getParameterScenarios(JSONArray paramsArray) throws ValueTypeNotFoundException {
        ArrayList<ParameterScenario> parameterScenarios = new ArrayList<>();

        for (Object paramRawObject : paramsArray) {
            JSONObject paramObject = (JSONObject) paramRawObject;
            ParameterScenario parameterScenario = this.getParameterScenario(paramObject);
            parameterScenarios.add(parameterScenario);
        }
        return parameterScenarios;
    }


    private ParameterScenario getParameterScenario(JSONObject paramObject) throws ValueTypeNotFoundException {
        Object value = paramObject.get("value");
        String name = (String) paramObject.get("name");
        String type = (String) paramObject.get("type");

        ValueType valueType = ValueTypeFactory.createValueType(type, value);
        ParameterFunction parameterFunction = ParametersFactory.createParameterFunction(type, name);

        return ParametersFactory.createParameterScenario(parameterFunction, valueType);
    }

}
