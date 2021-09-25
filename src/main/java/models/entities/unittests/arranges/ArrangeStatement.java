package models.entities.unittests.arranges;

public class ArrangeStatement {

    private Declaration declaration;
    private Definition definition;

    public ArrangeStatement(Declaration declaration, Definition definition) {
        this.declaration = declaration;
        this.definition = definition;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }
}
