package processor;

import models.entities.unittests.Act;
import models.entities.unittests.Arrange;
import models.entities.unittests.TestScenario;

public interface IProcessorHandlerUnitTesterActioner {

    Act getAct(TestScenario testScenario, Arrange arrange);

}
