package com.dsl.fachade;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.entities.unittests.UnitTest;
import com.dsl.services.IDSLReportService;
import com.dsl.services.IDSLCrudService;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DSLFachade implements IDSLFachade, IDSLFachadeReporter {

	private IDSLCrudService _CrudService;
    private IDSLReportService _ReportService;
	
	public DSLFachade(IDSLCrudService inCrudService, IDSLReportService inReportService){ 
		this._CrudService = inCrudService; 
		this._ReportService = inReportService; 
	}

	
    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        return _CrudService.createUnitTest(unitTestRequest);
    }

    @Override
    public UnitTest editUnitTest(UnitTestRequest unitTestRequest) {
        return _CrudService.editUnitTest(unitTestRequest);
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
        _CrudService.removeUnitTest(unitTestRequest);
    }


    
    @Override
    public List<UnitTest> getFunctionUnitTests(String inFunction) {
        return _ReportService.getFunctionUnitTests(inFunction);
    }

    @Override
    public List<UnitTest> getClassUnitTests(String inClass) {
        return _ReportService.getClassUnitTests(inClass);
    }

    @Override
    public List<UnitTest> getPackageUnitTests(String inPackage) {
        return _ReportService.getPackageUnitTests(inPackage);
    }
    

}
