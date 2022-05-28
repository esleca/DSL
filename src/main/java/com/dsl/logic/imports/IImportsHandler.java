package com.dsl.logic.imports;

import com.dsl.fachade.models.DSLModel;
import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IImportsHandler {

	void processCompilationUnitImports(CompilationUnit compilationUnit, DSLModel model, String language) throws UnsupportedLanguageException;
}
