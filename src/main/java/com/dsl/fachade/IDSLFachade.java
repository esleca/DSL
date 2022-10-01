package com.dsl.fachade;

import com.dsl.models.dtos.*;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.unittests.UnitTest;

import java.io.IOException;
import java.util.List;

public interface IDSLFachade {

    UnitTest generateUnitTest(UnitTestRequest unitTestRequest) throws UnsupportedLanguageException, IOException, ValueTypeNotFoundException, AssertNotFoundException;

    void removeUnitTest(UnitTestRequest unitTestRequest);
    
    List<UnitTest> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    List<UnitTest> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    List<UnitTest> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;
    
    List<ClassFunctionsResponse> getClassFunctions(ClassFunctionsRequest classRequest) throws IOException, UnsupportedLanguageException;
}
