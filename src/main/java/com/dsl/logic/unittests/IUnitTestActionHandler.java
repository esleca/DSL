package com.dsl.logic.unittests;

import com.dsl.models.entities.unittests.acts.Act;
import com.dsl.models.entities.unittests.TestScenario;

public interface IUnitTestActionHandler {

    Act processUnitTestAct(TestScenario testScenario);

}
