package processor;

import factories.UnitTestFactory;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.*;

import java.util.ArrayList;


public class ProcessorHandlerUnitTester implements IProcessorHandlerUnitTester{

    private UnitTestFactory unitTestFactory;

    /**
     * Constructor
     */
    public ProcessorHandlerUnitTester(){
        unitTestFactory = new UnitTestFactory();
    }

    /**
     *
     * @param testScenarios
     * @return
     */
    public ArrayList<UnitTest> getUnitTests(ArrayList<TestScenario> testScenarios){
        ArrayList<UnitTest> unitTests = new ArrayList<>();

        for (TestScenario testScenario : testScenarios){
            // AAA
            Arrange arrange = getArrange(testScenario);
            Act act = getAct(testScenario, arrange);
            Assert lAssert = getAssert(testScenario);

            // unit test
            UnitTest unitTest = unitTestFactory.createUnitTest(testScenario, arrange, act, lAssert);
            unitTests.add(unitTest);
        }

        return unitTests;
    }


    /**
     *
     * @param testScenario
     * @return
     */
    private Arrange getArrange(TestScenario testScenario) throws ClassCastException{
        ArrayList<ArrangeStatement> arranges = new ArrayList<>();
        ArrayList<ParameterScenario> parameterScenarios = testScenario.getParameters();

        for (ParameterScenario parameterScenario : parameterScenarios){
            // Declaration
            String type = parameterScenario.getParameterFunction().getType();
            String name = parameterScenario.getParameterFunction().getName();
            Declaration declaration = unitTestFactory.createArrangeStatementDeclaration(type, name);

            // Definition
            Definition definition = unitTestFactory.createArrangeStatementDefinition(parameterScenario.getValueType());

            // Arrange Statement
            ArrangeStatement arrangeStatement = unitTestFactory.createArrangeStatement(declaration, definition);
            arranges.add(arrangeStatement);
        }

        return unitTestFactory.createArrange(arranges);
    }


    private Act getAct(TestScenario testScenario, Arrange arrange){

        return null;

    }


    /**
     *
     * @param testScenario
     * @return
     */
    private Assert getAssert(TestScenario testScenario){
        return null;
    }

}
