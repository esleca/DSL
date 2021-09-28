package factories;

import exceptions.ReturnNotFoundException;
import models.entities.returns.*;
import utils.Constants;

public class ReturnsFactory {

    public Return createReturn(String type) throws ReturnNotFoundException {
        Return returns;

        if (isPrimitiveReturnType(type)){
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
        }else{
            returns = null;
        }

        return returns;
    }


    private boolean isPrimitiveReturnType(String type){
        if (true){
            return true;
        }

        return false;
    }
}
