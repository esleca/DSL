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
import com.dsl.mappers.ClassFunctionsMapper;
import com.dsl.models.dtos.*;
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
    
	private final ICompUnitsService compUnitsService;
	private final IVisitorService visitorService;
	private final ITestableUnitsService testableUnitsService;
	private final ITestScenarioService testScenarioService;
	private final IUnitTestService unitTestService;
	private final ICompUnitsTestService compUnitsTestService;
	private final IPrinterService printerService;
	private final IReportService reportService;
    private final IRepoService repoService;
    private DSLModel model;
    
    public DSLProcessor(ICompUnitsService compUnitsService, IVisitorService visitorService, ITestableUnitsService testableUnitsService, 
    		ITestScenarioService testScenarioService, IUnitTestService utService, ICompUnitsTestService compUnitsTestService, 
    		IPrinterService printerService, IReportService reportService, IRepoService repoService){
  		this.compUnitsService = compUnitsService;
  		this.visitorService = visitorService;
  		this.testableUnitsService = testableUnitsService;
  		this.testScenarioService = testScenarioService;
  		this.unitTestService = utService;
      	this.compUnitsTestService = compUnitsTestService;
      	this.printerService = printerService;
      	this.reportService = reportService;
      	this.repoService = repoService;
      	this.model = new DSLModel();
    }

    
    @Override
    public UnitTestResponse generateUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	compUnitsService.createCompilationUnits(unitTestRequest, model);
    	
    	visitorService.visitCompilationUnits(model);
    	
    	repoService.saveToDataStore(unitTestRequest, model);
        
    	for(String language : model.getOutputLanguages()) {
			updateCode(language);
    	}

		UnitTest unitTest = createUnitTest(unitTestRequest);

		return UnitTestMapper.convertUnitTestResponse(unitTest);
    }

    @Override
    public void removeUnitTest(UnitTestRequest unitTestRequest) {
    }

    @Override
    public List<UnitTestResponse> getFunctionUnitTests(FunctionTestsRequest functionRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = reportService.getFunctionUnitTests(functionRequest);
		return createUnitTestsResponse(metaData);
    }

    @Override
    public List<UnitTestResponse> getClassUnitTests(ClassTestsRequest classRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = reportService.getClassUnitTests(classRequest);
		return createUnitTestsResponse(metaData);
    }

    @Override
    public List<UnitTestResponse> getPackageUnitTests(PackageTestsRequest packageRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	List<UnitTestMetaData> metaData = reportService.getPackageUnitTests(packageRequest);
		return createUnitTestsResponse(metaData);
    }

	@Override
	public List<ClassFunctionsResponse> getClassFunctions(ClassFunctionsRequest classRequest) throws IOException, UnsupportedLanguageException {
		List<ClassFunctionsResponse> response = new ArrayList<>();

		compUnitsService.createCompilationUnits(classRequest, model);

		visitorService.visitCompilationUnits(model);

		testableUnitsService.processTestableUnits(model);

		for(Function function : model.getTestableUnits()){
			ClassFunctionsResponse classFunction = ClassFunctionsMapper.convertClassFunction(function);
			response.add(classFunction);
		}

		return response;
	}
    
    private void updateCode(String language) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	ArrayList<UnitTest> unitTests = new ArrayList<>();

    	ClassTestsRequest request = RequestsFactory.createClassTestsRequest(model);

    	List<UnitTestRequest> unitTestRequests = reportService.getClassUnitTestsRequests(request);
    	
    	if(DtoUtil.validRequests(unitTestRequests)) {
    		for (UnitTestRequest unitTestRequest : unitTestRequests) {
    			
    			compUnitsService.createCompilationUnits(unitTestRequest, model);
    			
        		visitorService.visitCompilationUnits(model);
        		
            	testableUnitsService.processTestableUnits(model);
            	
            	testScenarioService.processTestScenario(unitTestRequest, model);

            	UnitTest unitTest = unitTestService.processUnitTest(model, language);
            	unitTests.add(unitTest);
    		}
        	
        	model.addUnitTests(unitTests);
        	
        	compUnitsTestService.processCompilationUnitsTests(model, language);
        	
            printerService.generateCode(model, language, unitTestRequests.get(0).getOutputPath());
    	}
    }
    
    private List<UnitTestResponse> createUnitTestsResponse(List<UnitTestMetaData> metaData) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException{
		List<UnitTestResponse> unitTestsResponse = new ArrayList<>();
	
		for (UnitTestMetaData utMetaData : metaData) {

	    	UnitTestRequest request = UnitTestMapper.convertUnitTestRequest(utMetaData);

	    	UnitTest unitTest = createUnitTest(request);

			UnitTestResponse response = UnitTestMapper.convertUnitTestResponse(unitTest);

			unitTestsResponse.add(response);
		}
		
		return unitTestsResponse;
	}
    
    private UnitTest createUnitTest(UnitTestRequest unitTestRequest) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
    	compUnitsService.createCompilationUnits(unitTestRequest, model);
    	
    	visitorService.visitCompilationUnits(model);
    	
    	testableUnitsService.processTestableUnits(model);
    	
    	testScenarioService.processTestScenario(unitTestRequest, model);

		return unitTestService.processUnitTest(model, unitTestRequest.getLanguage());
    }
}
