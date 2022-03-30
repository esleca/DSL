package factories;

import exceptions.ValueTypeNotFoundException;
import models.entities.valuetypes.*;

import static utils.Constants.*;

public class ValueTypeFactory {

    public static ValueType createValueType(String inType, Object value) throws ValueTypeNotFoundException {
        ValueType type;

        switch (inType){
            case VALUE_TYPE_INTEGER:
                type = new IntegerType(); break;
            case VALUE_TYPE_STRING:
                type = new StringType(); break;
            case VALUE_TYPE_BOOLEAN:
                type = new BooleanType(); break;
            case VALUE_TYPE_FLOAT:
                type = new FloatType(); break;
            case VALUE_TYPE_LONG:
                type = new LongType(); break;
            case VALUE_TYPE_DOUBLE:
                type = new DoubleType(); break;
            case VALUE_TYPE_CHAR:
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
