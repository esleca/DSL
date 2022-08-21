package com.dsl.validators;

import com.dsl.models.dtos.UnitTestRequest;
import br.com.fluentvalidator.AbstractValidator;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;


public class DSLFluentValidator extends AbstractValidator<UnitTestRequest> {

	@Override
	public void rules() {
		ruleFor(UnitTestRequest::getClassPath)
			.must(not(nullValue()))
        		.withMessage("classPath must not be null")
        		.withFieldName("classPath");
		
		ruleFor(UnitTestRequest::getLanguage)
			.must(not(nullValue()))
	    		.withMessage("language must not be null")
	    		.withFieldName("language");
			
		ruleFor(UnitTestRequest::getOutputPath)
			.must(not(nullValue()))
	    		.withMessage("outputPath must not be null")
	    		.withFieldName("outputPath");
		
		ruleFor(UnitTestRequest::getFunction)
			.must(not(nullValue()))
	    		.withMessage("function must not be null")
	    		.withFieldName("function");
		
		ruleFor(UnitTestRequest::getTestName)
			.must(not(nullValue()))
	        	.withMessage("testName must not be null")
        		.withFieldName("testName");
		
		ruleFor(UnitTestRequest::getAssert)
			.must(not(nullValue()))
	        	.withMessage("assertion must not be null")
	    		.withFieldName("assertion");
	}
}
