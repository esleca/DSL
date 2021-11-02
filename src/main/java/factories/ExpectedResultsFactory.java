package factories;

import models.entities.unittests.ExpectedResult;
import models.entities.unittests.ParameterizedExpectedResult;
import models.entities.unittests.PrimitiveExpectedResult;
import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class ExpectedResultsFactory {

    public static ExpectedResult createPrimitiveExpectedResult(ValueType valueType){
        return new PrimitiveExpectedResult();
    }

    public static ExpectedResult createParameterizedExpectedResult(ArrayList<ValueType> argumentTypes){
        return new ParameterizedExpectedResult(argumentTypes);
    }

}
