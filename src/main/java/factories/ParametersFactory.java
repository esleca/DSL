package factories;

import models.entities.parameters.ParameterFunction;
import models.entities.parameters.ParameterScenario;
import models.entities.valuetypes.ValueType;

public class ParametersFactory {

    public static ParameterFunction createParameterFunction(){
        ParameterFunction parameterFunction = new ParameterFunction();
        return parameterFunction;
    }

    public static ParameterFunction createParameterFunction(String type, String name){
        ParameterFunction parameterFunction = new ParameterFunction(type, name);
        return parameterFunction;
    }

    public static ParameterScenario createParameterScenario(ParameterFunction parameterFunction, ValueType valueType){
        ParameterScenario parameterScenario = new ParameterScenario(parameterFunction, valueType);
        return parameterScenario;
    }
}
