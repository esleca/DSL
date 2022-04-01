package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import factories.*;
import models.entities.aggregates.Function;
import models.entities.parameters.ParameterFunction;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.ExpectedResult;
import models.entities.unittests.TestScenario;
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

    private final IExpectedPrimitive expectedPrimitive;
    private final IExpectedParameterized expectedParameterized;

    public TestScenarioHandler(IExpectedPrimitive expectedPrimitive, IExpectedParameterized expectedParameterized){
        this.expectedPrimitive = expectedPrimitive;
        this.expectedParameterized = expectedParameterized;
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
    public ArrayList<TestScenario> processTestScenarios(ArrayList<TestScenarioRun> testScenarioRuns, ArrayList<Function> functions) throws AssertNotFoundException {
        ArrayList<TestScenario> testScenarios = new ArrayList<>();

        for (TestScenarioRun testScenarioRun : testScenarioRuns){
            Function function = getFunction(testScenarioRun.getFunction(), functions);
            if (function != null){
                TestScenario testScenario = getTestScenario(testScenarioRun, function);
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
            paramRun.setExpected(expectedParameterized.getExpected(jsonObject));
            testScenarioRun = paramRun;
        }else{
            TestScenarioPrimitiveRun primRun = new TestScenarioPrimitiveRun(function, testName, parameterScenarios, assertion);
            primRun.setExpected(expectedPrimitive.getExpected(jsonObject));
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


    protected Function getFunction(String functionName, ArrayList<Function> testableFunctions) {
        for (Function function : testableFunctions) {
            if (function.getName().equals((functionName))){
                return function;
            }
        }
        return null;
    }


    protected TestScenario getTestScenario(TestScenarioRun testScenarioRun, Function function) throws AssertNotFoundException {
        AssertType assertType = AssertsFactory.createAssertType(testScenarioRun.getAssertion());
        ExpectedResult expectedResult;

        if (testScenarioRun instanceof TestScenarioParameterizedRun){
            ArrayList<ValueType> valueTypes = ((TestScenarioParameterizedRun) testScenarioRun).getExpected();
            expectedResult = ExpectedResultsFactory.createParameterizedExpectedResult(valueTypes);
        }else{
            TestScenarioPrimitiveRun primitiveRun = (TestScenarioPrimitiveRun) testScenarioRun;
            expectedResult = ExpectedResultsFactory.createPrimitiveExpectedResult(primitiveRun.getExpected());
        }

        return TestableUnitFactory.createTestScenario(testScenarioRun.getTestName(), function,
                testScenarioRun.getParameters(), expectedResult, assertType);
    }


}
