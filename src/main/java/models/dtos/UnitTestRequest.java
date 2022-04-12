package models.dtos;

import org.json.simple.JSONArray;

public class UnitTestRequest {

    private String classPath; // required by mapper
    private String language;  // required by mapper
    private String function;
    private String testName;
    private JSONArray parameters;
    private String expected;
    private String assertion;

    public UnitTestRequest(String classPath, String language, String function, String testName,
                           JSONArray parameters, String expected, String assertion) {
        this.classPath = classPath;
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

    public String getExpected() {
        return expected;
    }

    public String getAssert() {
        return assertion;
    }
}
