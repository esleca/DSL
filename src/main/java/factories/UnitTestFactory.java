package factories;

import models.entities.unittests.*;
import models.entities.unittests.acts.Act;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.arranges.Declaration;
import models.entities.unittests.arranges.Definition;
import models.entities.unittests.asserts.Assert;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.unittests.asserts.AssertParameter;
import models.entities.unittests.asserts.types.AssertType;
import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class UnitTestFactory {

    public Declaration createArrangeStatementDeclaration(String type, String name){
        Declaration declaration = new Declaration(type, name);
        return declaration;
    }

    public Definition createArrangeStatementDefinition(ValueType valueType){
        Definition definition = new Definition(valueType);
        return definition;
    }

    public ArrangeStatement createArrangeStatement(Declaration declaration, Definition definition) {
        ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
        return arrangeStatement;
    }

    public Arrange createArrange(ArrayList<ArrangeStatement> arrangeStatements){
        Arrange arrange = new Arrange(arrangeStatements);
        return arrange;
    }



    public AssertExpression createAssertExpression(String calledFunction, AssertType assertType, ArrayList<AssertParameter> assertParameters){
        AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, assertParameters);
        return assertExpression;
    }

    public Assert createAssert(ArrayList<AssertExpression> assertExpressions){
        Assert lassert = new Assert(assertExpressions);
        return lassert;
    }



    public UnitTest createUnitTest(TestScenario testScenario, Arrange arrange, Act act, Assert inAssert){
        UnitTest unitTest = new UnitTest(testScenario, arrange, act, inAssert);
        return unitTest;
    }

}
