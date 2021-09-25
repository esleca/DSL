package models.entities.unittests.arranges;

import models.entities.valuetypes.ValueType;

public class Definition {

    private ValueType valueType;
    private Declaration declaration;

    public Definition (ValueType valueType){
        this.valueType = valueType;
    }


    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }
}
