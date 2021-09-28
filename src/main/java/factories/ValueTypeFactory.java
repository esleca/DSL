package factories;

import exceptions.ValueTypeNotFoundException;
import models.entities.valuetypes.*;
import utils.Constants;

public class ValueTypeFactory {

    public ValueType createValueType(String inType, Object value) throws ValueTypeNotFoundException {
        ValueType type;

        switch (inType){
            case Constants.VALUE_TYPE_INTEGER:
                type = new IntegerType(); break;
            case Constants.VALUE_TYPE_STRING:
                type = new StringType(); break;
            case Constants.VALUE_TYPE_BOOLEAN:
                type = new BooleanType(); break;
            case Constants.VALUE_TYPE_FLOAT:
                type = new FloatType(); break;
            case Constants.VALUE_TYPE_LONG:
                type = new LongType(); break;
            case Constants.VALUE_TYPE_DOUBLE:
                type = new DoubleType(); break;
            case Constants.VALUE_TYPE_CHAR:
                type = new CharType(); break;
            default:
                throw new ValueTypeNotFoundException();
        }

        if (type != null && value != null){
            type.setValue(value);
        }

        return type;
    }
}
