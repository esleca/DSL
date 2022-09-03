package com.dsl.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.RequestsFactory;
import com.dsl.mappers.UnitTestMapper;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
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
    	// transform file to GAST
    	_compUnitsService.createCompilationUnits(unitTestRequest, model);
        
        // Visit GAST functions
    	_visitorService.visitCompilationUnits(model);

        // Write unit test into data store
    	_repoService.saveToDataStore(unitTestRequest, model);
        
        // Write code to files
    	ArrayList<String> outputLanguages = model.getOutputLanguages();
    	for(String language : outputLanguages) {
    		updateLanguageCode(language);
    	}
        
        return createUnitTest(unitTestRequest);
    }
    
    private void updateLanguageCode(String language) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	ArrayList<UnitTest> unitTests = new ArrayList<UnitTest>();
    	
    	ClassTestsRequest request = RequestsFactory.createClassTestsRequest(model);
    	
    	List<UnitTestRequest> unitTestRequests = _reportService.getClassUnitTestsRequests(request);
    	
    	if(validRequests(unitTestRequests)) {
    		for (UnitTestRequest unitTestRequest : unitTestRequests) {    			
        		
    			_compUnitsService.createCompilationUnits(unitTestRequest, model);    	
            	
        		_visitorService.visitCompilationUnits(model);
            	
            	_testableUnitsService.processTestableUnits(model);
            	
            	_testScenarioService.processTestScenario(unitTestRequest, model);
            	
            	UnitTest unitTest = _unitTestService.processUnitTest(model, language);
        		unitTests.add(unitTest);
    		}
        	
        	model.addUnitTests(unitTests);
        	
        	_compUnitsTestService.processCompilationUnitsTestsLoaded(model, language);
        	
            _printerService.generateCode(model, language, unitTestRequests.get(0).getOutputPath());
    	}
    }
    
    private boolean validRequests(List<UnitTestRequest> unitTestRequests) {
    	if(unitTestRequests != null && unitTestRequests.size() > 0) {
    		return true;
    	} else {
    		return false;
    	}
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
    	// transform file to GAST
    	_compUnitsService.createCompilationUnits(unitTestRequest, model);
        
        // Visit GAST functions
    	_visitorService.visitCompilationUnits(model);
     
        // Create testable units
    	_testableUnitsService.processTestableUnits(model);
        
        // Process user test scenarios
    	_testScenarioService.processTestScenario(unitTestRequest, model);
     
        // Create functions unit tests
    	_unitTestService.processUnitTest(model, unitTestRequest.getLanguage());
        
        return model.getUnitTest();
    }
}
