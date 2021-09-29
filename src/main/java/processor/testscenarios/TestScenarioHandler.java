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
import testrun.config.TestScenarioRun;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestScenarioHandler implements ITestScenarioHandler {

    private TestableFactory testsFactory;
    private ValueTypeFactory valueTypeFactory;
    private ExpectedResultsFactory expectedResultsFactory;
    private AssertsFactory assertsFactory;
    private ParametersFactory parametersFactory;

    public TestScenarioHandler(){
        testsFactory = new TestableFactory();
        valueTypeFactory = new ValueTypeFactory();
        expectedResultsFactory = new ExpectedResultsFactory();
        assertsFactory = new AssertsFactory();
        parametersFactory = new ParametersFactory();
    }


    /**
     * Receive the path where the test scenarios are stored
     * Return the objects representation of the test scenarios
     * TODO: web UI should send complete json scenarios instead
     * TODO: of the handler reading the file from disk.
     *
     * @param scenariosPath
     * @return
     */
    @Override
    public ArrayList<TestScenarioRun> processTestScenariosRun(String scenariosPath) {
        ArrayList<TestScenarioRun> testScenarios = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(scenariosPath)) {
            JSONArray configurationsArray = (JSONArray) jsonParser.parse(reader);

            for (Object configurationRawObject : configurationsArray) {
                JSONObject configurationObject = (JSONObject) configurationRawObject;
                TestScenarioRun test = getTestScenarioRun(configurationObject);
                testScenarios.add(test);
            }

        } catch (IOException | ParseException | ValueTypeNotFoundException e) {
            System.err.println("Error reading the configuration file.");
            e.printStackTrace();
        }

        return testScenarios;
    }



    /**
     * Create an instance of the TestScenarioRun object being loaded from file
     *
     * @param configurationObject
     * @return
     * @throws ClassCastException
     */
    private TestScenarioRun getTestScenarioRun(JSONObject configurationObject) throws ClassCastException, ValueTypeNotFoundException {
        ArrayList<ParameterScenario> parameterScenarios = new ArrayList<>();
        String function = (String) configurationObject.get("function");
        String testName = (String) configurationObject.get("testName");
        String expected = (String) configurationObject.get("expected");
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

        return new TestScenarioRun(function, testName, parameterScenarios, expected, assertion);
    }

    /**
     * Receive two lists, test scenarios and testable units
     * Process the parameters lists and return a list of
     * Test scenarios.
     *
     * @param testScenarioRuns
     * @param testableUnits
     * @return Test scenarios list
     */
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

    private TestableUnit getTestableUnit(String functionName, ArrayList<TestableUnit> testableUnits) {
        for (TestableUnit testableUnit : testableUnits) {
            if (testableUnit.getFunction().getName().equals((functionName))){
                return testableUnit;
            }
        }
        return null;
    }

    private TestScenario getTestScenario(TestScenarioRun testScenarioRun, TestableUnit testableUnit)
            throws ValueTypeNotFoundException, AssertNotFoundException {
        AssertType assertType = assertsFactory.createAssertType(testScenarioRun.getAssertion());
        ValueType valueType = valueTypeFactory.createValueType(testableUnit.getFunction().getReturn().getName(), testScenarioRun.getExpected());
        ExpectedResult expectedResult = expectedResultsFactory.createExpectedResult(valueType);
        return testsFactory.createTestScenario(testScenarioRun.getTestName(), testableUnit, testScenarioRun.getParameters(), expectedResult, assertType);
    }

}
