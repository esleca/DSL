package factories;

import models.entities.unittests.ExpectedResult;
import models.entities.valuetypes.ValueType;

public interface IExpectedResultsFactory {

    ExpectedResult createExpectedResult(ValueType valueType);
}
