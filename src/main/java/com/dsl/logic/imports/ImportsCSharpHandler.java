package com.dsl.logic.imports;

import java.util.ArrayList;

import com.dsl.fachade.models.DSLModel;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;

import static com.dsl.utils.Constants.*;

public class ImportsCSharpHandler extends ImportsBaseHandler {

	@Override
	public void processCompilationUnitImports(CompilationUnit compilationUnit, DSLModel model) {
		ArrayList<ImportDeclaration> importDeclarations = new ArrayList<>();
		
		importDeclarations.add(importDeclaration(CSHARP_SYSTEM));
        importDeclarations.add(importDeclaration(CSHARP_SYSTEM_COLLECTIONS));
        importDeclarations.add(importDeclaration(CSHARP_SYSTEM_LINQ));
        importDeclarations.add(importDeclaration(CSHARP_SYSTEM_TEXT));
        importDeclarations.add(importDeclaration(CSHARP_SYSTEM_THREADING));
        importDeclarations.add(importDeclaration(CSHARP_UNITTEST));
		importDeclarations.add(importDeclarationSourceClass(model));
		
		compilationUnit.setImports(importDeclarations);
	}
}
