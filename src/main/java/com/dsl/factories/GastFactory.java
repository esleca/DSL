package com.dsl.factories;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.NameSpaceDefinition;

public class GastFactory {

    public static CompilationUnit createCompilationUnit(){
        return new CompilationUnit();
    }

    public static NameSpaceDefinition getNameSpaceDefinition(){
        return new NameSpaceDefinition();
    }

    public static Name getName(String name){
        return new Name(name);
    }
}
