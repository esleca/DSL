package com.dsl.logic.imports;

import com.dsl.fachade.models.DSLModel;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;

public abstract class ImportsBaseHandler {

	public abstract void processCompilationUnitImports(CompilationUnit compilationUnit, DSLModel model);
	
	protected ImportDeclaration importDeclaration(String name) {
		ImportDeclaration importDeclaration = new ImportDeclaration();
        importDeclaration.setIdentifierName(new Name(name));        
        return importDeclaration;
	}
	
	protected ImportDeclaration importDeclarationSourceClass(DSLModel model) {
		String pkg = model.getlClass().getPackage().getName();
		return importDeclaration(pkg);
	}
}
