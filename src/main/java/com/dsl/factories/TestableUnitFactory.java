package com.dsl.factories;

import com.dsl.models.aggregates.Function;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class TestableUnitFactory {

    public static TestScenario createTestScenario(String testName, Function function, ArrayList<ParameterScenario> parameters, ExpectedResult expectedResult, AssertType assertion){
        TestScenario testScenario = new TestScenario(testName, function, parameters, expectedResult, assertion);
        return testScenario;
    }

}
