package com.dsl.logic.imports;

import java.util.ArrayList;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;


public class ImportsJavaHandler extends ImportsBaseHandler {

	@Override
	protected void processCompilationUnitImports(CompilationUnit compilationUnit) {
		ArrayList<ImportDeclaration> importDeclarations = new ArrayList<>();
		
		importDeclarations.add(importDeclaration("org.junit.jupiter.api.Test"));
        
		ImportDeclaration importDeclaration = importDeclaration("org.junit.Assert.*");
		importDeclaration.setStatic(true);
		importDeclarations.add(importDeclaration);

		compilationUnit.setImports(importDeclarations);
	}
}
