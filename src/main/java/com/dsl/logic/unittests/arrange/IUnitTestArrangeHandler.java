package com.dsl.logic.unittests.arrange;

import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.TestScenario;

public interface IUnitTestArrangeHandler {

    Arrange processUnitTestArrange(TestScenario testScenario);

}
