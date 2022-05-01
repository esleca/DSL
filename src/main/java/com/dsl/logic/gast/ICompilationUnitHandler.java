package com.dsl.logic.gast;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;
import java.util.ArrayList;

public interface ICompilationUnitHandler {
	
	void setLanguage(String language) throws UnsupportedLanguageException;
    
	ArrayList<CompilationUnit> createCompilationUnits(String classPath) throws IOException, UnsupportedLanguageException;
}
