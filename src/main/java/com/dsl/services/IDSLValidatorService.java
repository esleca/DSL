package com.dsl.services;

import com.dsl.models.dtos.UnitTestRequest;
import br.com.fluentvalidator.context.ValidationResult;

public interface IDSLValidatorService {
	
	ValidationResult validateCreateRequest(UnitTestRequest unitTestRequest); 
	
	void printErrors(ValidationResult validation);
}