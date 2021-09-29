package models.entities.unittests;

import models.entities.unittests.acts.Act;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.asserts.Assert;

public class UnitTest {

    private TestScenario testScenario;

    private Arrange arrange;
    private Act act;
    private Assert assertion;

    public UnitTest(TestScenario testScenario, Arrange arrange, Act act, Assert assertion) {
        this.testScenario = testScenario;
        this.arrange = arrange;
        this.act = act;
        this.assertion = assertion;
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
