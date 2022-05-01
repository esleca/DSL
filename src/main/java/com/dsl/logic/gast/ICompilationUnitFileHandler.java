package com.dsl.logic.gast;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;
import java.util.ArrayList;

public interface ICompilationUnitFileHandler {

    ArrayList<CompilationUnit> processFilesInDir(boolean writeInDisk) throws IOException, UnsupportedLanguageException;
}
