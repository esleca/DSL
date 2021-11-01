package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import org.json.simple.JSONObject;
import testrun.config.TestScenarioRun;

public interface ITestScenarioRunHandler {

    TestScenarioRun getTestScenarioRun(JSONObject configurationObject)
            throws ClassCastException, ValueTypeNotFoundException;

    TestScenario getTestScenario(TestScenarioRun testScenarioRun, TestableUnit testableUnit)
            throws ValueTypeNotFoundException, AssertNotFoundException;

}
