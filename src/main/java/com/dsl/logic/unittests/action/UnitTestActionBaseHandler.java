package com.dsl.logic.unittests.action;

import java.util.ArrayList;

import static com.dsl.utils.Constants.ACT_RESULT_NAME;

import com.dsl.factories.UnitTestFactory;
import com.dsl.models.aggregates.Function;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.acts.ActExecution;


public abstract class UnitTestActionBaseHandler {
	
	public abstract Act processUnitTestAct(TestScenario testScenario);
	
	
    protected ActExecution getActExecution(TestScenario testScenario, String calledFunction){
        Declaration declaration = getActExecutionDeclaration(testScenario);
        Function function = testScenario.getFunction();
        String functionName = function.getName();
        ArrayList<FunctionArgument> functionArguments = getActExecutionArguments(testScenario.getParameters());

        return UnitTestFactory.createActExecution(declaration, calledFunction, functionName, functionArguments);
    }
    
    
    private Declaration getActExecutionDeclaration(TestScenario testScenario){
        Function function = testScenario.getFunction();
        String type = function.getReturn().getName();

        return UnitTestFactory.createDeclaration(type, ACT_RESULT_NAME);
    }

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
