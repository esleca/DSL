package com.dsl.logic.unittests.action;

import com.dsl.models.unittests.acts.*;
import com.dsl.factories.UnitTestActionFactory;
import com.dsl.models.unittests.TestScenario;

import org.springframework.stereotype.Component;


@Component
public class UnitTestActionHandler implements IUnitTestActionHandler {

    @Override
    public Act processUnitTestAct(TestScenario testScenario) {
    	boolean isStatic = testScenario.getFunction().isStatic();
		
    	UnitTestActionBaseHandler handler = UnitTestActionFactory.createActionHandler(isStatic);
    	return handler.processUnitTestAct(testScenario);
    }
}
