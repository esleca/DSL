package com.dsl.logic.packages;

import com.dsl.fachade.models.DSLModel;

import ASTMCore.ASTMSource.CompilationUnit;

public interface IPackagesHandler {
	
	void processCompilationUnitPackage(CompilationUnit compilationUnit, DSLModel model);
}
