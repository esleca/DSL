package com.dsl.logic.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.models.entities.unittests.asserts.Assert;
import com.dsl.models.entities.unittests.TestScenario;

public interface IUnitTestAssertHandler {

    Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException;

}
