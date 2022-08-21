package com.dsl.fachade;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;
import com.dsl.services.IDSLValidatorService;
import com.dsl.services.IDSLReportService;
import com.dsl.services.IDSLCrudService;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.util.List;
import java.io.IOException;
import br.com.fluentvalidator.context.ValidationResult;
import org.springframework.stereotype.Component;


@Component
public class DSLFachade implements IDSLFachade {

	private IDSLValidatorService validator;
	private IDSLCrudService crudService;
	private IDSLReportService reportService;

	public DSLFachade(IDSLValidatorService validator, IDSLCrudService crudService, IDSLReportService reportService) {
		this.validator = validator;
		this.crudService = crudService;
		this.reportService = reportService;
	}

	
    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	ValidationResult validation = validator.validateCreateRequest(unitTestRequest);
    	
    	if(validation.isValid()) {
    		return crudService.createUnitTest(unitTestRequest);
    	} else {
    		validator.printErrors(validation);
    		return null;
    	}
    }

    @Override
    public UnitTest editUnitTest(UnitTestRequest unitTestRequest) {
        return crudService.editUnitTest(unitTestRequest);
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
        crudService.removeUnitTest(unitTestRequest);
    }

    @Override
    public List<UnitTest> getFunctionUnitTests(String inFunction) {
        return reportService.getFunctionUnitTests(inFunction);
    }

    @Override
    public List<UnitTest> getClassUnitTests(String inClass) {
        return reportService.getClassUnitTests(inClass);
    }

    @Override
    public List<UnitTest> getPackageUnitTests(String inPackage) {
        return reportService.getPackageUnitTests(inPackage);
    }

}
