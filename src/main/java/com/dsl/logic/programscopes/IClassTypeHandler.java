package com.dsl.logic.programscopes;

import com.dsl.fachade.models.DSLModel;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.Types.ClassType;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IClassTypeHandler {
	
	ClassType getClassType(CompilationUnit compilationUnit, DSLModel model) throws UnsupportedLanguageException;
}
