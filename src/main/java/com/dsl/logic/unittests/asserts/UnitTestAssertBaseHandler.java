package com.dsl.logic.unittests.asserts;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.Assert;

public abstract class UnitTestAssertBaseHandler {

	public abstract Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException, ValueTypeNotFoundException;
}
