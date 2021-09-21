package models.entities.valuetypes;

public class DoubleType extends ValueType {

    private double value;

    @Override
    public void setValue(Object value) {
        this.value = (double) value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
