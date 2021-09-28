package models.entities.valuetypes;

public class BooleanType extends ValueType {

    private boolean value;

    @Override
    public void setValue(Object value) {
        if (value.equals("true")) {
            this.value = true;
        }else{
            this.value = false;
        }
    }

    @Override
    public Object getValue() {
        return value;
    }
}
