package com.dsl.logic.testscenarios;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.*;
import com.dsl.logic.expectedresults.*;
import com.dsl.logic.parameterscenarios.IParameterScenarioHandler;
import com.dsl.models.aggregates.Function;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.types.AssertType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.dsl.testrun.config.TestScenarioParameterizedRun;
import com.dsl.testrun.config.TestScenarioPrimitiveRun;
import com.dsl.testrun.config.TestScenarioRun;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TestScenarioFileHandler implements ITestScenarioFileHandler {

	protected final IParameterScenarioHandler _parameterScenarioHandler;
	protected final IExpectedPrimitiveHandler _expectedPrimitiveHandler;
    protected final IExpectedParameterizedHandler _expectedParameterizedHandler;

    public TestScenarioFileHandler(IParameterScenarioHandler paramScenarioHandler, IExpectedPrimitiveHandler expectedPrimitive, IExpectedParameterizedHandler expectedParameterized){
        this._parameterScenarioHandler = paramScenarioHandler;
    	this._expectedPrimitiveHandler = expectedPrimitive;
        this._expectedParameterizedHandler = expectedParameterized;
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
        ArrayList<ParameterScenario> parameterScenarios = _parameterScenarioHandler.getParameterScenarios(paramsArray);

        TestScenarioRun testScenarioRun;
        Object expected = jsonObject.get("expected");

        if (expected instanceof JSONArray){
            TestScenarioParameterizedRun paramRun = new TestScenarioParameterizedRun(function, testName, parameterScenarios, assertion);
            paramRun.setExpected(_expectedParameterizedHandler.getExpected(jsonObject));
            testScenarioRun = paramRun;
        }else{
            TestScenarioPrimitiveRun primRun = new TestScenarioPrimitiveRun(function, testName, parameterScenarios, assertion);
            primRun.setExpected(_expectedPrimitiveHandler.getExpected(jsonObject));
            testScenarioRun = primRun;
        }

        return testScenarioRun;
    }

    protected TestScenario getTestScenario(TestScenarioRun testScenarioRun, Function function) throws AssertNotFoundException {
    	String initialAssert = testScenarioRun.getAssertion();
    	AssertType assertType = AssertTypesFactory.createAssertType(testScenarioRun.getAssertion(), function.getFileClass().getLanguage());
        ExpectedResult expectedResult;

        if (testScenarioRun instanceof TestScenarioParameterizedRun){
            TestScenarioParameterizedRun parameterizedRun = (TestScenarioParameterizedRun) testScenarioRun;
            expectedResult = ExpectedResultsFactory.createParameterizedExpectedResult(parameterizedRun.getExpected());
        }else{
            TestScenarioPrimitiveRun primitiveRun = (TestScenarioPrimitiveRun) testScenarioRun;
            expectedResult = ExpectedResultsFactory.createPrimitiveExpectedResult(primitiveRun.getExpected());
        }

        return TestableUnitFactory.createTestScenario(testScenarioRun.getTestName(), function, testScenarioRun.getParameters(), expectedResult, initialAssert, assertType);
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
