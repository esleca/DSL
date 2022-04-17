package fachade;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.dtos.UnitTestRequest;
import models.entities.unittests.UnitTest;

import java.io.IOException;

public interface IDSLFachade {

    UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws UnsupportedLanguageException, IOException, ValueTypeNotFoundException, AssertNotFoundException;

    UnitTest editUnitTest(UnitTestRequest unitTestRequest);

    void removeUnitTest(UnitTestRequest unitTestRequest);
}
