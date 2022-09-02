package com.dsl.services.unittests;

import java.util.ArrayList;
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
	public void processUnitTest(DSLModel model) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException {
		TestScenario testScenario = model.getTestScenario();
        ArrayList<String> outputLanguages = model.getOutputLanguages();
    	
    	for(String language : outputLanguages) {
    		ArrayList<UnitTest> unitTests = new ArrayList<UnitTest>();
    		UnitTest unitTest = _unitTestHandler.processUnitTest(testScenario, language);
    		unitTests.add(unitTest);
    		
    		model.setUnitTest(unitTest);
            model.addUnitTests(unitTests);
    	}
	}
}
