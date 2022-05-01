package com.dsl.logic.unittests;

import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.TestScenario;

public interface IUnitTestArrangeHandler {

    Arrange processUnitTestArrange(TestScenario testScenario);

}
