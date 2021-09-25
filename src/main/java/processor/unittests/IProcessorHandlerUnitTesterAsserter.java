package processor.unittests;

import models.entities.unittests.asserts.Assert;
import models.entities.unittests.TestScenario;

public interface IProcessorHandlerUnitTesterAsserter {

    Assert getAssert(TestScenario testScenario);

}
