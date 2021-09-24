package processor.unittests;

import models.entities.unittests.Assert;
import models.entities.unittests.TestScenario;
import processor.unittests.IProcessorHandlerUnitTesterAsserter;

public class ProcessorHandlerUnitTesterAsserter implements IProcessorHandlerUnitTesterAsserter {

    @Override
    public Assert getAssert(TestScenario testScenario) {
        return null;
    }
}
