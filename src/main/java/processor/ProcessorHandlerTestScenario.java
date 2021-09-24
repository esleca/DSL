package processor;

import factories.ExpectedResultsFactory;
import factories.ParametersFactory;
import factories.TestableFactory;
import factories.ValueTypeFactory;
import models.entities.parameters.ParameterFunction;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.ExpectedResult;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import models.entities.valuetypes.ValueType;
import testrun.config.TestScenarioRun;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ProcessorHandlerTestScenario implements IProcessorHandlerTestScenario {

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
    public ArrayList<TestScenarioRun> readTestScenariosRun(String scenariosPath){
        ArrayList<TestScenarioRun> testScenarios = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(scenariosPath)) {
            JSONArray configurationsArray = (JSONArray) jsonParser.parse(reader);

            for (Object configurationRawObject : configurationsArray) {
                JSONObject configurationObject = (JSONObject) configurationRawObject;
                TestScenarioRun test = getTestScenarioRun(configurationObject);
                testScenarios.add(test);
            }

        } catch (IOException | ParseException e) {
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
    private TestScenarioRun getTestScenarioRun(JSONObject configurationObject) throws ClassCastException {
        // Function name to test
        String function = (String) configurationObject.get("function");

        // Test name
        String testName = (String) configurationObject.get("testName");

        // Function Parameters
        ArrayList<ParameterScenario> parameterScenarios = new ArrayList<>();
        JSONArray paramsArray = (JSONArray)configurationObject.get("parameters");

        ValueTypeFactory typeFactory = new ValueTypeFactory();
        ParametersFactory parametersFactory = new ParametersFactory();

        for (Object paramRawObject : paramsArray) {

            JSONObject paramObject = (JSONObject) paramRawObject;
            Object value = paramObject.get("value");
            String name = (String) paramObject.get("name");
            String type = (String) paramObject.get("type");

            // value type
            ValueType valueType = typeFactory.createValueType(type, value);

            // parameter function and scenario
            ParameterFunction parameterFunction = parametersFactory.createParameterFunction(type, name);
            ParameterScenario parameterScenario = parametersFactory.createParameterScenario(parameterFunction, valueType);
            parameterScenarios.add(parameterScenario);
        }

        // Expected result
        String expected = (String) configurationObject.get("expected");

        return new TestScenarioRun(function, testName, parameterScenarios, expected);
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
    public ArrayList<TestScenario> getTestScenarios(ArrayList<TestScenarioRun> testScenarioRuns,
                                                    ArrayList<TestableUnit> testableUnits){
        ArrayList<TestScenario> testScenarios = new ArrayList<>();
        TestableFactory testsFactory = new TestableFactory();
        ValueTypeFactory valueTypeFactory = new ValueTypeFactory();
        ExpectedResultsFactory expectedResultsFactory = new ExpectedResultsFactory();

        for (TestScenarioRun testScenarioRun : testScenarioRuns){
            // test name
            String testName = testScenarioRun.getTestName();

            // testable unit
            TestableUnit testableUnit = getTestableUnit(testScenarioRun.getFunction(), testableUnits);

            if (testableUnit != null){
                // value type
                ValueType valueType = valueTypeFactory.createValueType(testableUnit.getFunction().getReturn().getName(), testScenarioRun.getExpected());

                // expected result
                ExpectedResult expectedResult = expectedResultsFactory.createExpectedResult(valueType);

                // test scenario
                TestScenario testScenario = testsFactory.createTestScenario(testName, testableUnit, testScenarioRun.getParameters(), expectedResult);
                testScenarios.add(testScenario);
            }
        }

        return testScenarios;
    }

    /**
     * Receive a function name with the testable units and
     * search for the testable unit in the list
     *
     * @param functionName
     * @param testableUnits
     * @return a testable unit
     */
    private TestableUnit getTestableUnit(String functionName, ArrayList<TestableUnit> testableUnits) {
        for (TestableUnit testableUnit : testableUnits) {
            if (testableUnit.getFunction().getName().equals((functionName))){
                return testableUnit;
            }
        }
        return null;
    }


}
