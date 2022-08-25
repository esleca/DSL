package com.dsl.validators;

import com.dsl.models.dtos.UnitTestRequest;
import br.com.fluentvalidator.AbstractValidator;

import static org.hamcrest.Matchers.not;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;


public class DSLFluentValidator extends AbstractValidator<UnitTestRequest> {

	@Override
	public void rules() {
		
		// Class Path
		ruleFor(UnitTestRequest::getClassPath)
			.must(not(nullValue()))
	    		.withMessage("classPath must not be null")
	    		.withFieldName("classPath")
			.must(not(stringEmptyOrNull()))
				.withMessage("classPath must not be empty")
				.withFieldName("classPath");
			
		// Language
		ruleFor(UnitTestRequest::getLanguage)
			.must(not(nullValue()))
	    		.withMessage("language must not be null")
	    		.withFieldName("language")
			.must(not(stringEmptyOrNull()))
				.withMessage("language must not be empty")
				.withFieldName("language");
			
		// OutputPath
		ruleFor(UnitTestRequest::getOutputPath)
			.must(not(nullValue()))
	    		.withMessage("outputPath must not be null")
	    		.withFieldName("outputPath")
			.must(not(stringEmptyOrNull()))
				.withMessage("outputPath must not be empty")
				.withFieldName("outputPath");
		
		// Function
		ruleFor(UnitTestRequest::getFunction)
			.must(not(nullValue()))
	    		.withMessage("function must not be null")
	    		.withFieldName("function")
			.must(not(stringEmptyOrNull()))
				.withMessage("function must not be empty")
				.withFieldName("function");
		
		// TestName
		ruleFor(UnitTestRequest::getTestName)
			.must(not(nullValue()))
	        	.withMessage("testName must not be null")
	    		.withFieldName("testName")
			.must(not(stringEmptyOrNull()))
				.withMessage("testName must not be empty")
				.withFieldName("testName");
			
		// Assertion
		ruleFor(UnitTestRequest::getAssert)
			.must(not(nullValue()))
	        	.withMessage("assertion must not be null")
	    		.withFieldName("assertion")
			.must(not(stringEmptyOrNull()))
				.withMessage("assertion must not be empty")
				.withFieldName("assertion");
		
	}
}
