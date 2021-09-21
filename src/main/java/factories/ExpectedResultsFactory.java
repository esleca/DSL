package factories;

import models.entities.unittests.ExpectedResult;
import models.entities.valuetypes.ValueType;

public class ExpectedResultsFactory {

    public ExpectedResult createExpectedResult(ValueType valueType){
        ExpectedResult result = new ExpectedResult(valueType);
        return result;
    }
}
