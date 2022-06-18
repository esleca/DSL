package com.dsl.logic.programscopes;

import com.dsl.models.unittests.acts.ActNewType;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;

public interface IFunctionActionInstantiator {
	
	VariableDefinition getActNewTypeVariableDefinition(ActNewType actNewType);
}
