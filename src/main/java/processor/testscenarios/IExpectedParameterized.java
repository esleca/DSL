package processor.testscenarios;

import exceptions.ValueTypeNotFoundException;
import models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public interface IExpectedParameterized {

    ArrayList<ValueType> getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException;

}
