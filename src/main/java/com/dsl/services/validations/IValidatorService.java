package com.dsl.services.validations;

import com.dsl.models.dtos.ClassFunctionsRequest;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import br.com.fluentvalidator.context.ValidationResult;

public interface IValidatorService {
	
	ValidationResult validateTestRequest(UnitTestRequest unitTestRequest);
	
	ValidationResult validateFunctionTestsRequest(FunctionTestsRequest functionTestsRequest);
	
	ValidationResult validateClassTestsRequest(ClassTestsRequest classTestsRequest);
	
	ValidationResult validatePackageTestsRequest(PackageTestsRequest packageTestsRequest);
	
	ValidationResult validateClassFunctionsRequest(ClassFunctionsRequest classFunctionsRequest);
	
	void printErrors(ValidationResult validation);
}