package com.dsl.repositories;

import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;

public interface IDSLRepo {

    UnitTest saveToDataStore(UnitTestRequest request);
}
