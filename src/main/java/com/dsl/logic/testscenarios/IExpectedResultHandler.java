package com.dsl.logic.testscenarios;

import com.dsl.models.entities.unittests.*;
import com.dsl.models.dtos.*;

public interface IExpectedResultHandler {

	ExpectedResult getExpectedResult(UnitTestRequest request);
}
