package com.dsl.fachade;

import java.io.IOException;
import java.util.List;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.dtos.*;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;

public interface IDSLFachade {

    UnitTestResponse generateUnitTest(UnitTestRequest unitTestRequest) throws UnsupportedLanguageException, IOException, ValueTypeNotFoundException, AssertNotFoundException;

    void removeUnitTest(UnitTestRequest unitTestRequest);
    
    List<UnitTestResponse> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    List<UnitTestResponse> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    List<UnitTestResponse> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;
    
    List<ClassFunctionsResponse> getClassFunctions(ClassFunctionsRequest classRequest) throws IOException, UnsupportedLanguageException;
}
