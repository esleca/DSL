package com.dsl.fachade;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.entities.unittests.UnitTest;

import java.io.IOException;
import java.util.List;

public interface IDSLFachade {

    UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws UnsupportedLanguageException, IOException, ValueTypeNotFoundException, AssertNotFoundException;

    UnitTest editUnitTest(UnitTestRequest unitTestRequest);

    void removeUnitTest(UnitTestRequest unitTestRequest);
    
    List<UnitTest> getFunctionUnitTests(String inFunction);

    List<UnitTest> getClassUnitTests(String inClass);

    List<UnitTest> getPackageUnitTests(String inPackage);

}
