package com.dsl.services;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;
import java.io.IOException;

public interface IDSLProcessor {

    UnitTest generateUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    void removeUnitTest(UnitTestRequest unitTestRequest);

	UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
			UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;
}
