package processor.unittests;

import factories.UnitTestFactory;
import models.entities.aggregates.Function;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.Declaration;
import models.entities.unittests.FunctionArgument;
import models.entities.unittests.acts.*;
import models.entities.unittests.TestScenario;
import java.util.ArrayList;

import static utils.Constants.ACT_RESULT_NAME;
import static utils.Constants.SYSTEM_UNDER_TEST;

public class UnitTestActionHandler implements IUnitTestActionHandler {

    @Override
    public Act processUnitTestAct(TestScenario testScenario) {
        Act action;

        boolean isStaticFunction = testScenario.getTestableUnit().getFunction().isStatic();
        if (isStaticFunction){
            action = getStaticAct(testScenario);
        } else {
            action = getInstanceAct(testScenario);
        }

        return action;
    }

    /**
     *
     * @param testScenario
     * @return
     */
    private StaticAct getStaticAct(TestScenario testScenario){
        Function function = testScenario.getTestableUnit().getFunction();

        String calledFunction = function.getFileClass().getName();

        ActExecution actExecution = getActExecution(testScenario, calledFunction);

        return (StaticAct) UnitTestFactory.createStaticAct(actExecution);
    }

    /**
     *
     * @param testScenario
     * @return
     */
    private InstanceAct getInstanceAct(TestScenario testScenario){
        String sutType = testScenario.getTestableUnit().getFunction().getFileClass().getName();
        String sutName = SYSTEM_UNDER_TEST;

        ActNewType actNewType = UnitTestFactory.createActNewType(sutType, sutName);

        ActExecution actExecution = getActExecution(testScenario, sutName);

        return (InstanceAct) UnitTestFactory.createInstaceAct(actNewType, actExecution);
    }

    /**
     *
     * @param testScenario
     * @param calledFunction
     * @return
     */
    private ActExecution getActExecution(TestScenario testScenario, String calledFunction){
        Declaration declaration = getActExecutionDeclaration(testScenario);

        Function function = testScenario.getTestableUnit().getFunction();

        String functionName = function.getName();

        ArrayList<FunctionArgument> functionArguments = getActExecutionArguments(testScenario.getParameters());

        return UnitTestFactory.createActExecution(declaration, calledFunction, functionName, functionArguments);
    }

    /**
     *
     * @param testScenario
     * @return
     */
    private Declaration getActExecutionDeclaration(TestScenario testScenario){
        Function function = testScenario.getTestableUnit().getFunction();

        String type = function.getReturn().getName();

        return UnitTestFactory.createDeclaration(type, ACT_RESULT_NAME);
    }

    /**
     *
     * @param parameterScenarios
     * @return
     */
    private ArrayList<FunctionArgument> getActExecutionArguments(ArrayList<ParameterScenario> parameterScenarios){
        ArrayList<FunctionArgument> functionArguments = new ArrayList<>();

        for (ParameterScenario ps : parameterScenarios){
            String value = ps.getParameterFunction().getName();
            FunctionArgument functionArg = UnitTestFactory.createFunctionArgument(value);
            functionArguments.add(functionArg);
        }

        return functionArguments;
    }

}
