package processor.testscenarios;

import exceptions.ValueTypeNotFoundException;
import factories.ValueTypeFactory;
import models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

public class ExpectedPrimitiveHandler implements IExpectedPrimitive {

    @Override
    public ValueType getExpected(JSONObject configurationObject) throws ValueTypeNotFoundException {
        JSONObject expectedObject = (JSONObject) configurationObject.get("expected");

        String type = (String) expectedObject.get("type");
        Object objValue = expectedObject.get("value");

        return ValueTypeFactory.createValueType(type, objValue);
    }

}
