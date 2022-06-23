package com.dsl.logic.unittests.action;

import com.dsl.factories.UnitTestFactory;
import com.dsl.models.aggregates.Function;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.StaticAct;


public class UnitTestActionStaticHandler extends UnitTestActionBaseHandler {

	@Override
	public Act processUnitTestAct(TestScenario testScenario) {
        Act action = getStaticAct(testScenario);
        return action;
	}

    private StaticAct getStaticAct(TestScenario testScenario){
        Function function = testScenario.getFunction();
        String calledFunction = function.getFileClass().getName();
        
        ActExecution actExecution = getActExecution(testScenario, calledFunction);

        return (StaticAct) UnitTestFactory.createStaticAct(actExecution);
    }
}
