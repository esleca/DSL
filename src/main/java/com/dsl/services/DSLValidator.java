package com.dsl.services;

import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.validators.DSLFluentValidator;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;


@Component
public class DSLValidator implements IDSLValidatorService {

	private Validator<UnitTestRequest> validator = new DSLFluentValidator();
	
	@Override
	public ValidationResult validateInsertRequest(UnitTestRequest unitTestRequest) {
		ValidationResult validationResult = validator.validate(unitTestRequest);
		
		return validationResult;
	}


	@Override
    public void printErrors(ValidationResult validation) {
    	var errors = validation.getErrors();
		
		for (Iterator<?> iterator = errors.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
    }
}
