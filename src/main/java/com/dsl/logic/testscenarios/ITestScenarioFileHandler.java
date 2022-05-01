package com.dsl.logic.testscenarios;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.aggregates.Function;
import com.dsl.models.unittests.TestScenario;
import com.dsl.testrun.config.TestScenarioRun;

import java.util.ArrayList;

public interface ITestScenarioFileHandler {

    ArrayList<TestScenarioRun> processTestScenariosRun(String scenariosPath);

    ArrayList<TestScenario> processTestScenarios(ArrayList<TestScenarioRun> testScenarioRuns, ArrayList<Function> functions)
            throws ValueTypeNotFoundException, AssertNotFoundException;

}
