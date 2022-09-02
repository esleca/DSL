package com.dsl.services;

import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import br.com.fluentvalidator.context.ValidationResult;

public interface IDSLValidatorService {
	
	ValidationResult validateTestRequest(UnitTestRequest unitTestRequest);
	
	ValidationResult validateFunctionTestsRequest(FunctionTestsRequest functionTestsRequest);
	
	ValidationResult validateClassTestsRequest(ClassTestsRequest classTestsRequest);
	
	ValidationResult validatePackageTestsRequest(PackageTestsRequest packageTestsRequest);
	
	void printErrors(ValidationResult validation);
}