package processor.unittests;

import exceptions.AssertNotFoundException;
import models.entities.unittests.asserts.Assert;
import models.entities.unittests.TestScenario;

public interface IProcessorHandlerUnitTesterAsserter {

    Assert getAssert(TestScenario testScenario) throws AssertNotFoundException;

}
