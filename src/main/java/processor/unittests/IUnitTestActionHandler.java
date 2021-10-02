package processor.unittests;

import models.entities.unittests.acts.Act;
import models.entities.unittests.TestScenario;

public interface IUnitTestActionHandler {

    Act processUnitTestAct(TestScenario testScenario);

}
