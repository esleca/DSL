package com.dsl.logic.testscenarios;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.*;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.parameters.ParameterScenario;
import com.dsl.models.entities.unittests.ExpectedResult;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.asserts.types.AssertType;
import org.json.simple.JSONArray;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class TestScenarioHandler extends TestScenarioHandlerBase implements ITestScenarioHandler {

    public TestScenarioHandler(IExpectedPrimitiveHandler expectedPrimitiveHandler, IExpectedParameterizedHandler expectedParameterizedHandler){
        super(expectedPrimitiveHandler, expectedParameterizedHandler);
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
        ArrayList<ParameterScenario> parameters = getParameterScenarios(paramsArray);
        
        ExpectedResult expectedResult = null;

        Object expected = request.getExpected();
        
        if (expected instanceof JSONArray){
            expectedResult = null;
            //_expectedPrimitiveHandler.getExpected(e)
        }else{
            expectedResult = null;
        }

//        if (testScenarioRun instanceof TestScenarioParameterizedRun){
//            ArrayList<ValueType> valueTypes = ((TestScenarioParameterizedRun) testScenarioRun).getExpected();
//            expectedResult = ExpectedResultsFactory.createParameterizedExpectedResult(valueTypes);
//        }else{
//            TestScenarioPrimitiveRun primitiveRun = (TestScenarioPrimitiveRun) testScenarioRun;
//            expectedResult = ExpectedResultsFactory.createPrimitiveExpectedResult(primitiveRun.getExpected());
//        }

        return TestableUnitFactory.createTestScenario(request.getTestName(), function, parameters, expectedResult, assertType);
    }

}
