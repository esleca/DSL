package com.dsl.services.unittests;

import org.springframework.stereotype.Component;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.unittests.IUnitTestHandler;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.UnitTest;
import gastmappers.exceptions.UnsupportedLanguageException;

@Component
public class UnitTestService implements IUnitTestService {
	
	private IUnitTestHandler _unitTestHandler;
	
	public UnitTestService(IUnitTestHandler unitTestHandler) {
		this._unitTestHandler = unitTestHandler;
	}
	
	@Override
	public UnitTest processUnitTest(DSLModel model, String language) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException {
		TestScenario testScenario = model.getTestScenario();
        
		UnitTest unitTest = _unitTestHandler.processUnitTest(testScenario, language);
    	
		return unitTest;
	}
}
