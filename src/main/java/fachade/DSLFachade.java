package fachade;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.dtos.UnitTestRequest;
import models.entities.unittests.UnitTest;
import repositories.DSLRepo;
import services.DSLReportService;
import services.DSLCrudService;
import services.IDSLReportService;
import services.IDSLCrudService;
import utils.ConsolePrinter;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;


public class DSLFachade implements IDSLFachade, IDSLFachadeReporter {

    @Inject private IDSLCrudService _CrudService;
    @Inject private IDSLReportService _ReportService;

    public DSLFachade(){
        this._CrudService = new DSLCrudService(new ConsolePrinter(), new DSLRepo());
        this._ReportService = new DSLReportService();
    }

    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {

        return _CrudService.createUnitTest(unitTestRequest);
    }

    @Override
    public UnitTest editUnitTest(UnitTestRequest unitTestRequest) {
        return _CrudService.editUnitTest(unitTestRequest);
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
        _CrudService.removeUnitTest(unitTestRequest);
    }


    @Override
    public List<UnitTest> getFunctionUnitTests(String inFunction) {
        return _ReportService.getFunctionUnitTests(inFunction);
    }

    @Override
    public List<UnitTest> getClassUnitTests(String inClass) {
        return _ReportService.getClassUnitTests(inClass);
    }

    @Override
    public List<UnitTest> getPackageUnitTests(String inPackage) {
        return _ReportService.getPackageUnitTests(inPackage);
    }

}
