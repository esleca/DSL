package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IPrinterHandler {
	
	String generateCode(String className, CompilationUnit compilationUnit, String outLanguage, String outPath) throws UnsupportedLanguageException;
}
