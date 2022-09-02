package com.dsl.mappers;

import org.json.simple.JSONArray;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.valuetypes.ValueType;

public class UnitTestMapper {
	
	public static UnitTestRequest convertUnitTest(UnitTestMetaData metaData) {
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
}
