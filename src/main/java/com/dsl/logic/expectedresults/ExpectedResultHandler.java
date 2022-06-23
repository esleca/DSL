package com.dsl.logic.expectedresults;

import org.springframework.stereotype.Component;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ExpectedResultsFactory;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.valuetypes.ValueType;


@Component
public class ExpectedResultHandler implements IExpectedResultHandler {

	
	@Override
	public ExpectedResult getExpectedResult(UnitTestRequest request) throws ValueTypeNotFoundException {
		ValueType expectedObject = request.getExpected();

        if(expectedObject == null) {
        	return null;
        }
        
        return ExpectedResultsFactory.createPrimitiveExpectedResult(expectedObject);
	}

}
