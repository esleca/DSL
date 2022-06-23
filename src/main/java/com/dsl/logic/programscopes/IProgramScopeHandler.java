package com.dsl.logic.programscopes;

import com.dsl.fachade.models.DSLModel;
import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IProgramScopeHandler {
	
	void processCompilationUnitScope(CompilationUnit compilationUnit, DSLModel model) throws UnsupportedLanguageException;
}
