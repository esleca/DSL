package processor.testscenarios;

import exceptions.ValueTypeNotFoundException;
import factories.ValueTypeFactory;
import models.entities.parameters.ParameterScenario;
import models.entities.valuetypes.ValueType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class ExpectedParameterizedHandler implements IExpectedParameterized {

    @Override
    public ArrayList<ValueType> getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException {
        ArrayList<ValueType> valueTypes = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) configurationObject.get("expected");

        for (Object rawObject : jsonArray) {
            JSONObject expectedObject = (JSONObject) rawObject;

            String type = (String) expectedObject.get("type");
            Object objValue = expectedObject.get("value");

            ValueType valueType = ValueTypeFactory.createValueType(type, objValue);
            valueTypes.add(valueType);
        }

        return valueTypes;
    }

}
