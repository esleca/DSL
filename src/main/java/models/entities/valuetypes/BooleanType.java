package models.entities.valuetypes;

public class BooleanType extends ValueType {

    private boolean value;

    @Override
    public void setValue(Object value) {
        this.value = (boolean) value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
