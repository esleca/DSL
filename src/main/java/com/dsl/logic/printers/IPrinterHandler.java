package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IPrinterHandler {
	
	String generateCode(CompilationUnit compilationUnit, String outLanguage, String outPath) throws UnsupportedLanguageException;
}
