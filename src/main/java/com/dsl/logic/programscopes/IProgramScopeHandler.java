package com.dsl.logic.programscopes;

import com.dsl.fachade.models.DSLModel;
import ASTMCore.ASTMSource.CompilationUnit;

public interface IProgramScopeHandler {
	
	void processCompilationUnitScope(CompilationUnit compilationUnit, DSLModel model);
}
