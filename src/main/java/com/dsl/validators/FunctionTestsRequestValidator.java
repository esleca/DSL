package com.dsl.validators;

import com.dsl.models.dtos.FunctionTestsRequest;
import br.com.fluentvalidator.AbstractValidator;

import static org.hamcrest.Matchers.not;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class FunctionTestsRequestValidator extends AbstractValidator<FunctionTestsRequest> {

	@Override
	public void rules() {

		ruleFor(FunctionTestsRequest::getPackageName)
			.must(not(stringEmptyOrNull()))
	    		.withMessage("packageName must not be null or empty")
	    		.withFieldName("packageName");
		
		ruleFor(FunctionTestsRequest::getClassName)
			.must(not(stringEmptyOrNull()))
    			.withMessage("className must not be null or empty")
    			.withFieldName("className");
		
		ruleFor(FunctionTestsRequest::getFunctionName)
			.must(not(stringEmptyOrNull()))
				.withMessage("functionName must not be null or empty")
				.withFieldName("functionName");	
	}
}
