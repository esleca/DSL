package factories;

import models.entities.unittests.*;
import models.entities.unittests.acts.*;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.arranges.ArrangeDefinition;

import models.entities.unittests.asserts.Assert;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.unittests.asserts.types.AssertType;

import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class UnitTestFactory {

    public Declaration createDeclaration(String type, String name){
        return new Declaration(type, name);
    }

    public FunctionArgument createFunctionArgument(String value){
        return new FunctionArgument(value);
    }

    public ActNewType createActNewType(String type, String name){
        return new ActNewType(type, name);
    }


    // Arranges
    public ArrangeDefinition createArrangeStatementDefinition(ValueType valueType){
        return new ArrangeDefinition(valueType);
    }

    public ArrangeStatement createArrangeStatement(Declaration declaration, ArrangeDefinition definition) {
        return new ArrangeStatement(declaration, definition);
    }

    public Arrange createArrange(ArrayList<ArrangeStatement> arrangeStatements){
        return new Arrange(arrangeStatements);
    }


    //Acts
    public Act createStaticAct(ActExecution actExecution){
        return new StaticAct(actExecution);
    }

    public Act createInstaceAct(ActNewType actNewType, ActExecution actExecution){
        return new InstanceAct(actNewType, actExecution);
    }

    public ActExecution createActExecution(Declaration declaration, String calledFunction, String functionName, ArrayList<FunctionArgument> functionArguments){
        return new ActExecution(declaration, calledFunction, functionName, functionArguments);
    }


    // Asserts
    public AssertExpression createAssertExpression(String calledFunction, AssertType assertType, ArrayList<FunctionArgument> assertParameters){
        return new AssertExpression(calledFunction, assertType, assertParameters);
    }

    public Assert createAssert(ArrayList<AssertExpression> assertExpressions){
        return new Assert(assertExpressions);
    }

    public UnitTest createUnitTest(TestScenario testScenario, Arrange arrange, Act act, Assert inAssert){
        return new UnitTest(testScenario, arrange, act, inAssert);
    }

}
