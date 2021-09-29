package processor.unittests;

import exceptions.AssertNotFoundException;
import factories.UnitTestFactory;
import models.entities.unittests.*;
import models.entities.unittests.acts.Act;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.asserts.Assert;

import java.util.ArrayList;

public class UnitTestHandler implements IUnitTestHandler {

    private IUnitTestArrangeHandler dslArranger;
    private IUnitTestActionHandler dslActioner;
    private IUnitTestAssertHandler dslAsserter;

    public UnitTestHandler(){
        dslArranger = new UnitTestArrangeHandler();
        dslActioner = new UnitTestActionHandler();
        dslAsserter = new UnitTestAssertHandler();
    }

    /**
     * Receive a list of test scenarios defined by user and
     * return a list of the corresponding unit tests
     *
     * @param testScenarios
     * @return  a list of unit tests
     * @throws AssertNotFoundException
     */
    @Override
    public ArrayList<UnitTest> processUnitTests(ArrayList<TestScenario> testScenarios) throws AssertNotFoundException {
        ArrayList<UnitTest> unitTests = new ArrayList<>();
        UnitTestFactory unitTestFactory = new UnitTestFactory();

        for (TestScenario testScenario : testScenarios){
            // AAA
            Arrange arrange = dslArranger.processUnitTestArrange(testScenario);
            Act act = dslActioner.processUnitTestAct(testScenario);
            Assert lAssert = dslAsserter.processUnitTestAssert(testScenario);

            // unit test
            UnitTest unitTest = unitTestFactory.createUnitTest(testScenario, arrange, act, lAssert);
            unitTests.add(unitTest);
        }

        return unitTests;
    }
}
