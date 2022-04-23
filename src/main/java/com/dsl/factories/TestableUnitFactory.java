package com.dsl.factories;

import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.parameters.ParameterScenario;
import com.dsl.models.entities.unittests.ExpectedResult;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class TestableUnitFactory {

    public static TestScenario createTestScenario(String testName, Function function, ArrayList<ParameterScenario> parameters, ExpectedResult expectedResult, AssertType assertion){
        TestScenario testScenario = new TestScenario(testName, function, parameters, expectedResult, assertion);
        return testScenario;
    }

}
