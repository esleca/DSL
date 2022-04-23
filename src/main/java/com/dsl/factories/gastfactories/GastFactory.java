package com.dsl.factories.gastfactories;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.NameSpaceDefinition;

public class GastFactory {

    public static CompilationUnit getCompilationUnit(){
        return new CompilationUnit();
    }

    public static NameSpaceDefinition getNameSpaceDefinition(){
        return new NameSpaceDefinition();
    }

    public static Name getName(){
        return new Name();
    }
}
