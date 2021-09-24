package factories;

import models.entities.unittests.*;
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

    public UnitTest createUnitTest(TestScenario testScenario, Arrange arrange, Act act, Assert inAssert){
        UnitTest unitTest = new UnitTest(testScenario, arrange, act, inAssert);
        return unitTest;
    }

}
