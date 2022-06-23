package com.dsl.logic.programscopes.action;

import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;

import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;

public interface IFunctionActionHandler {

	DeclarationOrDefinitionStatement getDeclOrDefStatementNewType(ActNewType actNewType);
	
	DeclarationOrDefinitionStatement getDeclOrDefStatementExecution(ActExecution actExecution);
	
}
