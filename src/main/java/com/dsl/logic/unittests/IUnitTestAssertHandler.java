package com.dsl.logic.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.unittests.asserts.Assert;
import com.dsl.models.unittests.TestScenario;

public interface IUnitTestAssertHandler {

    Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException, ValueTypeNotFoundException;

}
