package com.dsl.fachade;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;

import java.io.IOException;
import java.util.List;

public interface IDSLCrudFachade {

    UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws UnsupportedLanguageException, IOException, ValueTypeNotFoundException, AssertNotFoundException;

    UnitTest editUnitTest(UnitTestRequest unitTestRequest);

    void removeUnitTest(UnitTestRequest unitTestRequest);

}
