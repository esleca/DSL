package com.dsl.logic.imports;

import java.util.ArrayList;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;

import static com.dsl.utils.Constants.*;

public class ImportsJavaHandler extends ImportsBaseHandler {

	@Override
	public void processCompilationUnitImports(CompilationUnit compilationUnit) {
		ArrayList<ImportDeclaration> importDeclarations = new ArrayList<>();
		
		ImportDeclaration importDeclaration = importDeclaration(JAVA_JUNIT_JUPITER);
		importDeclarations.add(importDeclaration);
		
		importDeclaration = importDeclaration(JAVA_JUNIT_ASSERT);
		importDeclaration.setStatic(true);
		importDeclarations.add(importDeclaration);

		importDeclaration = importDeclarationSourceClass(compilationUnit);
		importDeclarations.add(importDeclaration);
		
		compilationUnit.setImports(importDeclarations);
	}
}
