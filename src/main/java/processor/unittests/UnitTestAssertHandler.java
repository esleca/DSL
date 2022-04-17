package processor.unittests;

import exceptions.AssertNotFoundException;
import factories.AssertsFactory;
import factories.UnitTestFactory;
import models.entities.unittests.asserts.Assert;
import models.entities.unittests.TestScenario;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.unittests.FunctionArgument;
import models.entities.unittests.asserts.types.AssertType;
import java.util.ArrayList;

import static utils.Constants.ASSERT_CLASS;

public class UnitTestAssertHandler implements IUnitTestAssertHandler {

    @Override
    public Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException {
        ArrayList<AssertExpression> expressions = new ArrayList<>();
        AssertExpression expression = getAssertExpression(testScenario);
        expressions.add(expression);

        return UnitTestFactory.createAssert(expressions);
    }

    private AssertExpression getAssertExpression(TestScenario testScenario) throws AssertNotFoundException {
        String assertName = testScenario.getAssertType().getName();
        AssertType assertType = AssertsFactory.createAssertType(assertName);
        ArrayList<FunctionArgument> assertParameters = assertType.getAssertArguments();

        return UnitTestFactory.createAssertExpression(ASSERT_CLASS, assertType, assertParameters);
    }

}
