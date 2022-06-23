package com.dsl.logic.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.UnitTestFactory;
import com.dsl.logic.unittests.action.IUnitTestActionHandler;
import com.dsl.logic.unittests.arrange.IUnitTestArrangeHandler;
import com.dsl.logic.unittests.asserts.IUnitTestAssertHandler;
import com.dsl.models.unittests.*;
import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.asserts.Assert;

import gastmappers.exceptions.UnsupportedLanguageException;

import java.util.ArrayList;
import org.springframework.stereotype.Component;


@Component
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
    

    @Override
    public UnitTest processUnitTest(TestScenario testScenario, String language) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException{
        Arrange arrange = arrangeHandler.processUnitTestArrange( testScenario );
        Act act = actionHandler.processUnitTestAct( testScenario );
        Assert lAssert = assertHandler.processUnitTestAssert( testScenario, language );
        
        return UnitTestFactory.createUnitTest( language, testScenario, arrange, act, lAssert );
    }

    @Override
    public ArrayList<UnitTest> processUnitTests(ArrayList<TestScenario> testScenarios, String language) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException {
        ArrayList<UnitTest> unitTests = new ArrayList<>();

        for (TestScenario testScenario : testScenarios){
            Arrange arrange = arrangeHandler.processUnitTestArrange(testScenario);
            Act act = actionHandler.processUnitTestAct(testScenario);
            Assert lAssert = assertHandler.processUnitTestAssert(testScenario, language);
            UnitTest unitTest = UnitTestFactory.createUnitTest(language, testScenario, arrange, act, lAssert);
            unitTests.add(unitTest);
        }

        return unitTests;
    }
}
