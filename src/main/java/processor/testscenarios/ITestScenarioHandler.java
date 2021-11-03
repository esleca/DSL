package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import testrun.config.TestScenarioRun;

import java.util.ArrayList;

public interface ITestScenarioHandler {

    ArrayList<TestScenarioRun> processTestScenariosRun(String scenariosPath);

    ArrayList<TestScenario> processTestScenarios(ArrayList<TestScenarioRun> testScenarioRuns, ArrayList<TestableUnit> testableUnits)
            throws ValueTypeNotFoundException, AssertNotFoundException;

}
