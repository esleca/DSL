package processor.testscenarios;

import models.entities.valuetypes.ValueType;
import org.json.simple.JSONObject;
import java.util.ArrayList;


public class ExpectableParameterizedHandler implements IExpectableParameterized{

    public ExpectableParameterizedHandler(){
    }

    @Override
    public ArrayList<ValueType> getExpected(JSONObject configurationObject) {
        return null;
    }

}
