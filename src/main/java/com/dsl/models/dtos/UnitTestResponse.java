package com.dsl.models.dtos;

import com.dsl.models.unittests.arranges.Arrange;

public class UnitTestResponse {

    private String language;
    private String packageName;
    private String className;
    private String functionName;
    private String testName;
    private Arrange arrange;
    private String assertion;

    public UnitTestResponse(String language, String packageName, String className, String functionName, String testName, Arrange arrange, String assertion){
        this.language = language;
        this.packageName = packageName;
        this.className = className;
        this.functionName = functionName;
        this.testName = testName;
        this.arrange = arrange;
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

    public Arrange getArrange() {
        return arrange;
    }

    public String getAssertion() {
        return assertion;
    }
}
