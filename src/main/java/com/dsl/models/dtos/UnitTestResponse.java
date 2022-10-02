package com.dsl.models.dtos;

public class UnitTestResponse {

    private String language;
    private String packageName;
    private String className;
    private String functionName;
    private String testName;
    private String assertion;

    public UnitTestResponse(String language, String packageName, String className, String functionName, String testName, String assertion){
        this.language = language;
        this.packageName = packageName;
        this.className = className;
        this.functionName = functionName;
        this.testName = testName;
        this.assertion = assertion;
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
}
