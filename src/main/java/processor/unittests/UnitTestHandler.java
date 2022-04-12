package processor.unittests;

import exceptions.AssertNotFoundException;
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

    public UnitTestHandler(IUnitTestArrangeHandler arrangeHandler, IUnitTestActionHandler actionHandler,
                           IUnitTestAssertHandler assertHandler){
        this.arrangeHandler = arrangeHandler;
        this.actionHandler = actionHandler;
        this.assertHandler = assertHandler;
    }


    /**
     * Receive a test scenario defined by the user
     * and return a unit test instance
     *
     * @param testScenario
     * @return
     * @throws AssertNotFoundException
     */
    @Override
    public UnitTest processUnitTest(TestScenario testScenario) throws AssertNotFoundException{
        Arrange arrange = arrangeHandler.processUnitTestArrange( testScenario );
        Act act = actionHandler.processUnitTestAct( testScenario );
        Assert lAssert = assertHandler.processUnitTestAssert( testScenario );
        return UnitTestFactory.createUnitTest( testScenario, arrange, act, lAssert );
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
            UnitTest unitTest = UnitTestFactory.createUnitTest(testScenario, arrange, act, lAssert);
            unitTests.add(unitTest);
        }

        return unitTests;
    }
}
