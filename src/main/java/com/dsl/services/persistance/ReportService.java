package com.dsl.services.persistance;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.mappers.UnitTestMapper;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.repositories.IDSLReportRepository;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class ReportService implements IReportService{

	private IDSLReportRepository _reportRepo;
    
    public ReportService(IDSLReportRepository repository) {
    	this._reportRepo = repository;
    }

    @Override
    public List<UnitTestMetaData> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _reportRepo.getFunctionUnitTests(functionRequest);
    	return metaData;
    }
    
    @Override
    public List<UnitTestMetaData> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _reportRepo.getClassUnitTests(classRequest);
    	return metaData;
    }
    
    @Override
    public List<UnitTestMetaData> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _reportRepo.getPackageUnitTests(packageRequest);
    	return metaData;
    }
    
    @Override
    public List<UnitTestRequest> getClassUnitTestsRequests(ClassTestsRequest classRequest) throws ValueTypeNotFoundException {
    	List<UnitTestMetaData> metaData = _reportRepo.getClassUnitTests(classRequest);
    	List<UnitTestRequest> requests = createUnitTestsRequests(metaData);
    	return requests;
    }
    
    private List<UnitTestRequest> createUnitTestsRequests(List<UnitTestMetaData> metaData) {
    	List<UnitTestRequest> unitTestRequests = new ArrayList<UnitTestRequest>();

    	for (UnitTestMetaData utMetaData : metaData) {
        	UnitTestRequest unitTestRequest = UnitTestMapper.convertUnitTest(utMetaData);
        	unitTestRequests.add(unitTestRequest);
		}
    	
    	return unitTestRequests;
    }
}
