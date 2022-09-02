package com.dsl.services;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.mappers.UnitTestMapper;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;
import com.dsl.repositories.IDSLRepository;
import gastmappers.exceptions.UnsupportedLanguageException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class DSLReportService implements IDSLReportService{

	private IDSLProcessor _processor;
	private IDSLRepository _repository;
    
    public DSLReportService(IDSLProcessor processor, IDSLRepository repository) {
      	this._processor = processor;
    	this._repository = repository;
    }

    @Override
    public List<UnitTest> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _repository.getFunctionUnitTests(functionRequest);
    	List<UnitTest> unitTests = createUnitTests(metaData);
    	return unitTests;
    }
    
    @Override
    public List<UnitTest> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _repository.getClassUnitTests(classRequest);
    	List<UnitTest> unitTests = createUnitTests(metaData);
    	return unitTests;
    }
    
    @Override
    public List<UnitTest> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _repository.getPackageUnitTests(packageRequest);
    	List<UnitTest> unitTests = createUnitTests(metaData);
    	return unitTests;
    }
    
    private List<UnitTest> createUnitTests(List<UnitTestMetaData> metaData) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException{
    	List<UnitTest> unitTests = new ArrayList<UnitTest>();

    	for (UnitTestMetaData utMetaData : metaData) {
        	UnitTestRequest unitTestRequest = UnitTestMapper.convertUnitTest(utMetaData);
        	UnitTest unitTest = _processor.createUnitTest(unitTestRequest);	
        	unitTests.add(unitTest);
		}
    	
    	return unitTests;
    }
}
