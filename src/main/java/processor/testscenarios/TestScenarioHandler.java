package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import factories.*;
import models.dtos.UnitTestRequest;
import models.entities.aggregates.Function;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.ExpectedResult;
import models.entities.unittests.TestScenario;
import models.entities.unittests.asserts.types.AssertType;
import org.json.simple.JSONArray;

import java.util.ArrayList;

public class TestScenarioHandler extends TestScenarioHandlerBase implements ITestScenarioHandler {

    public TestScenarioHandler(IExpectedPrimitiveHandler expectedPrimitive, IExpectedParameterizedHandler expectedParameterized){
        super(expectedPrimitive, expectedParameterized);
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

        return TestableUnitFactory.createTestScenario(request.getTestName(), function, parameters,
                expectedResult, assertType);
    }

}
