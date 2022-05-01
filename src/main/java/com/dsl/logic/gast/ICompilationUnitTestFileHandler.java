package com.dsl.logic.gast;

import ASTMCore.ASTMSource.CompilationUnit;
import com.dsl.fachade.models.GestorModel;

import java.util.ArrayList;

public interface ICompilationUnitTestFileHandler {

    ArrayList<CompilationUnit> processCompilationUnitTests(GestorModel model);
}
