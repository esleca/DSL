package com.dsl.services.testableunits;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.testableunits.ITestableUnitHandler;
import com.dsl.models.aggregates.Function;


@Component
public class TestableUnitsService implements ITestableUnitsService {
	
	private ITestableUnitHandler _testableUnitHandler;
	
	public TestableUnitsService(ITestableUnitHandler handler){
		this._testableUnitHandler = handler;
	}
	
	
	@Override
	public void processTestableUnits(DSLModel model) {
		ArrayList<Function> functions = model.getCompilationUnitFunctions();
        ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
        model.setTestableUnits(testableUnits);
	}
}
