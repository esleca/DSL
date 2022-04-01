package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import models.entities.aggregates.Function;
import models.entities.unittests.TestScenario;
import testrun.config.TestScenarioRun;

import java.util.ArrayList;

public interface ITestScenarioHandler {

    ArrayList<TestScenarioRun> processTestScenariosRun(String scenariosPath);

    ArrayList<TestScenario> processTestScenarios(ArrayList<TestScenarioRun> testScenarioRuns, ArrayList<Function> functions)
            throws ValueTypeNotFoundException, AssertNotFoundException;

}
