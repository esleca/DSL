package factories;

import exceptions.ReturnNotFoundException;
import models.entities.returns.*;

public class ReturnsFactory {

    public Return createReturn(String type) throws ReturnNotFoundException {
        Return returns = null;

        if (isPrimitiveReturnType(type)){
            switch (type){
                case "int":
                    returns = new IntegerReturn(); break;
                case "String":
                    returns = new StringReturn(); break;
                case "boolean":
                    returns = new BooleanReturn(); break;
                case "float":
                    returns = new FloatReturn(); break;
                case "long":
                    returns = new LongReturn(); break;
                case "double":
                    returns = new DoubleReturn(); break;
                case "char":
                    returns = new CharReturn(); break;
                case "void":
                    returns = new VoidReturn(); break;
            }
        }else{
            returns = null;
        }

        if(returns == null){
            throw new ReturnNotFoundException();
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
