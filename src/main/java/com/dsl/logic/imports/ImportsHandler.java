package com.dsl.logic.imports;

import org.springframework.stereotype.Component;

import com.dsl.factories.ImportsFactory;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class ImportsHandler implements IImportsHandler {

	@Override
	public void processCompilationUnitImports(CompilationUnit compilationUnit, String language) throws UnsupportedLanguageException {
		ImportsBaseHandler handler = ImportsFactory.createImportHandler(language);
		handler.processCompilationUnitImports(compilationUnit);
	}
}
