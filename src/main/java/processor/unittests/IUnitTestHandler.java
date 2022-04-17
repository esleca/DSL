package processor.unittests;

import exceptions.AssertNotFoundException;
import models.entities.unittests.TestScenario;
import models.entities.unittests.UnitTest;

import java.util.ArrayList;

public interface IUnitTestHandler {

    UnitTest processUnitTest(TestScenario testScenario) throws AssertNotFoundException;

    ArrayList<UnitTest> processUnitTests(ArrayList<TestScenario> testScenarios) throws AssertNotFoundException;

}
