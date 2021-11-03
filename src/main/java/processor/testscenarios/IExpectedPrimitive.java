package processor.testscenarios;

import exceptions.ValueTypeNotFoundException;
import models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

public interface IExpectedPrimitive {

    ValueType getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException;

}
