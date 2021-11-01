package factories;

import models.entities.unittests.ExpectedResult;
import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public interface IExpectedResultsFactory {

    ExpectedResult createPrimitiveExpectedResult(ValueType valueType);

    ExpectedResult createParameterizedExpectedResult(ArrayList<ValueType> argumentTypes);

}
