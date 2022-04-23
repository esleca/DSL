package com.dsl.logic.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.factories.AssertsFactory;
import com.dsl.factories.UnitTestFactory;
import com.dsl.models.entities.unittests.asserts.Assert;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.asserts.AssertExpression;
import com.dsl.models.entities.unittests.FunctionArgument;
import com.dsl.models.entities.unittests.asserts.types.AssertType;
import java.util.ArrayList;

import static com.dsl.utils.Constants.ASSERT_CLASS;

import org.springframework.stereotype.Component;

@Component
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
