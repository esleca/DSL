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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import testrun.config.TestScenarioParameterizedRun;
import testrun.config.TestScenarioPrimitiveRun;
import testrun.config.TestScenarioRun;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TestScenarioHandler implements ITestScenarioHandler {

    private final IExpectablePrimitive expectablePrimitive;
    private final IExpectableParameterized expectableParameterized;

    public TestScenarioHandler(IExpectablePrimitive expectablePrimitive, IExpectableParameterized expectableParameterized){
        this.expectablePrimitive = expectablePrimitive;
        this.expectableParameterized = expectableParameterized;
    }


    @Override
    public ArrayList<TestScenarioRun> processTestScenariosRun(String scenariosPath) {
        ArrayList<TestScenarioRun> testScenarios = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(scenariosPath)) {
            JSONArray configurationsArray = (JSONArray) jsonParser.parse(reader);

            for (Object configurationRawObject : configurationsArray) {
                TestScenarioRun test = getTestScenarioRun((JSONObject) configurationRawObject);
                testScenarios.add(test);
            }
        } catch (IOException | ParseException | ValueTypeNotFoundException | ClassCastException e) {
            System.err.println("Error reading the configuration file.");
            e.printStackTrace();
        }
        return testScenarios;
    }


    @Override
    public ArrayList<TestScenario> processTestScenarios(ArrayList<TestScenarioRun> testScenarioRuns, ArrayList<TestableUnit> testableUnits)
            throws ValueTypeNotFoundException, AssertNotFoundException {
        ArrayList<TestScenario> testScenarios = new ArrayList<>();

        for (TestScenarioRun testScenarioRun : testScenarioRuns){
            TestableUnit testableUnit = getTestableUnit(testScenarioRun.getFunction(), testableUnits);
            if (testableUnit != null){
                TestScenario testScenario = getTestScenario(testScenarioRun, testableUnit);
                testScenarios.add(testScenario);
            }
        }
        return testScenarios;
    }


    protected TestScenarioRun getTestScenarioRun(JSONObject jsonObject) throws ClassCastException, ValueTypeNotFoundException {
        String function = (String) jsonObject.get("function");
        String testName = (String) jsonObject.get("testName");
        String assertion = (String) jsonObject.get("assert");
        JSONArray paramsArray = (JSONArray)jsonObject.get("parameters");
        ArrayList<ParameterScenario> parameterScenarios = getParameterScenarios(paramsArray);

        TestScenarioRun testScenarioRun;
        Object expected = jsonObject.get("expected");

        if (expected instanceof JSONArray){
            TestScenarioParameterizedRun paramRun = new TestScenarioParameterizedRun(function, testName, parameterScenarios, assertion);
            paramRun.setExpected(expectableParameterized.getExpected(jsonObject));
            testScenarioRun = paramRun;
        }else{
            TestScenarioPrimitiveRun primRun = new TestScenarioPrimitiveRun(function, testName, parameterScenarios, assertion);
            primRun.setExpected(expectablePrimitive.getExpected(jsonObject));
            testScenarioRun = primRun;
        }

        return testScenarioRun;
    }


    protected ArrayList<ParameterScenario> getParameterScenarios(JSONArray paramsArray) throws ValueTypeNotFoundException {
        ArrayList<ParameterScenario> parameterScenarios = new ArrayList<>();

        for (Object paramRawObject : paramsArray) {
            JSONObject paramObject = (JSONObject) paramRawObject;
            ParameterScenario parameterScenario = getParameterScenario(paramObject);
            parameterScenarios.add(parameterScenario);
        }
        return parameterScenarios;
    }


    protected ParameterScenario getParameterScenario(JSONObject paramObject) throws ValueTypeNotFoundException {
        Object value = paramObject.get("value");
        String name = (String) paramObject.get("name");
        String type = (String) paramObject.get("type");

        ValueType valueType = ValueTypeFactory.createValueType(type, value);
        ParameterFunction parameterFunction = ParametersFactory.createParameterFunction(type, name);

        return ParametersFactory.createParameterScenario(parameterFunction, valueType);
    }


    protected TestableUnit getTestableUnit(String functionName, ArrayList<TestableUnit> testableUnits) {
        for (TestableUnit testableUnit : testableUnits) {
            if (testableUnit.getFunction().getName().equals((functionName))){
                return testableUnit;
            }
        }
        return null;
    }


    protected TestScenario getTestScenario(TestScenarioRun testScenarioRun, TestableUnit testableUnit)
            throws ValueTypeNotFoundException, AssertNotFoundException {
        AssertType assertType = AssertsFactory.createAssertType(testScenarioRun.getAssertion());
        ExpectedResult expectedResult;

        if (testScenarioRun instanceof TestScenarioParameterizedRun){
            ArrayList<ValueType> valueTypes = ((TestScenarioParameterizedRun) testScenarioRun).getExpected();
            expectedResult = ExpectedResultsFactory.createParameterizedExpectedResult(valueTypes);
        }else{
            TestScenarioPrimitiveRun primitiveRun = (TestScenarioPrimitiveRun) testScenarioRun;
            String returnName = testableUnit.getFunction().getReturn().getName();
            ValueType valueType = ValueTypeFactory.createValueType(returnName, primitiveRun.getExpected());
            expectedResult = ExpectedResultsFactory.createPrimitiveExpectedResult(valueType);
        }

        return TestableUnitFactory.createTestScenario(testScenarioRun.getTestName(), testableUnit,
                testScenarioRun.getParameters(), expectedResult, assertType);
    }


}
