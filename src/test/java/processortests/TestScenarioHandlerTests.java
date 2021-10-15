package processortests;

import exceptions.*;
import factories.*;
import models.entities.unittests.TestScenario;
import models.entities.unittests.TestableUnit;
import processor.testscenarios.ITestScenarioHandler;
import processor.testscenarios.TestScenarioHandler;
import testrun.DataTestHelper;
import testrun.config.TestScenarioRun;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestScenarioHandlerTests {

    private static TestableUnitFactory testableFactory = new TestableUnitFactory();
    private static ValueTypeFactory valueTypeFactory = new ValueTypeFactory();
    private static ExpectedResultsFactory expectedResFactory = new ExpectedResultsFactory();
    private static AssertsFactory assertsFactory = new AssertsFactory();
    private static ParametersFactory parametersFactory = new ParametersFactory();

    @BeforeEach
    public void initialize() {
        System.out.println("Before tests");
    }

    @BeforeAll
    public static void init(){
        System.out.println("Before all tests");

        testableFactory = new TestableUnitFactory();
        valueTypeFactory = new ValueTypeFactory();
        expectedResFactory = new ExpectedResultsFactory();
        assertsFactory = new AssertsFactory();
        parametersFactory = new ParametersFactory();
    }

    @Test
    public void TestScenario_Test1() throws ValueTypeNotFoundException, AssertNotFoundException {
        // Arrange
        ArrayList<TestScenarioRun> testScenarioRuns = new ArrayList<>();
        testScenarioRuns.add(DataTestHelper.getTestScenarioRun());

        ArrayList<TestableUnit> testableUnits = new ArrayList<>();
        testableUnits.add(DataTestHelper.getTestableUnit());

        // Act
        ITestScenarioHandler testScenarioHandler = new TestScenarioHandler(testableFactory, valueTypeFactory,
                expectedResFactory, assertsFactory, parametersFactory);

        ArrayList<TestScenario> testScenarios = testScenarioHandler.processTestScenarios(testScenarioRuns, testableUnits);

        int actualSize = testScenarios.size();

        // Asserts
        assertEquals(1, actualSize);
    }

    @Test
    public void TestScenario_Test2() {
        // Arrange

        // Act

        // Asserts
        assertEquals(1, 1);
    }
}
