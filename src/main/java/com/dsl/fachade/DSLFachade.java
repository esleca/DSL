package com.dsl.fachade;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;
import com.dsl.services.IDSLValidatorService;
import com.dsl.services.IDSLReportService;
import com.dsl.services.IDSLProcessor;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.util.List;
import java.io.IOException;
import br.com.fluentvalidator.context.ValidationResult;
import org.springframework.stereotype.Component;


@Component
public class DSLFachade implements IDSLFachade {

	private IDSLValidatorService validator;
	private IDSLProcessor dslProcessor;
	private IDSLReportService reportService;

	public DSLFachade(IDSLValidatorService validatorService, IDSLProcessor dslProcessor, IDSLReportService reportService) {
		this.validator = validatorService;
		this.dslProcessor = dslProcessor;
		this.reportService = reportService;
	}

	
    @Override
    public UnitTest generateUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	ValidationResult validation = validator.validateTestRequest(unitTestRequest);
    	
    	if(validation.isValid()) {
    		return dslProcessor.generateUnitTest(unitTestRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
    	dslProcessor.removeUnitTest(unitTestRequest);
    }

    @Override
    public List<UnitTest> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        ValidationResult validation = validator.validateFunctionTestsRequest(functionRequest);
    	
    	if(validation.isValid()) {
    		return reportService.getFunctionUnitTests(functionRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }

    @Override
    public List<UnitTest> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        ValidationResult validation = validator.validateClassTestsRequest(classRequest);
    	
    	if(validation.isValid()) {
    		return reportService.getClassUnitTests(classRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }

    @Override
    public List<UnitTest> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        ValidationResult validation = validator.validatePackageTestsRequest(packageRequest);
    	
    	if(validation.isValid()) {
    		return reportService.getPackageUnitTests(packageRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }
}
