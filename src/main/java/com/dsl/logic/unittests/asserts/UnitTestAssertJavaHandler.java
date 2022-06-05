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

import static com.dsl.utils.Constants.JAVA_ASSERT_CLASS;
import static com.dsl.utils.Constants.LANGUAGE_JAVA;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class UnitTestAssertJavaHandler implements IUnitTestAssertHandler {

    @Override
    public Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException, ValueTypeNotFoundException {
        ArrayList<AssertExpression> expressions = new ArrayList<>();
        AssertExpression expression = getAssertExpression(testScenario);
        expressions.add(expression);

        return UnitTestFactory.createAssert(expressions);
    }

    protected AssertExpression getAssertExpression(TestScenario testScenario) throws AssertNotFoundException, ValueTypeNotFoundException {
    	String assertName = testScenario.getAssertion();
        AssertType assertType = AssertTypesFactory.createAssertType(assertName, LANGUAGE_JAVA);
        ArrayList<FunctionArgument> assertParameters = assertType.getAssertArguments();

        return UnitTestFactory.createAssertExpression(JAVA_ASSERT_CLASS, assertType, assertParameters);
    }
}
