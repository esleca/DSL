package com.dsl.logic.programscopes;

import com.dsl.models.unittests.acts.ActExecution;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;

public interface IFunctionActionExecuter {

	VariableDefinition getActExecutionVariableDefinition(ActExecution actExecution);
}
