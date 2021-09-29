package processor.unittests;

import exceptions.AssertNotFoundException;
import factories.UnitTestFactory;
import models.entities.unittests.*;
import models.entities.unittests.acts.Act;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.asserts.Assert;

import java.util.ArrayList;

public class ProcessorHandlerUnitTester implements IProcessorHandlerUnitTester {

    private UnitTestFactory unitTestFactory;
    private IProcessorHandlerUnitTesterArranger handlerArranger;
    private IProcessorHandlerUnitTesterActioner handlerActioner;
    private IProcessorHandlerUnitTesterAsserter handlerAsserter;

    public ProcessorHandlerUnitTester(){
        unitTestFactory = new UnitTestFactory();
        handlerArranger = new ProcessorHandlerUnitTesterArranger();
        handlerActioner = new ProcessorHandlerUnitTesterActioner();
        handlerAsserter = new ProcessorHandlerUnitTesterAsserter();
    }


    /**
     * Receive a list of test scenarios defined by user and
     * return a list of the corresponding unit tests
     *
     * @param testScenarios
     * @return a list of unit tests
     */
    @Override
    public ArrayList<UnitTest> getUnitTests(ArrayList<TestScenario> testScenarios) throws AssertNotFoundException {
        ArrayList<UnitTest> unitTests = new ArrayList<>();

        for (TestScenario testScenario : testScenarios){
            // AAA
            Arrange arrange = handlerArranger.getArrange(testScenario);
            Act act = handlerActioner.getAct(testScenario, arrange);
            Assert lAssert = handlerAsserter.getAssert(testScenario);

            // unit test
            UnitTest unitTest = unitTestFactory.createUnitTest(testScenario, arrange, act, lAssert);
            unitTests.add(unitTest);
        }

        return unitTests;
    }
}
