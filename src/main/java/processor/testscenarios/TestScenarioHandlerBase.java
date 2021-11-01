package processor.testscenarios;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import testrun.config.TestScenarioRun;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static utils.Constants.RETURN_PARAMETERIZED;

public class TestScenarioHandlerBase implements ITestScenarioHandler {

    private final ITestScenarioRunHandler runHandler;
    private final ITestScenarioRunHandler runParamHandler;

    public TestScenarioHandlerBase(ITestScenarioRunHandler runHandler, ITestScenarioRunHandler runParamHandler){
        this.runHandler = runHandler;
        this.runParamHandler = runParamHandler;
    }


    @Override
    public ArrayList<TestScenarioRun> processTestScenariosRun(String scenariosPath) {
        ArrayList<TestScenarioRun> testScenarios = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(scenariosPath)) {
            JSONArray configurationsArray = (JSONArray) jsonParser.parse(reader);

            for (Object configurationRawObject : configurationsArray) {
                TestScenarioRun test = getTestScenarioRun(configurationRawObject);
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


    protected TestScenarioRun getTestScenarioRun(Object configurationRawObject) throws ValueTypeNotFoundException {
        TestScenarioRun testScenarioRun;
        JSONObject configurationObject = (JSONObject) configurationRawObject;
        Object expected = configurationObject.get("expected");

        if (expected instanceof JSONArray){
            testScenarioRun = runParamHandler.getTestScenarioRun(configurationObject);
        }else{
            testScenarioRun = runHandler.getTestScenarioRun(configurationObject);
        }

        return testScenarioRun;
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

        TestScenario testScenario;
        String returnType = testableUnit.getFunction().getReturn().getName();

        if (returnType.equals(RETURN_PARAMETERIZED)){
            testScenario = runParamHandler.getTestScenario(testScenarioRun, testableUnit);
        }else{
            testScenario = runHandler.getTestScenario(testScenarioRun, testableUnit);
        }

        return testScenario;
    }

}
