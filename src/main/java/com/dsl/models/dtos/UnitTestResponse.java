package com.dsl.models.dtos;

import com.dsl.models.parameters.ParameterFunction;

import java.util.ArrayList;

public class UnitTestResponse {

    private String language;
    private String packageName;
    private String className;
    private String functionName;
    private String testName;
    private String assertion;
    private ArrayList<ParameterFunction> parameters;
    private String expectedType;
    private Object expectedValue;
    private ArrayList<Object> paramValues;

    public UnitTestResponse(String language, String packageName, String className, String functionName, String testName, String assertion, ArrayList<ParameterFunction> parameters, String expectedType, Object expectedValue, ArrayList<Object> paramValues){
        this.language = language;
        this.packageName = packageName;
        this.className = className;
        this.functionName = functionName;
        this.testName = testName;
        this.assertion = assertion;
        this.parameters = parameters;
        this.expectedType = expectedType;
        this.expectedValue = expectedValue;
        this.paramValues = paramValues;
    }

    public String getLanguage() {
        return language;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getTestName() {
        return testName;
    }

    public String getAssertion() {
        return assertion;
    }
    public ArrayList<ParameterFunction> getParameters() {
        return parameters;
    }
    public String getExpectedType() {
        return expectedType;
    }
    public Object getExpectedValue() {
        return expectedValue;
    }

    public ArrayList<Object> getParamValues() {
        return paramValues;
    }
}
