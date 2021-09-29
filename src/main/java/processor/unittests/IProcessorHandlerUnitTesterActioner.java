package processor.unittests;

import models.entities.unittests.acts.Act;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.TestScenario;

public interface IProcessorHandlerUnitTesterActioner {

    Act getAct(TestScenario testScenario, Arrange arrange);

}
