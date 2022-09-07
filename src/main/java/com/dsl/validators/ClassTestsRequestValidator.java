package com.dsl.validators;

import com.dsl.models.dtos.ClassTestsRequest;
import br.com.fluentvalidator.AbstractValidator;

import static org.hamcrest.Matchers.not;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class ClassTestsRequestValidator extends AbstractValidator<ClassTestsRequest> {

	@Override
	public void rules() {

		ruleFor(ClassTestsRequest::getPackageName)
			.must(not(stringEmptyOrNull()))
	    		.withMessage("packageName must not be null or empty")
	    		.withFieldName("packageName");
		
		ruleFor(ClassTestsRequest::getClassName)
			.must(not(stringEmptyOrNull()))
    			.withMessage("className must not be null or empty")
    			.withFieldName("className");		
	}
}
