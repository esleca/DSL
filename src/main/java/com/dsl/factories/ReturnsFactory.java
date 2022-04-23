package com.dsl.factories;

import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.models.entities.returns.*;
import static com.dsl.utils.Constants.*;

public class ReturnsFactory {

    public static ParameterDataType createParameterDataType() {
        return new ParameterDataType();
    }

    public static Return createPrimitiveReturn(String type) throws ReturnNotFoundException {
        Return returns;

        switch (type){
            case RETURN_INTEGER:
                returns = new IntegerReturn(); break;
            case RETURN_STRING:
                returns = new StringReturn(); break;
            case RETURN_BOOLEAN:
                returns = new BooleanReturn(); break;
            case RETURN_FLOAT:
                returns = new FloatReturn(); break;
            case RETURN_LONG:
                returns = new LongReturn(); break;
            case RETURN_DOUBLE:
                returns = new DoubleReturn(); break;
            case RETURN_CHAR:
                returns = new CharReturn(); break;
            case RETURN_VOID:
                returns = new VoidReturn(); break;
            default:
                //throw new ReturnNotFoundException();
                returns = createInstanceReturn(type);
        }

        return returns;
    }

    public static Return createParameterizedReturn(String type, ParameterDataType dataType) throws ReturnNotFoundException {
        Return returns;
        if (RETURN_PARAMETERIZED.equals(type)) {
            returns = new ParameterizedReturn(dataType);
        } else {
            throw new ReturnNotFoundException();
        }
        return returns;
    }

    private static Return createInstanceReturn(String name){
        return new InstanceReturn(name);
    }

}
