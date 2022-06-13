package com.dsl.logic.unittests.action;

import static com.dsl.utils.Constants.SYSTEM_UNDER_TEST;

import com.dsl.factories.UnitTestFactory;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;
import com.dsl.models.unittests.acts.InstanceAct;


public class UnitTestActionInstanceHandler extends UnitTestActionBaseHandler {

	@Override
	public Act processUnitTestAct(TestScenario testScenario) {
		Act action = getInstanceAct(testScenario);
        return action;
	}

    private InstanceAct getInstanceAct(TestScenario testScenario){
        String sutType = testScenario.getFunction().getFileClass().getName();
        String sutName = SYSTEM_UNDER_TEST;

        ActNewType actNewType = UnitTestFactory.createActNewType(sutType, sutName);
        ActExecution actExecution = getActExecution(testScenario, sutName);

        return (InstanceAct) UnitTestFactory.createInstaceAct(actNewType, actExecution);
    }
}
