package factories;

import models.entities.unittests.ExpectedResult;
import models.entities.unittests.ParameterizedExpectedResult;
import models.entities.unittests.PrimitiveExpectedResult;
import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class ExpectedResultsFactory implements IExpectedResultsFactory {

    @Override
    public ExpectedResult createPrimitiveExpectedResult(ValueType valueType){
        ExpectedResult result = new PrimitiveExpectedResult();
        return result;
    }

    @Override
    public ExpectedResult createParameterizedExpectedResult(ArrayList<ValueType> argumentTypes){
        ExpectedResult result = new ParameterizedExpectedResult(argumentTypes);
        return result;
    }

}
