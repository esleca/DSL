package com.dsl.logic.unittests.asserts;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.AssertTypesFactory;
import com.dsl.factories.UnitTestFactory;
import com.dsl.models.unittests.asserts.Assert;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.AssertExpression;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.asserts.types.AssertType;

import static com.dsl.utils.Constants.CSHARP_ASSERT_CLASS;
import static com.dsl.utils.Constants.LANGUAGE_CSHARP;

import java.util.ArrayList;
import org.springframework.stereotype.Component;


@Component
public class UnitTestAssertCSharpHandler implements IUnitTestAssertHandler {

    @Override
    public Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException, ValueTypeNotFoundException {
        ArrayList<AssertExpression> expressions = new ArrayList<>();
        AssertExpression expression = getAssertExpression(testScenario);
        expressions.add(expression);

        return UnitTestFactory.createAssert(expressions);
    }

    private AssertExpression getAssertExpression(TestScenario testScenario) throws AssertNotFoundException, ValueTypeNotFoundException {
    	String assertName = testScenario.getInitialAssert();
        AssertType assertType = AssertTypesFactory.createAssertType(assertName, LANGUAGE_CSHARP);
        ArrayList<FunctionArgument> assertParameters = assertType.getAssertArguments();

        return UnitTestFactory.createAssertExpression(CSHARP_ASSERT_CLASS, assertType, assertParameters);
    }
}
