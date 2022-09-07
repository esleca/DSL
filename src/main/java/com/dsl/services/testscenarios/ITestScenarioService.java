package com.dsl.services.testscenarios;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;

public interface ITestScenarioService {

	void processTestScenario(UnitTestRequest unitTestRequest, DSLModel model) throws ValueTypeNotFoundException, AssertNotFoundException;
}
