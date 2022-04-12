package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import models.dtos.UnitTestRequest;
import models.entities.aggregates.Function;
import models.entities.unittests.TestScenario;

import java.util.ArrayList;

public interface ITestScenarioHandler {

    TestScenario processTestScenario(UnitTestRequest request, ArrayList<Function> testableUnits) throws ValueTypeNotFoundException, AssertNotFoundException;
}
