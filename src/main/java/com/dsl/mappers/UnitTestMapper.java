package com.dsl.mappers;

import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.parameters.ParameterScenario;
import org.json.simple.JSONArray;
import com.dsl.models.unittests.UnitTest;
import com.dsl.models.dtos.UnitTestResponse;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.valuetypes.ValueType;

import java.util.ArrayList;

public class UnitTestMapper {
	
	public static UnitTestRequest convertUnitTestRequest(UnitTestMetaData metaData) {
		String classPath = metaData.getClassPath();
	    String language = metaData.getLanguage();
	    String outputPath = metaData.getOutputPath();
		String function = metaData.getFunction();
	    String testName = metaData.getTestName();
	    JSONArray parameters = metaData.getParameters();
	    ValueType expected = metaData.getExpected();
	    String assertion = metaData.getAssertion();
	    
		return new UnitTestRequest(classPath, language, outputPath, function, testName, parameters, expected, assertion);
	}

	public static UnitTestResponse convertUnitTestResponse(UnitTest unitTest){
		String language = unitTest.getLanguage();
		String packageName = unitTest.getTestScenario().getFunction().getFileClass().getPackage().getName();
		String className = unitTest.getTestScenario().getFunction().getFileClass().getName();
		String functionName = unitTest.getTestScenario().getFunction().getName();
		String testName = unitTest.getTestScenario().getTestName();
		String assertion = unitTest.getTestScenario().getAssertion();
		ArrayList<ParameterFunction> parameters = unitTest.getTestScenario().getFunction().getParameters();
		ArrayList<ParameterScenario> paramScenario = unitTest.getTestScenario().getParameters();
		ArrayList<Object> paramValues = new ArrayList<>();
		for(int i = 0; i < paramScenario.size(); i++){
			paramValues.add(paramScenario.get(i).getValueType().getValue().toString());
		}
		String expectedType = unitTest.getTestScenario().getExpectedResult().getValueType().getType();
		Object expectedValue = unitTest.getTestScenario().getExpectedResult().getValueType().getValue();
		return new UnitTestResponse(language, packageName, className, functionName, testName, assertion, parameters, expectedType, expectedValue, paramValues);
	}
}
