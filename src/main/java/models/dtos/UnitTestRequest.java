package models.dtos;

public class UnitTestRequest {

    private String path;
    private String language;
    private String function;
    private TestScenarioRequest testScenario;



    public UnitTestRequest(String path, String language, TestScenarioRequest testScenario) {
        this.path = path;
        this.language = language;
        this.function = "";
        this.testScenario = testScenario;
    }

    public String getPath() {
        return path;
    }

    public String getLanguage() {
        return language;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public TestScenarioRequest getTestScenario() {
        return testScenario;
    }

    public void setTestScenario(TestScenarioRequest testScenario) {
        this.testScenario = testScenario;
    }

}
