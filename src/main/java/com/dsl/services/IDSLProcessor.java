package com.dsl.services;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;

import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;
import java.io.IOException;
import java.util.List;

public interface IDSLProcessor {

    UnitTest generateUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    void removeUnitTest(UnitTestRequest unitTestRequest);
    
	// reports
	List<UnitTest> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    List<UnitTest> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    List<UnitTest> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;
}
