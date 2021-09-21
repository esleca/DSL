package factories;

import models.entities.aggregates.Function;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.ExpectedResult;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;

import java.util.ArrayList;


public class TestableFactory {

    /**
     *
     * @param testableUnit
     * @param parameters
     * @param expectedResult
     * @return
     */
    public TestScenario createTestScenario(TestableUnit testableUnit, ArrayList<ParameterScenario> parameters, ExpectedResult expectedResult){
        TestScenario testScenario = new TestScenario(testableUnit, parameters, expectedResult);
        return testScenario;
    }

    /**
     *
     * @param function
     * @return
     */
    public TestableUnit createTestableUnit(Function function){
        TestableUnit testableUnit = new TestableUnit(function);
        return testableUnit;
    }

}
