package factories;

import models.entities.aggregates.Function;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.ExpectedResult;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import models.entities.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public interface ITestableUnitFactory {

    TestScenario createTestScenario(String testName, TestableUnit testableUnit, ArrayList<ParameterScenario> parameters, ExpectedResult expectedResult, AssertType assertion);

    TestableUnit createTestableUnit(Function function);
}
