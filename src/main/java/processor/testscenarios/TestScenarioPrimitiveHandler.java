package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import factories.*;
import models.entities.parameters.ParameterFunction;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.ExpectedResult;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import models.entities.unittests.asserts.types.AssertType;
import models.entities.valuetypes.ValueType;

import testrun.config.TestScenarioPrimitiveRun;
import testrun.config.TestScenarioRun;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;


public class TestScenarioPrimitiveHandler implements ITestScenarioRunHandler {

    private final ITestableUnitFactory testableFactory;
    private final IValueTypeFactory valueTypeFactory;
    private final IExpectedResultsFactory expectedResFactory;
    private final IAssertTypesFactory assertsFactory;
    private final IParametersFactory parametersFactory;

    public TestScenarioPrimitiveHandler(ITestableUnitFactory testableFactory, IValueTypeFactory valueTypeFactory,
                                            IExpectedResultsFactory expectedFactory, IAssertTypesFactory assertsFactory,
                                            IParametersFactory parametersFactory){
        this.testableFactory = testableFactory;
        this.valueTypeFactory = valueTypeFactory;
        this.expectedResFactory = expectedFactory;
        this.assertsFactory = assertsFactory;
        this.parametersFactory = parametersFactory;
    }



    @Override
    public TestScenarioRun getTestScenarioRun(JSONObject configurationObject) throws ClassCastException, ValueTypeNotFoundException {
        ArrayList<ParameterScenario> parameterScenarios = new ArrayList<>();
        String function = (String) configurationObject.get("function");
        String testName = (String) configurationObject.get("testName");
        String expected = (String) configurationObject.get("expected");
        String assertion = (String) configurationObject.get("assert");
        JSONArray paramsArray = (JSONArray)configurationObject.get("parameters");

        for (Object paramRawObject : paramsArray) {
            JSONObject paramObject = (JSONObject) paramRawObject;
            ParameterScenario parameterScenario = getParameterScenario(paramObject);
            parameterScenarios.add(parameterScenario);
        }

        return new TestScenarioPrimitiveRun(function, testName, parameterScenarios, expected, assertion);
    }

    private ParameterScenario getParameterScenario(JSONObject paramObject) throws ValueTypeNotFoundException {
        Object value = paramObject.get("value");
        String name = (String) paramObject.get("name");
        String type = (String) paramObject.get("type");

        ValueType valueType = valueTypeFactory.createValueType(type, value);
        ParameterFunction parameterFunction = parametersFactory.createParameterFunction(type, name);

        return parametersFactory.createParameterScenario(parameterFunction, valueType);
    }


    @Override
    public TestScenario getTestScenario(TestScenarioRun testScenarioRun, TestableUnit testableUnit)
            throws ValueTypeNotFoundException, AssertNotFoundException
    {
        TestScenarioPrimitiveRun testScenarioPrimitive = (TestScenarioPrimitiveRun )testScenarioRun;

        AssertType assertType = assertsFactory.createAssertType(testScenarioPrimitive.getAssertion());
        String returnName = testableUnit.getFunction().getReturn().getName();
        ValueType valueType = valueTypeFactory.createValueType(returnName, testScenarioPrimitive.getExpected());
        ExpectedResult expectedResult = expectedResFactory.createPrimitiveExpectedResult(valueType);

        return testableFactory.createTestScenario(testScenarioPrimitive.getTestName(), testableUnit, testScenarioPrimitive.getParameters(), expectedResult, assertType);
    }

}
