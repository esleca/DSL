package processor.unittests;

import models.entities.unittests.Arrange;
import models.entities.unittests.TestScenario;

public interface IProcessorHandlerUnitTesterArranger {

    Arrange getArrange(TestScenario testScenario);

}
