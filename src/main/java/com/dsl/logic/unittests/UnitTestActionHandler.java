package com.dsl.logic.unittests;

import com.dsl.factories.UnitTestFactory;
import com.dsl.models.aggregates.Function;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.acts.*;
import com.dsl.models.unittests.TestScenario;
import java.util.ArrayList;

import static com.dsl.utils.Constants.ACT_RESULT_NAME;
import static com.dsl.utils.Constants.SYSTEM_UNDER_TEST;

import org.springframework.stereotype.Component;

@Component
public class UnitTestActionHandler implements IUnitTestActionHandler {

    @Override
    public Act processUnitTestAct(TestScenario testScenario) {
        Act action;

        boolean isStaticFunction = testScenario.getFunction().isStatic();
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
        Function function = testScenario.getFunction();

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
        String sutType = testScenario.getFunction().getFileClass().getName();
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

        Function function = testScenario.getFunction();

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
        Function function = testScenario.getFunction();

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
