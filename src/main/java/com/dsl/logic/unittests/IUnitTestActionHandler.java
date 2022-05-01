package com.dsl.logic.unittests;

import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.TestScenario;

public interface IUnitTestActionHandler {

    Act processUnitTestAct(TestScenario testScenario);

}
