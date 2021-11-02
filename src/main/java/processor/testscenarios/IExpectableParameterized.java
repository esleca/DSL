package processor.testscenarios;

import models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public interface IExpectableParameterized {

    ArrayList<ValueType> getExpected(JSONObject configurationObject);

}
