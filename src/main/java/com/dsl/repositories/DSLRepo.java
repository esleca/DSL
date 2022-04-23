package com.dsl.repositories;

import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.entities.unittests.UnitTest;

import org.springframework.stereotype.Component;

@Component
public class DSLRepo implements IDSLRepo{

    @Override
    public UnitTest saveToDataStore(UnitTestRequest request) {
        return null;
    }
}
