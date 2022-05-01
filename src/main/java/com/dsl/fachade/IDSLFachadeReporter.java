package com.dsl.fachade;

import com.dsl.models.unittests.UnitTest;

import java.util.List;

public interface IDSLFachadeReporter {

    List<UnitTest> getFunctionUnitTests(String inFunction);

    List<UnitTest> getClassUnitTests(String inClass);

    List<UnitTest> getPackageUnitTests(String inPackage);

}
