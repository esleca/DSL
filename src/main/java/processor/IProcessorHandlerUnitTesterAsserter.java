package processor;

import models.entities.unittests.Assert;
import models.entities.unittests.TestScenario;

public interface IProcessorHandlerUnitTesterAsserter {

    Assert getAssert(TestScenario testScenario);

}
