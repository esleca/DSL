package processor.testscenarios;

import models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

public interface IExpectablePrimitive {

    ValueType getExpected(JSONObject configurationObject);

}
