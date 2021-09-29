package processor.unittests;

import exceptions.AssertNotFoundException;
import models.entities.unittests.asserts.Assert;
import models.entities.unittests.TestScenario;

public interface IUnitTestAssertHandler {

    Assert processUnitTestAssert(TestScenario testScenario) throws AssertNotFoundException;

}
