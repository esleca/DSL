package com.dsl.repositories;

import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.entities.unittests.UnitTest;

public interface IDSLRepo {

    UnitTest saveToDataStore(UnitTestRequest request);
}
