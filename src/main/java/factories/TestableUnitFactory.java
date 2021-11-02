package factories;

import models.entities.aggregates.Function;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.ExpectedResult;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import models.entities.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class TestableUnitFactory {

    public static TestScenario createTestScenario(String testName, TestableUnit testableUnit, ArrayList<ParameterScenario> parameters, ExpectedResult expectedResult, AssertType assertion){
        TestScenario testScenario = new TestScenario(testName, testableUnit, parameters, expectedResult, assertion);
        return testScenario;
    }

    public static TestableUnit createTestableUnit(Function function){
        TestableUnit testableUnit = new TestableUnit(function);
        return testableUnit;
    }

}
