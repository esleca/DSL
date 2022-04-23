package com.dsl.services;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.entities.unittests.UnitTest;
import java.io.IOException;

public interface IDSLCrudService {

    UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException;

    UnitTest editUnitTest(UnitTestRequest unitTestRequest);

    void removeUnitTest(UnitTestRequest unitTestRequest);

}
