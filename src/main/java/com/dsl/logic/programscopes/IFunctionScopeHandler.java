package com.dsl.logic.programscopes;

import com.dsl.models.unittests.UnitTest;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.FunctionDefintion;

public interface IFunctionScopeHandler {

	FunctionDefintion processFunctionDefinition(UnitTest unitTest);
}
