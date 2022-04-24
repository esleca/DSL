package com.dsl.logic.testscenarios;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ParametersFactory;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.parameters.ParameterFunction;
import com.dsl.models.entities.parameters.ParameterScenario;
import com.dsl.models.entities.valuetypes.ValueType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class TestScenarioHandlerBase {

    protected final IExpectedPrimitiveHandler _expectedPrimitiveHandler;
    protected final IExpectedParameterizedHandler _expectedParameterizedHandler;

    public TestScenarioHandlerBase(IExpectedPrimitiveHandler expectedPrimitive, IExpectedParameterizedHandler expectedParameterized){
        this._expectedPrimitiveHandler = expectedPrimitive;
        this._expectedParameterizedHandler = expectedParameterized;
    }


    protected ArrayList<ParameterScenario> getParameterScenarios(JSONArray paramsArray) throws ValueTypeNotFoundException {
        ArrayList<ParameterScenario> parameterScenarios = new ArrayList<>();

        for (Object paramRawObject : paramsArray) {
            JSONObject paramObject = (JSONObject) paramRawObject;
            ParameterScenario parameterScenario = getParameterScenario(paramObject);
            parameterScenarios.add(parameterScenario);
        }
        return parameterScenarios;
    }


    protected ParameterScenario getParameterScenario(JSONObject paramObject) throws ValueTypeNotFoundException {
        Object value = paramObject.get("value");
        String name = (String) paramObject.get("name");
        String type = (String) paramObject.get("type");

        ValueType valueType = ValueTypeFactory.createValueType(type, value);
        ParameterFunction parameterFunction = ParametersFactory.createParameterFunction(type, name);

        return ParametersFactory.createParameterScenario(parameterFunction, valueType);
    }


    protected Function getFunction(String functionName, ArrayList<Function> testableUnits) {
        for (Function function : testableUnits) {
            if (function.getName().equals((functionName))){
                return function;
            }
        }
        return null;
    }

}
