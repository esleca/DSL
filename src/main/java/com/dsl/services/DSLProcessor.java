package com.dsl.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dsl.mappers.ClassFunctionsMapper;
import com.dsl.models.dtos.*;
import org.springframework.stereotype.Component;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.RequestsFactory;
import com.dsl.mappers.UnitTestMapper;
import com.dsl.models.aggregates.Function;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.unittests.UnitTest;
import com.dsl.services.compunits.ICompUnitsService;
import com.dsl.services.compunits.ICompUnitsTestService;
import com.dsl.services.printers.IPrinterService;
import com.dsl.services.persistance.IRepoService;
import com.dsl.services.persistance.IReportService;
import com.dsl.services.testableunits.ITestableUnitsService;
import com.dsl.services.testscenarios.ITestScenarioService;
import com.dsl.services.unittests.IUnitTestService;
import com.dsl.services.visitor.IVisitorService;
import com.dsl.utils.DtoUtil;


@Component
public class DSLProcessor implements IDSLProcessor {
    
	private ICompUnitsService _compUnitsService;
	private IVisitorService _visitorService;
	private ITestableUnitsService _testableUnitsService;
	private ITestScenarioService _testScenarioService;
	private IUnitTestService _unitTestService;
	private ICompUnitsTestService _compUnitsTestService;
	private IPrinterService _printerService;
	private IReportService _reportService;
    private IRepoService _repoService;
    private DSLModel model;
    
    public DSLProcessor(ICompUnitsService compUnitsService, IVisitorService visitorService, ITestableUnitsService testableUnitsService, 
    		ITestScenarioService testScenarioService, IUnitTestService utService, ICompUnitsTestService compUnitsTestService, 
    		IPrinterService printerService, IReportService reportService, IRepoService repoService){
  		this._compUnitsService = compUnitsService;
  		this._visitorService = visitorService;
  		this._testableUnitsService = testableUnitsService;
  		this._testScenarioService = testScenarioService;
  		this._unitTestService = utService;
      	this._compUnitsTestService = compUnitsTestService;
      	this._printerService = printerService;
      	this._reportService = reportService;
      	this._repoService = repoService;
      	this.model = new DSLModel();
    }

    
    @Override
    public UnitTest generateUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	_compUnitsService.createCompilationUnits(unitTestRequest, model);
    	
    	_visitorService.visitCompilationUnits(model);
    	
    	_repoService.saveToDataStore(unitTestRequest, model);
        
    	for(String language : model.getOutputLanguages()) {
    		updateLanguageCode(language);
    	}
        
        return createUnitTest(unitTestRequest);
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
    }

    @Override
    public List<UnitTest> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _reportService.getFunctionUnitTests(functionRequest);
		return createUnitTests(metaData);
    }

    @Override
    public List<UnitTest> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _reportService.getClassUnitTests(classRequest);
		return createUnitTests(metaData);
    }

    @Override
    public List<UnitTest> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = _reportService.getPackageUnitTests(packageRequest);
		return createUnitTests(metaData);
    }

	@Override
	public List<ClassFunctionsResponse> getClassFunctions(ClassFunctionsRequest classRequest) throws IOException, UnsupportedLanguageException {
		List<ClassFunctionsResponse> response = new ArrayList<>();

		_compUnitsService.createCompilationUnits(classRequest, model);

		_visitorService.visitCompilationUnits(model);

		_testableUnitsService.processTestableUnits(model);

		for(Function function : model.getTestableUnits()){
			ClassFunctionsResponse classFunction = ClassFunctionsMapper.convertClassFunction(function);
			response.add(classFunction);
		}

		return response;
	}
    
    private void updateLanguageCode(String language) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	ArrayList<UnitTest> unitTests = new ArrayList<UnitTest>();
    	ClassTestsRequest request = RequestsFactory.createClassTestsRequest(model);
    	List<UnitTestRequest> unitTestRequests = _reportService.getClassUnitTestsRequests(request);
    	
    	if(DtoUtil.validRequests(unitTestRequests)) {
    		for (UnitTestRequest unitTestRequest : unitTestRequests) {
    			
    			_compUnitsService.createCompilationUnits(unitTestRequest, model);
    			
        		_visitorService.visitCompilationUnits(model);
        		
            	_testableUnitsService.processTestableUnits(model);
            	
            	_testScenarioService.processTestScenario(unitTestRequest, model);
            	
            	unitTests.add(_unitTestService.processUnitTest(model, language));
    		}
        	
        	model.addUnitTests(unitTests);
        	
        	_compUnitsTestService.processCompilationUnitsTests(model, language);
        	
            _printerService.generateCode(model, language, unitTestRequests.get(0).getOutputPath());
    	}
    }
    
    private List<UnitTest> createUnitTests(List<UnitTestMetaData> metaData) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException{
		List<UnitTest> unitTests = new ArrayList<UnitTest>();
	
		for (UnitTestMetaData utMetaData : metaData) {
	    	UnitTestRequest unitTestRequest = UnitTestMapper.convertUnitTest(utMetaData);
	    	UnitTest unitTest = createUnitTest(unitTestRequest);	
	    	unitTests.add(unitTest);
		}
		
		return unitTests;
	}
    
    private UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	_compUnitsService.createCompilationUnits(unitTestRequest, model);
    	
    	_visitorService.visitCompilationUnits(model);
    	
    	_testableUnitsService.processTestableUnits(model);
    	
    	_testScenarioService.processTestScenario(unitTestRequest, model);
    	
    	return _unitTestService.processUnitTest(model, unitTestRequest.getLanguage());
    }
}
