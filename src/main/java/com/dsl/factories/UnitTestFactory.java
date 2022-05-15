package com.dsl.factories;

import com.dsl.models.unittests.*;
import com.dsl.models.unittests.acts.*;
import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.arranges.ArrangeStatement;
import com.dsl.models.unittests.arranges.ArrangeDefinition;
import com.dsl.models.unittests.asserts.Assert;
import com.dsl.models.unittests.asserts.AssertExpression;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.valuetypes.ValueType;

import java.util.ArrayList;

public class UnitTestFactory {

    public static Declaration createDeclaration(String type, String name){
        return new Declaration(type, name);
    }

    public static FunctionArgument createFunctionArgument(String value){
        return new FunctionArgument(value);
    }

    public static ActNewType createActNewType(String type, String name){
        return new ActNewType(type, name);
    }


    public static ArrangeDefinition createArrangeStatementDefinition(ValueType valueType){
        return new ArrangeDefinition(valueType);
    }

    public static ArrangeStatement createArrangeStatement(Declaration declaration, ArrangeDefinition definition) {
        return new ArrangeStatement(declaration, definition);
    }

    public static Arrange createArrange(ArrayList<ArrangeStatement> arrangeStatements){
        return new Arrange(arrangeStatements);
    }


    public static Act createStaticAct(ActExecution actExecution){
        return new StaticAct(actExecution);
    }

    public static Act createInstaceAct(ActNewType actNewType, ActExecution actExecution){
        return new InstanceAct(actNewType, actExecution);
    }

    public static ActExecution createActExecution(Declaration declaration, String calledFunction, String functionName, ArrayList<FunctionArgument> functionArguments){
        return new ActExecution(declaration, calledFunction, functionName, functionArguments);
    }


    public static AssertExpression createAssertExpression(String calledFunction, AssertType assertType, ArrayList<FunctionArgument> assertParameters){
        return new AssertExpression(calledFunction, assertType, assertParameters);
    }

    public static Assert createAssert(ArrayList<AssertExpression> assertExpressions){
        return new Assert(assertExpressions);
    }

    public static UnitTest createUnitTest(String language, TestScenario testScenario, Arrange arrange, Act act, Assert inAssert){
        return new UnitTest(language, testScenario, arrange, act, inAssert);
    }

}
