package factories;

import models.entities.parameters.ParameterFunction;
import models.entities.parameters.ParameterScenario;
import models.entities.valuetypes.ValueType;

public interface IParametersFactory {

    ParameterFunction createParameterFunction();

    ParameterFunction createParameterFunction(String type, String name);

    ParameterScenario createParameterScenario(ParameterFunction parameterFunction, ValueType valueType);
}
