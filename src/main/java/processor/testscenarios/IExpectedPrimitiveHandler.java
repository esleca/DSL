package processor.testscenarios;

import exceptions.ValueTypeNotFoundException;
import models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

public interface IExpectedPrimitiveHandler {

    ValueType getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException;

}
