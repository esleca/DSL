package com.dsl.models.dtos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UnitTestRequest {

    private String classPath; // required by mapper
    private String language;  // required by mapper
    private String outputPath; // required by printer
	private String function;
    private String testName;
    private JSONArray parameters;
    private JSONObject expected;
    private String assertion;

    public UnitTestRequest(String classPath, String outputPath, String language, String function, String testName,
                           JSONArray parameters, JSONObject expected, String assertion) {
        this.classPath = classPath;
        this.outputPath = outputPath;
        this.language = language;
        this.function = function;
        this.testName = testName;
        this.parameters = parameters;
        this.expected = expected;
        this.assertion = assertion;
    }

    public String getClassPath() {
        return classPath;
    }

	public String getOutputPath() {
		return outputPath;
	}

    public String getLanguage() {
        return language;
    }

    public String getFunction() {
        return function;
    }

    public String getTestName(){
        return testName;
    }

    public JSONArray getParameters() {
        return parameters;
    }

    public JSONObject getExpected() {
        return expected;
    }

    public String getAssert() {
        return assertion;
    }
}
