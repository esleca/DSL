package com.dsl.fachade;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;
import com.dsl.services.IDSLReportService;
import com.dsl.services.IDSLCrudService;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DSLFachade implements IDSLFachade {

	private IDSLCrudService crudService;
	private IDSLReportService reportService;

	public DSLFachade(IDSLCrudService crudService, IDSLReportService reportService) {
		this.crudService = crudService;
		this.reportService = reportService;
	}

    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        return crudService.createUnitTest(unitTestRequest);
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
