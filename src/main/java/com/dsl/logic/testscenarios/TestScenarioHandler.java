package com.dsl.logic.testscenarios;

import java.util.ArrayList;
import java.util.Optional;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.AssertTypesFactory;
import com.dsl.factories.TestableUnitFactory;
import com.dsl.logic.expectedresults.IExpectedResultHandler;
import com.dsl.logic.parameterscenarios.IParameterScenarioHandler;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.aggregates.Function;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.types.AssertType;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;


@Component
public class TestScenarioHandler implements ITestScenarioHandler {

	protected IParameterScenarioHandler _parameterScenarioHandler;
	protected IExpectedResultHandler _expectedResultHandler;

    public TestScenarioHandler(IParameterScenarioHandler paramScenarioHandler, IExpectedResultHandler expectedResultHandler){
        _parameterScenarioHandler = paramScenarioHandler;
        _expectedResultHandler = expectedResultHandler;
    }
    

    @Override
    public TestScenario processTestScenario(UnitTestRequest request, ArrayList<Function> testableUnits) throws ValueTypeNotFoundException, AssertNotFoundException {
        TestScenario testScenario = null;
        
        Optional<Function> stream = testableUnits.stream()
    			.filter(f -> f.getName().equals(request.getFunction()))
    			.findFirst();
        
        if (stream.isPresent())
        	testScenario = getTestScenario(request, stream.get());
        
        return testScenario;
    }
    
    protected TestScenario getTestScenario(UnitTestRequest request, Function function) throws AssertNotFoundException, ValueTypeNotFoundException {
        AssertType assertType = AssertTypesFactory.createAssertType(request.getAssert(), request.getLanguage());
        JSONArray paramsArray = request.getParameters();
        
        ArrayList<ParameterScenario> parameters = _parameterScenarioHandler.getParameterScenarios(paramsArray);
        ExpectedResult expectedResult = _expectedResultHandler.getExpectedResult(request);
        
        return TestableUnitFactory.createTestScenario(request.getTestName(), function, parameters, expectedResult, request.getAssert(), assertType);
    }
    
}
