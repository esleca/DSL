package com.dsl.services;

import java.io.IOException;
import org.springframework.stereotype.Component;

import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.UnitTest;
import com.dsl.repositories.IDSLRepository;
import com.dsl.services.compunits.ICompUnitsService;
import com.dsl.services.compunits.ICompUnitsTestService;
import com.dsl.services.printers.IPrinterService;
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
    private IDSLRepository _repository;
    private DSLModel model;
    
    public DSLProcessor(ICompUnitsService compUnitsService, IVisitorService visitorService, ITestableUnitsService testableUnitsService, 
    		ITestScenarioService testScenarioService, IUnitTestService utService, ICompUnitsTestService compUnitsTestService, 
    		IPrinterService printerService, IDSLRepository repository){
  		this._compUnitsService = compUnitsService;
  		this._visitorService = visitorService;
  		this._testableUnitsService = testableUnitsService;
  		this._testScenarioService = testScenarioService;
  		this._unitTestService = utService;
      	this._compUnitsTestService = compUnitsTestService;
      	this._printerService = printerService;
      	this._repository = repository;
      	this.model = new DSLModel();
    }

    
    @Override
    public UnitTest generateUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	// transform file to GAST
    	_compUnitsService.createCompilationUnits(unitTestRequest, model);
        
        // Visit GAST functions
    	_visitorService.visitCompilationUnits(model);
     
        // Create testable units
    	_testableUnitsService.processTestableUnits(model);
        
        // Process user test scenarios
    	_testScenarioService.processTestScenario(unitTestRequest, model);
     
        // Create functions unit tests
    	_unitTestService.processUnitTest(model);
     
        // Write unit tests to GAST
    	_compUnitsTestService.processCompilationUnitsTests(model);
        
        // Write unit test into database
        _repository.saveToDataStore(unitTestRequest);
        
        // Write code to files
        _printerService.generateCode(unitTestRequest, model);
        
        return model.getUnitTest();
    }
    
    @Override
    public UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	// transform file to GAST
    	_compUnitsService.createCompilationUnits(unitTestRequest, model);
        
        // Visit GAST functions
    	_visitorService.visitCompilationUnits(model);
     
        // Create testable units
    	_testableUnitsService.processTestableUnits(model);
        
        // Process user test scenarios
    	_testScenarioService.processTestScenario(unitTestRequest, model);
     
        // Create functions unit tests
    	_unitTestService.processUnitTest(model);
     
        // Write unit tests to GAST
    	_compUnitsTestService.processCompilationUnitsTests(model);
        
        return model.getUnitTest();
    }
    

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
    }
}
