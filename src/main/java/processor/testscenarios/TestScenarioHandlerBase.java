package processor.testscenarios;

import exceptions.ValueTypeNotFoundException;
import factories.ParametersFactory;
import factories.ValueTypeFactory;
import models.entities.aggregates.Function;
import models.entities.parameters.ParameterFunction;
import models.entities.parameters.ParameterScenario;
import models.entities.valuetypes.ValueType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class TestScenarioHandlerBase {

    protected final IExpectedPrimitiveHandler expectedPrimitive;
    protected final IExpectedParameterizedHandler expectedParameterized;

    public TestScenarioHandlerBase(IExpectedPrimitiveHandler expectedPrimitive, IExpectedParameterizedHandler expectedParameterized){
        this.expectedPrimitive = expectedPrimitive;
        this.expectedParameterized = expectedParameterized;
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
