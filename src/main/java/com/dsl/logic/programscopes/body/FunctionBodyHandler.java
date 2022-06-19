package com.dsl.logic.programscopes.body;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.logic.programscopes.action.IFunctionActionHandler;
import com.dsl.logic.programscopes.arrange.IFunctionArrangeHandler;
import com.dsl.logic.programscopes.asserts.IFunctionAssertHandler;
import com.dsl.models.unittests.UnitTest;
import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;
import com.dsl.models.unittests.acts.InstanceAct;
import com.dsl.models.unittests.acts.StaticAct;
import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.arranges.ArrangeStatement;
import com.dsl.models.unittests.asserts.Assert;
import com.dsl.models.unittests.asserts.AssertExpression;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Statement.BlockStatement;
import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;
import ASTMCore.ASTMSyntax.Statement.ExpressionStatement;
import ASTMCore.ASTMSyntax.Statement.Statement;


@Component
public class FunctionBodyHandler implements IFunctionBodyHandler {
	
	private IFunctionArrangeHandler arrangeHandler;
	private IFunctionActionHandler actionHandler;
	private IFunctionAssertHandler assertHandler;
	
	public FunctionBodyHandler(IFunctionArrangeHandler functionArrangeHandler, IFunctionActionHandler functionActionHandler, IFunctionAssertHandler functionAssertHandler) {
		this.arrangeHandler = functionArrangeHandler;
		this.actionHandler = functionActionHandler;
		this.assertHandler = functionAssertHandler;
	}
	
	
	@Override
	public Statement processFunctionBody(UnitTest unitTest){
        BlockStatement blockStatement = new BlockStatement();
        ArrayList<Statement> subStatements = new ArrayList<>();

        processFunctionArrange(subStatements, unitTest);
        processFunctionAction(subStatements, unitTest);
        processFunctionAssert(subStatements, unitTest);
        
        blockStatement.setSubStatements(subStatements);
        
        return blockStatement;
    }
	
	private void processFunctionArrange(ArrayList<Statement> subStatements, UnitTest unitTest) {
    	Arrange arrange = unitTest.getArrange();
    	
    	for (ArrangeStatement as : arrange.getArrangeStatements()) {
            DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
            VariableDefinition variableDefinition = arrangeHandler.getArrangeVariableDefinition(as);
            decOrDefStatement.setDeclOrDefn(variableDefinition);
            subStatements.add(decOrDefStatement);
        }
    }
    
    private void processFunctionAction(ArrayList<Statement> subStatements, UnitTest unitTest) {
    	Act act = unitTest.getAct();

        if (act instanceof InstanceAct){
            InstanceAct action = (InstanceAct) act;
            ActNewType actNewType = action.getActNewType();
            ActExecution actExecution = action.getActExecution();

            DeclarationOrDefinitionStatement decOrDefStatementNew = actionHandler.getDeclOrDefStatementNewType(actNewType);
            DeclarationOrDefinitionStatement decOrDefStatement = actionHandler.getDeclOrDefStatementExec(actExecution);

            subStatements.add(decOrDefStatementNew);
            subStatements.add(decOrDefStatement);
            
        } else if (act instanceof StaticAct){
            StaticAct action = (StaticAct) act;
            ActExecution actExecution = action.getActExecution();
            
            DeclarationOrDefinitionStatement decOrDefStatement = actionHandler.getDeclOrDefStatementExec(actExecution);
            
            subStatements.add(decOrDefStatement);
        }
    }
    
    private void processFunctionAssert(ArrayList<Statement> subStatements, UnitTest unitTest) {
    	Assert anAssert = unitTest.getAssert();
        
        for (AssertExpression ae : anAssert.getAssertExpressions()) {
            ExpressionStatement expressionStatement = new ExpressionStatement();
            Expression expression = assertHandler.getAssertExpression(ae);
            expressionStatement.setExpression(expression);
            subStatements.add(expressionStatement);
        }
    }
}
