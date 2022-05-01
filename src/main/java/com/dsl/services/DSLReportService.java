package com.dsl.services;

import com.dsl.models.unittests.UnitTest;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DSLReportService implements IDSLReportService{

    public DSLReportService(){
    }

    @Override
    public List<UnitTest> getFunctionUnitTests(String inFunction) {
        return null;
    }

    @Override
    public List<UnitTest> getClassUnitTests(String inClass) {
        return null;
    }

    @Override
    public List<UnitTest> getPackageUnitTests(String inPackage) {
        return null;
    }
}
