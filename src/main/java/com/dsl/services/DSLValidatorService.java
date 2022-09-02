package com.dsl.services;

import java.util.Iterator;
import org.springframework.stereotype.Component;
import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;

import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.validators.ClassTestsRequestValidator;
import com.dsl.validators.FunctionTestsRequestValidator;
import com.dsl.validators.PackageTestsRequestValidator;
import com.dsl.validators.UnitTestRequestValidator;


@Component
public class DSLValidatorService implements IDSLValidatorService {

	private Validator<UnitTestRequest> unitTestValidator = new UnitTestRequestValidator();
	private Validator<ClassTestsRequest> classTestsValidator = new ClassTestsRequestValidator();
	private Validator<PackageTestsRequest> packageTestsValidator = new PackageTestsRequestValidator();
	private Validator<FunctionTestsRequest> functionTestsValidator = new FunctionTestsRequestValidator();
	
	
	@Override
	public ValidationResult validateTestRequest(UnitTestRequest unitTestRequest) {
		ValidationResult validationResult = unitTestValidator.validate(unitTestRequest);
		
		System.out.println("\nUnitTestRequest ValidationResult.isValid(): " + validationResult.isValid());
		
		return validationResult;
	}
	
	@Override
	public ValidationResult validateFunctionTestsRequest(FunctionTestsRequest functionTestsRequest) {
		ValidationResult validationResult = functionTestsValidator.validate(functionTestsRequest);
		
		System.out.println("\nFunctionTestsRequest ValidationResult.isValid(): " + validationResult.isValid());
		
		return validationResult;		
	}

	@Override
	public ValidationResult validateClassTestsRequest(ClassTestsRequest classTestsRequest) {
		ValidationResult validationResult = classTestsValidator.validate(classTestsRequest);
		
		System.out.println("\nClassTestsRequest ValidationResult.isValid(): " + validationResult.isValid());
		
		return validationResult;
	}
	
	@Override
	public ValidationResult validatePackageTestsRequest(PackageTestsRequest packageTestsRequest) {
		ValidationResult validationResult = packageTestsValidator.validate(packageTestsRequest);
		
		System.out.println("\nPackageTestsRequest ValidationResult.isValid(): " + validationResult.isValid());
		
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
