package com.dsl.logic.testscenarios;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.unittests.TestScenario;

import java.util.ArrayList;

public interface ITestScenarioHandler {

    TestScenario processTestScenario(UnitTestRequest request, ArrayList<Function> testableUnits) throws ValueTypeNotFoundException, AssertNotFoundException;
}
