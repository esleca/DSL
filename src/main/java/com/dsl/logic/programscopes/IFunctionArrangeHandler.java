package com.dsl.logic.programscopes;

import com.dsl.models.unittests.arranges.ArrangeStatement;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;

public interface IFunctionArrangeHandler {

	VariableDefinition getArrangeVariableDefinition(ArrangeStatement arrangeStatement);
}
