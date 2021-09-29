package processor.unittests;

import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.TestScenario;

public interface IUnitTestArrangeHandler {

    Arrange processUnitTestArrange(TestScenario testScenario);

}
