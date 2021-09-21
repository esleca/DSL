package models.entities.valuetypes;

public class LongType extends ValueType {

    private long value;

    @Override
    public void setValue(Object value) {
        this.value = (long) value;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
