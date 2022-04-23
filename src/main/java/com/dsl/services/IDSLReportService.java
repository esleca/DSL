package com.dsl.services;

import com.dsl.models.entities.unittests.UnitTest;

import java.util.List;

public interface IDSLReportService {

    List<UnitTest> getFunctionUnitTests(String inFunction);

    List<UnitTest> getClassUnitTests(String inClass);

    List<UnitTest> getPackageUnitTests(String inPackage);
}
