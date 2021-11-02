package processor.testscenarios;

import models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;

public class ExpectablePrimitiveHandler implements IExpectablePrimitive {

    public ExpectablePrimitiveHandler(){
    }

    @Override
    public ValueType getExpected(JSONObject configurationObject) {
        return (ValueType) configurationObject.get("expected");
    }

}
