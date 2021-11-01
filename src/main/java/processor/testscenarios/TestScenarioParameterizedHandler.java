package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import factories.*;
import models.entities.parameters.ParameterFunction;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import models.entities.unittests.asserts.types.AssertType;
import models.entities.valuetypes.ValueType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import testrun.config.TestScenarioParameterizedRun;
import testrun.config.TestScenarioRun;
import java.util.ArrayList;


public class TestScenarioParameterizedHandler implements ITestScenarioRunHandler{

    private final ITestableUnitFactory testableFactory;
    private final IValueTypeFactory valueTypeFactory;
    private final IExpectedResultsFactory expectedResFactory;
    private final IAssertTypesFactory assertsFactory;
    private final IParametersFactory parametersFactory;

    public TestScenarioParameterizedHandler(ITestableUnitFactory testableFactory, IValueTypeFactory valueTypeFactory,
            IExpectedResultsFactory expectedFactory, IAssertTypesFactory assertsFactory, IParametersFactory parametersFactory){
        this.testableFactory = testableFactory;
        this.valueTypeFactory = valueTypeFactory;
        this.expectedResFactory = expectedFactory;
        this.assertsFactory = assertsFactory;
        this.parametersFactory = parametersFactory;
    }


    @Override
    public TestScenarioRun getTestScenarioRun(JSONObject configurationObject) throws ClassCastException, ValueTypeNotFoundException {
        ArrayList<ParameterScenario> parameterScenarios = new ArrayList<>();
        ArrayList<ValueType> expected = new ArrayList<>();

        String function = (String) configurationObject.get("function");
        String testName = (String) configurationObject.get("testName");
        JSONArray expectedArray = (JSONArray)configurationObject.get("expected");
        String assertion = (String) configurationObject.get("assert");
        JSONArray paramsArray = (JSONArray)configurationObject.get("parameters");

        for (Object paramRawObject : paramsArray) {
            JSONObject paramObject = (JSONObject) paramRawObject;
            Object value = paramObject.get("value");
            String name = (String) paramObject.get("name");
            String type = (String) paramObject.get("type");

            ValueType valueType = valueTypeFactory.createValueType(type, value);
            ParameterFunction parameterFunction = parametersFactory.createParameterFunction(type, name);
            ParameterScenario parameterScenario = parametersFactory.createParameterScenario(parameterFunction, valueType);
            parameterScenarios.add(parameterScenario);
        }

        for (Object expectedRawObject : expectedArray) {
            String longer = expectedRawObject.getClass().toString();
//            long v2 = longer;
String v3 = longer;
//            JSONObject paramObject = (JSONObject) expectedRawObject;

            //ValueType valueType = valueTypeFactory.createValueType(type, value);

            //JSONObject paramObject = (JSONObject) expectedRawObject;
            //Object value = paramObject.get("value");

        }

        return new TestScenarioParameterizedRun(function, testName, parameterScenarios, expected, assertion);
    }


    @Override
    public TestScenario getTestScenario(TestScenarioRun testScenarioRun, TestableUnit testableUnit)
            throws ValueTypeNotFoundException, AssertNotFoundException
    {
        TestScenarioParameterizedRun testScenarioParameterized = (TestScenarioParameterizedRun) testScenarioRun;

        AssertType assertType = assertsFactory.createAssertType(testScenarioParameterized.getAssertion());
        String returnName = testableUnit.getFunction().getReturn().getName();
        ValueType valueType = valueTypeFactory.createValueType(returnName, testScenarioParameterized.getExpected());
        //ExpectedResult expectedResult = expectedResFactory.createParameterizedExpectedResult(valueType);

        //return testableFactory.createTestScenario(testScenarioParameterized.getTestName(), testableUnit,
         //      testScenarioParameterized.getParameters(), expectedResult, assertType);

        return null;
    }

}
