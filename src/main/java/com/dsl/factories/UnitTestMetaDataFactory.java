package com.dsl.factories;

import org.json.simple.JSONArray;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.valuetypes.ValueType;

public class UnitTestMetaDataFactory {

	public static UnitTestMetaData createUnitTestMetaData(String classPath, String language, String outputPath, 
			String function, String testName, JSONArray parameters, ValueType expected, String assertion) {
		return new UnitTestMetaData(classPath, language, outputPath, 
				function, testName, parameters, expected, assertion);
	}
	
}
