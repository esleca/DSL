package com.dsl.logic.unittests.asserts;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.unittests.asserts.Assert;

import gastmappers.exceptions.UnsupportedLanguageException;

import com.dsl.models.unittests.TestScenario;

public interface IUnitTestAssertHandler {

    Assert processUnitTestAssert(TestScenario testScenario, String language) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException;
}
