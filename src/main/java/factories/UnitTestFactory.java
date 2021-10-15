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

public class UnitTestFactory implements IUnitTestFactory {

    @Override
    public Declaration createDeclaration(String type, String name){
        return new Declaration(type, name);
    }

    @Override
    public FunctionArgument createFunctionArgument(String value){
        return new FunctionArgument(value);
    }

    @Override
    public ActNewType createActNewType(String type, String name){
        return new ActNewType(type, name);
    }


    @Override
    public ArrangeDefinition createArrangeStatementDefinition(ValueType valueType){
        return new ArrangeDefinition(valueType);
    }

    @Override
    public ArrangeStatement createArrangeStatement(Declaration declaration, ArrangeDefinition definition) {
        return new ArrangeStatement(declaration, definition);
    }

    @Override
    public Arrange createArrange(ArrayList<ArrangeStatement> arrangeStatements){
        return new Arrange(arrangeStatements);
    }


    @Override
    public Act createStaticAct(ActExecution actExecution){
        return new StaticAct(actExecution);
    }

    @Override
    public Act createInstaceAct(ActNewType actNewType, ActExecution actExecution){
        return new InstanceAct(actNewType, actExecution);
    }

    @Override
    public ActExecution createActExecution(Declaration declaration, String calledFunction, String functionName, ArrayList<FunctionArgument> functionArguments){
        return new ActExecution(declaration, calledFunction, functionName, functionArguments);
    }


    @Override
    public AssertExpression createAssertExpression(String calledFunction, AssertType assertType, ArrayList<FunctionArgument> assertParameters){
        return new AssertExpression(calledFunction, assertType, assertParameters);
    }

    @Override
    public Assert createAssert(ArrayList<AssertExpression> assertExpressions){
        return new Assert(assertExpressions);
    }

    @Override
    public UnitTest createUnitTest(TestScenario testScenario, Arrange arrange, Act act, Assert inAssert){
        return new UnitTest(testScenario, arrange, act, inAssert);
    }

}
