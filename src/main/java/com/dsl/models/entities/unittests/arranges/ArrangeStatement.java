package com.dsl.models.entities.unittests.arranges;

import com.dsl.models.entities.unittests.Declaration;

public class ArrangeStatement {

    private Declaration declaration;
    private ArrangeDefinition definition;

    public ArrangeStatement(Declaration declaration, ArrangeDefinition definition) {
        this.declaration = declaration;
        this.definition = definition;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public ArrangeDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(ArrangeDefinition definition) {
        this.definition = definition;
    }
}
