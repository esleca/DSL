package com.dsl.logic.expectedresults;

import com.dsl.models.unittests.*;
import com.dsl.models.dtos.*;

public interface IExpectedResultHandler {

	ExpectedResult getExpectedResult(UnitTestRequest request);
}
