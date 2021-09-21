package models.entities.valuetypes;

import models.DSLMObject;

public abstract class ValueType extends DSLMObject {

    public abstract void setValue(Object value);

    public abstract Object getValue();

}
