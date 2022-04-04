package fachade;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.dtos.UnitTestRequest;
import models.entities.unittests.UnitTest;
import services.DSLService;
import services.IDSLService;
import utils.IPrinter;
import utils.ConsolePrinter;
import java.io.IOException;
import java.util.List;

public class DSLFachade implements IDSLFachade {

    private IDSLService _Service;

    public DSLFachade(){
        IPrinter printer = new ConsolePrinter();
        this._Service = new DSLService(printer);
    }

    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {

        return _Service.createUnitTest(unitTestRequest);
    }

    @Override
    public UnitTest editUnitTest(UnitTestRequest unitTestRequest) {
        return _Service.editUnitTest(unitTestRequest);
    }

    @Override
    public List<UnitTest> getFunctionUnitTests(String inFunction) {
        return _Service.getFunctionUnitTests(inFunction);
    }

    @Override
    public List<UnitTest> getClassUnitTests(String inClass) {
        return _Service.getClassUnitTests(inClass);
    }

    @Override
    public List<UnitTest> getPackageUnitTests(String inPackage) {
        return _Service.getPackageUnitTests(inPackage);
    }

}
