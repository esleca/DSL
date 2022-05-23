package com.dsl.logic.imports;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;

public abstract class ImportsBaseHandler {

	public abstract void processCompilationUnitImports(CompilationUnit compilationUnit);
	
	protected ImportDeclaration importDeclaration(String name) {
		ImportDeclaration importDeclaration = new ImportDeclaration();
        importDeclaration.setIdentifierName(new Name(name));        
        return importDeclaration;
	}
	
	protected ImportDeclaration importDeclarationSourceClass(CompilationUnit compilationUnit) {
		String pkg = compilationUnit.getgPackage().getNameSpace().getNameString();
		return importDeclaration(pkg);
	}
}
