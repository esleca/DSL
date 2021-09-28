package factories;

import exceptions.ValueTypeNotFoundException;
import models.entities.valuetypes.*;

public class ValueTypeFactory {

    public ValueType createValueType(String inType, Object value) throws ValueTypeNotFoundException {
        ValueType type = null;

        switch (inType){
            case "int":
                type = new IntegerType(); break;
            case "long":
                type = new LongType(); break;
            case "boolean":
                type = new BooleanType(); break;
            case "String":
                type = new StringType(); break;
            case "float":
                type = new FloatType(); break;
            case "double":
                type = new DoubleType(); break;
            case "char":
                type = new CharType(); break;
        }

        if (type != null){
            type.setValue(value);
        }

        if (type == null){
            throw new ValueTypeNotFoundException();
        }

        return type;
    }
}
