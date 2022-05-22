package com.dsl.logic.programscopes;

import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;

import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;

public interface IFunctionActionHandler {

	DeclarationOrDefinitionStatement getDeclOrDefStatementExec(ActExecution actExecution);
	
	DeclarationOrDefinitionStatement getDeclOrDefStatementNewType(ActNewType actNewType);
}
