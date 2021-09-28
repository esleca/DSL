package processor.unittests;

import exceptions.AssertNotFoundException;
import models.entities.unittests.TestScenario;
import models.entities.unittests.UnitTest;

import java.util.ArrayList;

public interface IProcessorHandlerUnitTester {

    ArrayList<UnitTest> getUnitTests(ArrayList<TestScenario> testScenarios) throws AssertNotFoundException;

}
