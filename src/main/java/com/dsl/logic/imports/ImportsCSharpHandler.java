package com.dsl.logic.imports;

import java.util.ArrayList;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;


public class ImportsCSharpHandler extends ImportsBaseHandler {

	@Override
	protected void processCompilationUnitImports(CompilationUnit compilationUnit) {
		ArrayList<ImportDeclaration> importDeclarations = new ArrayList<>();
		
		importDeclarations.add(importDeclaration("System"));
        importDeclarations.add(importDeclaration("System.Collections.Generic"));
        importDeclarations.add(importDeclaration("System.Linq"));
        importDeclarations.add(importDeclaration("System.Text"));
        importDeclarations.add(importDeclaration("System.Threading.Tasks"));
        importDeclarations.add(importDeclaration("Microsoft.VisualStudio.TestTools.UnitTesting"));
		
		compilationUnit.setImports(importDeclarations);
	}
}
