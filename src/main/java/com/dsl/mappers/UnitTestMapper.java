package com.dsl.mappers;

import org.json.simple.JSONArray;
import com.dsl.models.unittests.UnitTest;
import com.dsl.models.dtos.UnitTestResponse;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.valuetypes.ValueType;

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

		return new UnitTestResponse(language, packageName, className, functionName, testName, assertion);
	}
}
