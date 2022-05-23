package com.dsl.models.unittests;

import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.asserts.Assert;

public class UnitTest {

	private String language;
    private TestScenario testScenario;
    private Arrange arrange;
    private Act act;
    private Assert assertion;

    public UnitTest(String language, TestScenario testScenario, Arrange arrange, Act act, Assert assertion) {
        this.language = language;
    	this.testScenario = testScenario;
        this.arrange = arrange;
        this.act = act;
        this.assertion = assertion;
    }


    public String getLanguage() {
    	return language;
    }
    
    public TestScenario getTestScenario() {
        return testScenario;
    }

    public void setTestScenario(TestScenario testScenario) {
        this.testScenario = testScenario;
    }

    public Arrange getArrange() {
        return arrange;
    }

    public void setArrange(Arrange arrange) {
        this.arrange = arrange;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Assert getAssert() {
        return assertion;
    }

    public void setAssert(Assert assertion) {
        this.assertion = assertion;
    }
}