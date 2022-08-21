package com.dsl.services.testscenarios;

import org.springframework.stereotype.Component;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.testscenarios.ITestScenarioHandler;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.TestScenario;


@Component
public class TestScenarioService implements ITestScenarioService {

	private ITestScenarioHandler _testScenarioHandler;

	public TestScenarioService(ITestScenarioHandler inTestScenarioHandler) {
		this._testScenarioHandler = inTestScenarioHandler;
	}
	
	
	@Override
	public void processTestScenario(UnitTestRequest unitTestRequest, DSLModel model) throws ValueTypeNotFoundException, AssertNotFoundException {
		TestScenario testScenario = _testScenarioHandler.processTestScenario(unitTestRequest, model.getTestableUnits());
        model.setTestScenario(testScenario);
	}
}
