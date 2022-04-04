package services;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.dtos.UnitTestRequest;
import models.entities.unittests.UnitTest;

import java.io.IOException;
import java.util.List;

public interface IDSLService {

    UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    UnitTest editUnitTest(UnitTestRequest unitTestRequest);

    List<UnitTest> getFunctionUnitTests(String inFunction);

    List<UnitTest> getClassUnitTests(String inClass);

    List<UnitTest> getPackageUnitTests(String inPackage);
}
