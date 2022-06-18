package com.dsl.logic.programscopes;

import org.springframework.stereotype.Component;

import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;


@Component
public class FunctionActionHandler implements IFunctionActionHandler {

	private IFunctionActionExecuter actionExecuter;
	private IFunctionActionInstantiator actionInstantiator;
	
	public FunctionActionHandler(IFunctionActionExecuter inActionExecuter, IFunctionActionInstantiator inActionInstantiator) {
		this.actionExecuter = inActionExecuter;
		this.actionInstantiator = inActionInstantiator;
	}
	
	
	@Override
	public DeclarationOrDefinitionStatement getDeclOrDefStatementExec(ActExecution actExecution) {
		DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
        VariableDefinition variableDefinitionExec = actionExecuter.getActExecutionVariableDefinition(actExecution);
        decOrDefStatement.setDeclOrDefn(variableDefinitionExec);
        return decOrDefStatement;
	}

	@Override
	public DeclarationOrDefinitionStatement getDeclOrDefStatementNewType(ActNewType actNewType) {
		DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
        VariableDefinition variableDefinitionExec = actionInstantiator.getActNewTypeVariableDefinition(actNewType);
        decOrDefStatement.setDeclOrDefn(variableDefinitionExec);
        return decOrDefStatement;
	}
}
