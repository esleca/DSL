package processor.testscenarios;

import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import testrun.config.TestScenarioRun;

import java.util.ArrayList;

public interface IProcessorHandlerTestScenario {

    ArrayList<TestScenarioRun> readTestScenariosRun(String scenariosPath);

    ArrayList<TestScenario> getTestScenarios(ArrayList<TestScenarioRun> testScenarioRuns,
                                             ArrayList<TestableUnit> testableUnits);
}
