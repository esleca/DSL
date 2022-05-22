package com.dsl.logic.imports;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IImportsHandler {

	void processCompilationUnitImports(CompilationUnit compilationUnit, String language) throws UnsupportedLanguageException;
}
