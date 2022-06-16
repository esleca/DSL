package com.dsl.logic.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.UnitTest;

import gastmappers.exceptions.UnsupportedLanguageException;

import java.util.ArrayList;

public interface IUnitTestHandler {

    UnitTest processUnitTest(TestScenario testScenario, String language) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException;

    ArrayList<UnitTest> processUnitTests(ArrayList<TestScenario> testScenarios, String language) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException;

}
