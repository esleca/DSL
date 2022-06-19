package com.dsl.logic.programscopes.action;

import org.springframework.stereotype.Component;

import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;


@Component
public class FunctionActionHandler implements IFunctionActionHandler {

	private IFunctionActionInstantiator actionInstantiator;
	private IFunctionActionExecuter actionExecuter;
	
	public FunctionActionHandler(IFunctionActionInstantiator inActionInstantiator, IFunctionActionExecuter inActionExecuter) {
		this.actionInstantiator = inActionInstantiator;
		this.actionExecuter = inActionExecuter;
	}
	

	@Override
	public DeclarationOrDefinitionStatement getDeclOrDefStatementNewType(ActNewType actNewType) {
		DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
        VariableDefinition variableDefinitionExec = actionInstantiator.getActNewTypeVariableDefinition(actNewType);
        decOrDefStatement.setDeclOrDefn(variableDefinitionExec);
        return decOrDefStatement;
	}
	
	@Override
	public DeclarationOrDefinitionStatement getDeclOrDefStatementExec(ActExecution actExecution) {
		DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
        VariableDefinition variableDefinitionExec = actionExecuter.getActExecutionVariableDefinition(actExecution);
        decOrDefStatement.setDeclOrDefn(variableDefinitionExec);
        return decOrDefStatement;
	}

}
