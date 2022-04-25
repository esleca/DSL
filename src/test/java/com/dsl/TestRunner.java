package com.dsl;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.dsl.logic.TestableUnitHandlerTests;
import com.dsl.logic.CompilationUnitHandlerTests;
import com.dsl.logic.UnitTestHandlerTests;
import com.dsl.models.*;


public class TestRunner {

    public static void main(String[] args) {
    	Result result = JUnitCore.runClasses(TestableUnitHandlerTests.class);
    	printUnitTestResult(result);
    	
        //Result result = JUnitCore.runClasses(TestScenarioHandlerTests.class);
    	//printUnitTestResult(result);
    	
    	result = JUnitCore.runClasses(CompilationUnitHandlerTests.class);
    	printUnitTestResult(result);
    	
    	result = JUnitCore.runClasses(UnitTestHandlerTests.class);
    	printUnitTestResult(result);
    	
    	result = JUnitCore.runClasses(AssertsTests.class);
    	printUnitTestResult(result);
    	
    	result = JUnitCore.runClasses(ModifiersTests.class);
    	printUnitTestResult(result);
    	
    	result = JUnitCore.runClasses(ReturnsTests.class);
    	printUnitTestResult(result);
    	
    	result = JUnitCore.runClasses(ValueTypesTests.class);
    	printUnitTestResult(result);
    }
    
    private static void printUnitTestResult(Result result) {
    	System.out.println("Success run = " + result.getRunCount());

        for (Failure failure : result.getFailures()) {
            System.out.println("FAIL: " + failure.toString());
        }

        System.out.println("Result == "+result.wasSuccessful());
    }
}
