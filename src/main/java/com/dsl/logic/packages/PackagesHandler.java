package com.dsl.logic.packages;

import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.GastFactory;
import com.dsl.models.aggregates.Package;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.NameSpaceDefinition;


@Component
public class PackagesHandler implements IPackagesHandler {

	@Override
	public void processCompilationUnitPackage(CompilationUnit compilationUnit, DSLModel model) {
		NameSpaceDefinition nameSpaceDefinition = getNameSpaceDefinition(model);
        compilationUnit.setgPackage(nameSpaceDefinition);
	}

	private NameSpaceDefinition getNameSpaceDefinition(DSLModel model){
        NameSpaceDefinition nameSpaceDefinition = GastFactory.getNameSpaceDefinition();
        
        Package pkg = model.getlClass().getPackage();
        Name nameObj = GastFactory.getName(pkg.getName());
        nameSpaceDefinition.setNameSpace(nameObj);

        return nameSpaceDefinition;
    }
}
