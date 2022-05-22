package com.dsl.logic.expectedresults;

import org.springframework.stereotype.Component;

import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.ExpectedResult;


@Component
public class ExpectedResultHandler implements IExpectedResultHandler {

	@Override
	public ExpectedResult getExpectedResult(UnitTestRequest request) {
		ExpectedResult expected = null;
		
		//TODO: handle instanceof?
		return expected;
	}

}
