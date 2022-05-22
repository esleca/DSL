package com.dsl.logic.gast;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

import com.dsl.fachade.models.DSLModel;

import java.util.ArrayList;

public interface ICompilationUnitTestHandler {

    ArrayList<CompilationUnit> processCompilationUnitTests(DSLModel model, String language) throws UnsupportedLanguageException;
}
