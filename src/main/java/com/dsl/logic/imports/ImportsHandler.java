package com.dsl.logic.imports;

import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.ImportsFactory;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class ImportsHandler implements IImportsHandler {

	@Override
	public void processCompilationUnitImports(CompilationUnit compilationUnit, DSLModel model, String language) throws UnsupportedLanguageException {
		ImportsBaseHandler handler = ImportsFactory.createImportHandler(language);
		handler.processCompilationUnitImports(compilationUnit, model);
	}
}
