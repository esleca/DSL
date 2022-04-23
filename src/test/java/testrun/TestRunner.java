package testrun;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import processortests.TestScenarioHandlerTests;
import processortests.TestableUnitsHandlerTests;

public class TestRunner {

    public static void main(String[] args) {
        //Result result = JUnitCore.runClasses(TestScenarioHandlerTests.class);
    	Result result = JUnitCore.runClasses(TestableUnitsHandlerTests.class);

        System.out.println("Success run = " + result.getRunCount());

        for (Failure failure : result.getFailures()) {
            System.out.println("FAIL: " + failure.toString());
        }

        System.out.println("Result == "+result.wasSuccessful());
    }
}
