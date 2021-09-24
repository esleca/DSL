package processor.unittests;

import models.entities.unittests.TestScenario;
import models.entities.unittests.UnitTest;

import java.util.ArrayList;

public interface IProcessorHandlerUnitTester {

    ArrayList<UnitTest> getUnitTests(ArrayList<TestScenario> testScenarios);

}
