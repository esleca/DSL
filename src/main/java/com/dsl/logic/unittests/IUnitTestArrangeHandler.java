package com.dsl.logic.unittests;

import com.dsl.models.entities.unittests.arranges.Arrange;
import com.dsl.models.entities.unittests.TestScenario;

public interface IUnitTestArrangeHandler {

    Arrange processUnitTestArrange(TestScenario testScenario);

}
