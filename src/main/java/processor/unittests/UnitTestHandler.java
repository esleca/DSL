package processor.unittests;

import exceptions.AssertNotFoundException;
import factories.IUnitTestFactory;
import factories.UnitTestFactory;
import models.entities.unittests.*;
import models.entities.unittests.acts.Act;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.asserts.Assert;

import java.util.ArrayList;

public class UnitTestHandler implements IUnitTestHandler {

    private IUnitTestArrangeHandler arrangeHandler;
    private IUnitTestActionHandler actionHandler;
    private IUnitTestAssertHandler assertHandler;
    private IUnitTestFactory unitTestFactory;

    public UnitTestHandler(IUnitTestArrangeHandler arrangeHandler, IUnitTestActionHandler actionHandler,
                           IUnitTestAssertHandler assertHandler, IUnitTestFactory unitTestFactory){
        this.arrangeHandler = arrangeHandler;
        this.actionHandler = actionHandler;
        this.assertHandler = assertHandler;
        this.unitTestFactory = unitTestFactory;
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

        for (TestScenario testScenario : testScenarios){
            Arrange arrange = arrangeHandler.processUnitTestArrange(testScenario);
            Act act = actionHandler.processUnitTestAct(testScenario);
            Assert lAssert = assertHandler.processUnitTestAssert(testScenario);
            UnitTest unitTest = unitTestFactory.createUnitTest(testScenario, arrange, act, lAssert);
            unitTests.add(unitTest);
        }

        return unitTests;
    }
}
