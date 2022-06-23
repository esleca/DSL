package com.dsl.logic.unittests.asserts;

import org.springframework.stereotype.Component;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.UnitTestAssertsFactory;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.Assert;

import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class UnitTestAssertHandler implements IUnitTestAssertHandler {

	@Override
	public Assert processUnitTestAssert(TestScenario testScenario, String language) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException {
		UnitTestAssertBaseHandler handler = UnitTestAssertsFactory.createAssertHandler(language);
		return handler.processUnitTestAssert(testScenario);
	}
}
