package com.dsl.validators;

import com.dsl.models.dtos.ClassFunctionsRequest;
import br.com.fluentvalidator.AbstractValidator;

import static org.hamcrest.Matchers.not;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class ClassFunctionsRequestValidator extends AbstractValidator<ClassFunctionsRequest> {

	@Override
	public void rules() {

		ruleFor(ClassFunctionsRequest::getClassPath)
			.must(not(stringEmptyOrNull()))
	    		.withMessage("classPath must not be null or empty")
	    		.withFieldName("classPath");
		
		ruleFor(ClassFunctionsRequest::getLanguage)
			.must(not(stringEmptyOrNull()))
    			.withMessage("language must not be null or empty")
    			.withFieldName("language");		
	}
}
