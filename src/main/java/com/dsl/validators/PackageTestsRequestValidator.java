package com.dsl.validators;

import com.dsl.models.dtos.PackageTestsRequest;

import br.com.fluentvalidator.AbstractValidator;

import static org.hamcrest.Matchers.not;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class PackageTestsRequestValidator extends AbstractValidator<PackageTestsRequest> {

	@Override
	public void rules() {

		ruleFor(PackageTestsRequest::getPackageName)
			.must(not(stringEmptyOrNull()))
	    		.withMessage("packageName must not be null or empty")
	    		.withFieldName("packageName");	
	}
}
