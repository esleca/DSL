package com.dsl.fachade;

import java.util.List;
import java.io.IOException;
import br.com.fluentvalidator.context.ValidationResult;
import com.dsl.models.dtos.*;
import org.springframework.stereotype.Component;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.unittests.UnitTest;
import com.dsl.services.validations.IValidatorService;
import com.dsl.services.IDSLProcessor;
import gastmappers.exceptions.UnsupportedLanguageException;

@Component
public class DSLFachade implements IDSLFachade {

	private IValidatorService validator;
	private IDSLProcessor processor;

	public DSLFachade(IValidatorService validatorService, IDSLProcessor processor) {
		this.validator = validatorService;
		this.processor = processor;
	}
	
    @Override
    public UnitTest generateUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	ValidationResult validation = validator.validateTestRequest(unitTestRequest);
    	
    	if(validation.isValid()) {
    		return processor.generateUnitTest(unitTestRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
    	processor.removeUnitTest(unitTestRequest);
    }

    @Override
    public List<UnitTest> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        ValidationResult validation = validator.validateFunctionTestsRequest(functionRequest);
    	
    	if(validation.isValid()) {
    		return processor.getFunctionUnitTests(functionRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }

    @Override
    public List<UnitTest> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        ValidationResult validation = validator.validateClassTestsRequest(classRequest);
    	
    	if(validation.isValid()) {
    		return processor.getClassUnitTests(classRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }

    @Override
    public List<UnitTest> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        ValidationResult validation = validator.validatePackageTestsRequest(packageRequest);
    	
    	if(validation.isValid()) {
    		return processor.getPackageUnitTests(packageRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }

	@Override
	public List<ClassFunctionsResponse> getClassFunctions(ClassFunctionsRequest request) throws IOException, UnsupportedLanguageException {
		ValidationResult validation = validator.validateClassFunctionsRequest(request);

		if(validation.isValid()) {
    		return processor.getClassFunctions(request);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
	}
	
}
