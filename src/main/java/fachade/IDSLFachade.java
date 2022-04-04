package fachade;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.dtos.UnitTestRequest;
import models.entities.unittests.UnitTest;

import java.io.IOException;
import java.util.List;

public interface IDSLFachade {

    UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws UnsupportedLanguageException, IOException, ValueTypeNotFoundException, AssertNotFoundException;

    UnitTest editUnitTest(String unitTestRequest);

    List<UnitTest> getFunctionUnitTests(String inFunction);

    List<UnitTest> getClassUnitTests(String inClass);

    List<UnitTest> getPackageUnitTests(String inPackage);

}
