package com.dsl.logic.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.UnitTest;

import java.util.ArrayList;

public interface IUnitTestHandler {

    UnitTest processUnitTest(TestScenario testScenario) throws AssertNotFoundException, ValueTypeNotFoundException;

    ArrayList<UnitTest> processUnitTests(ArrayList<TestScenario> testScenarios) throws AssertNotFoundException, ValueTypeNotFoundException;

}
