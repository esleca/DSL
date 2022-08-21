package com.dsl.services;

import com.dsl.models.dtos.UnitTestRequest;
import br.com.fluentvalidator.context.ValidationResult;

public interface IDSLValidatorService {
	
	ValidationResult validateInsertRequest(UnitTestRequest unitTestRequest); 
	
	void printErrors(ValidationResult validation);
}