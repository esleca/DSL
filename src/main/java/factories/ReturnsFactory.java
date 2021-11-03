package factories;

import exceptions.ReturnNotFoundException;
import models.entities.returns.*;
import utils.Constants;

public class ReturnsFactory {

    public static ParameterDataType createParameterDataType() {
        return new ParameterDataType();
    }

    public static Return createPrimitiveReturn(String type) throws ReturnNotFoundException {
        Return returns;

        switch (type){
            case Constants.RETURN_INTEGER:
                returns = new IntegerReturn(); break;
            case Constants.RETURN_STRING:
                returns = new StringReturn(); break;
            case Constants.RETURN_BOOLEAN:
                returns = new BooleanReturn(); break;
            case Constants.RETURN_FLOAT:
                returns = new FloatReturn(); break;
            case Constants.RETURN_LONG:
                returns = new LongReturn(); break;
            case Constants.RETURN_DOUBLE:
                returns = new DoubleReturn(); break;
            case Constants.RETURN_CHAR:
                returns = new CharReturn(); break;
            case Constants.RETURN_VOID:
                returns = new VoidReturn(); break;
            default:
                throw new ReturnNotFoundException();
        }

        return returns;
    }

    public static Return createParameterizedReturn(String type, ParameterDataType dataType) throws ReturnNotFoundException {
        Return returns;
        if (Constants.RETURN_PARAMETERIZED.equals(type)) {
            returns = new ParameterizedReturn(dataType);
        } else {
            throw new ReturnNotFoundException();
        }
        return returns;
    }

    public static Return createInstanceReturn(){
        return new InstanceReturn();
    }

}
