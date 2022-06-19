package com.dsl.logic.programscopes.body;

import com.dsl.models.unittests.UnitTest;
import ASTMCore.ASTMSyntax.Statement.Statement;

public interface IFunctionBodyHandler {
	
	Statement processFunctionBody(UnitTest unitTest);
}
