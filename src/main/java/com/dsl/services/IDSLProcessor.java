package com.dsl.services;

import java.io.IOException;
import java.util.List;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.dtos.*;

public interface IDSLProcessor {

    UnitTestResponse generateUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    void removeUnitTest(UnitTestRequest unitTestRequest);
    
	// reports
	List<UnitTestResponse> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    List<UnitTestResponse> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    List<UnitTestResponse> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;
    
    List<ClassFunctionsResponse> getClassFunctions(ClassFunctionsRequest classRequest) throws IOException, UnsupportedLanguageException;
}
