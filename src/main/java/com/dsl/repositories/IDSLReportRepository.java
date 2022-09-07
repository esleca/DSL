package com.dsl.repositories;

import java.util.List;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;

public interface IDSLReportRepository {

    List<UnitTestMetaData> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws ValueTypeNotFoundException;

    List<UnitTestMetaData> getClassUnitTests(ClassTestsRequest classRequest) throws ValueTypeNotFoundException;

    List<UnitTestMetaData> getPackageUnitTests(PackageTestsRequest packageRequest) throws ValueTypeNotFoundException;
}
