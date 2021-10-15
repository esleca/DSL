package factories;

import models.entities.unittests.Declaration;
import models.entities.unittests.FunctionArgument;
import models.entities.unittests.TestScenario;
import models.entities.unittests.UnitTest;
import models.entities.unittests.acts.*;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.arranges.ArrangeDefinition;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.asserts.Assert;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.unittests.asserts.types.AssertType;
import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public interface IUnitTestFactory {

    Declaration createDeclaration(String type, String name);

    FunctionArgument createFunctionArgument(String value);


    ArrangeDefinition createArrangeStatementDefinition(ValueType valueType);

    ArrangeStatement createArrangeStatement(Declaration declaration, ArrangeDefinition definition);

    Arrange createArrange(ArrayList<ArrangeStatement> arrangeStatements);


    ActNewType createActNewType(String type, String name);


    Act createStaticAct(ActExecution actExecution);

    Act createInstaceAct(ActNewType actNewType, ActExecution actExecution);

    ActExecution createActExecution(Declaration declaration, String calledFunction, String functionName, ArrayList<FunctionArgument> functionArguments);


    AssertExpression createAssertExpression(String calledFunction, AssertType assertType, ArrayList<FunctionArgument> assertParameters);

    Assert createAssert(ArrayList<AssertExpression> assertExpressions);


    UnitTest createUnitTest(TestScenario testScenario, Arrange arrange, Act act, Assert inAssert);

}
