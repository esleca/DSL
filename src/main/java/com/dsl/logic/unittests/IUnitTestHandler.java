package com.dsl.logic.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.UnitTest;

import java.util.ArrayList;

public interface IUnitTestHandler {

    UnitTest processUnitTest(TestScenario testScenario) throws AssertNotFoundException;

    ArrayList<UnitTest> processUnitTests(ArrayList<TestScenario> testScenarios) throws AssertNotFoundException;

}
