package com.dsl.logic.unittests.asserts;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.Assert;

import org.apache.commons.lang3.NotImplementedException;


public class UnitTestAssertPythonHandler extends UnitTestAssertBaseHandler {

    @Override
    public Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException, ValueTypeNotFoundException {
        throw new NotImplementedException();
    }
}
