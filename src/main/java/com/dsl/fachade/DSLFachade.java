package com.dsl.fachade;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;
import com.dsl.services.IDSLReportService;
import com.dsl.services.IDSLCrudService;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DSLFachade implements IDSLCrudFachade, IDSLFachadeReporter {

	private IDSLCrudService _crudService;
    private IDSLReportService _reportService;
	
	public DSLFachade(IDSLCrudService inCrudService, IDSLReportService inReportService){ 
		this._crudService = inCrudService;
		this._reportService = inReportService;
	}

	
    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        return _crudService.createUnitTest(unitTestRequest);
    }

    @Override
    public UnitTest editUnitTest(UnitTestRequest unitTestRequest) {
        return _crudService.editUnitTest(unitTestRequest);
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
        _crudService.removeUnitTest(unitTestRequest);
    }

    
    @Override
    public List<UnitTest> getFunctionUnitTests(String inFunction) {
        return _reportService.getFunctionUnitTests(inFunction);
    }

    @Override
    public List<UnitTest> getClassUnitTests(String inClass) {
        return _reportService.getClassUnitTests(inClass);
    }

    @Override
    public List<UnitTest> getPackageUnitTests(String inPackage) {
        return _reportService.getPackageUnitTests(inPackage);
    }

}
