package processor.unittests;

import exceptions.AssertNotFoundException;
import factories.AssertsFactory;
import factories.UnitTestFactory;
import models.entities.unittests.asserts.Assert;
import models.entities.unittests.TestScenario;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.unittests.FunctionArgument;
import models.entities.unittests.asserts.types.AssertType;
import utils.Constants;

import java.util.ArrayList;

public class UnitTestAssertHandler implements IUnitTestAssertHandler {

    private UnitTestFactory unitTestFactory;
    private AssertsFactory assertsFactory;

    public UnitTestAssertHandler(){
        unitTestFactory = new UnitTestFactory();
        assertsFactory = new AssertsFactory();
    }

    @Override
    public Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException {
        ArrayList<AssertExpression> expressions = new ArrayList<>();
        AssertExpression expression = getAssertExpression(testScenario);
        expressions.add(expression);

        return unitTestFactory.createAssert(expressions);
    }

    private AssertExpression getAssertExpression(TestScenario testScenario) throws AssertNotFoundException {
        String assertName = testScenario.getAssertType().getName();
        AssertType assertType = assertsFactory.createAssertType(assertName);
        ArrayList<FunctionArgument> assertParameters = assertType.getAssertArguments();

        return unitTestFactory.createAssertExpression(Constants.ASSERT_CLASS, assertType, assertParameters);
    }

}
