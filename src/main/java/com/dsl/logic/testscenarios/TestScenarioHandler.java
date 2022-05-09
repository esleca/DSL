package com.dsl.logic.testscenarios;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.*;
import com.dsl.logic.expectedresults.IExpectedResultHandler;
import com.dsl.logic.parameterscenarios.IParameterScenarioHandler;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.aggregates.Function;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.types.AssertType;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;


@Component
public class TestScenarioHandler implements ITestScenarioHandler {

	protected final IParameterScenarioHandler _parameterScenarioHandler;
	protected final IExpectedResultHandler _expectedResultHandler;

    public TestScenarioHandler(IParameterScenarioHandler paramScenarioHandler, IExpectedResultHandler expectedResultHandler){
        this._parameterScenarioHandler = paramScenarioHandler;
        this._expectedResultHandler = expectedResultHandler;
    }
    

    @Override
    public TestScenario processTestScenario(UnitTestRequest request, ArrayList<Function> testableUnits) throws ValueTypeNotFoundException, AssertNotFoundException {
        TestScenario testScenario = null;

        Function function = getFunction(request.getFunction(), testableUnits);
        if (function != null){
            testScenario = getTestScenario(request, function);
        }

        return testScenario;
    }
    
    
    protected TestScenario getTestScenario(UnitTestRequest request, Function function) throws AssertNotFoundException, ValueTypeNotFoundException {
        AssertType assertType = AssertsFactory.createAssertType(request.getAssert());
        
        JSONArray paramsArray = request.getParameters();
        ArrayList<ParameterScenario> parameters = _parameterScenarioHandler.getParameterScenarios(paramsArray);
        
        ExpectedResult expectedResult = _expectedResultHandler.getExpectedResult(request);
        
        return TestableUnitFactory.createTestScenario(request.getTestName(), function, parameters, expectedResult, assertType);
    }
    
    protected Function getFunction(String functionName, ArrayList<Function> testableUnits) {
        for (Function function : testableUnits) {
            if (function.getName().equals((functionName))){
                return function;
            }
        }
        return null;
    }
    
}
