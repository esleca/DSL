package com.dsl.logic.programscopes;

import com.dsl.fachade.models.DSLModel;
import ASTMCore.ASTMSemantics.AggregateScope;
import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IAggregateScopeHandler {
	
	AggregateScope getAggregateScope(CompilationUnit compilationUnit, DSLModel model) throws UnsupportedLanguageException;
}
