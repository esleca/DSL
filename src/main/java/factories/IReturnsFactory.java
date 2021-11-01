package factories;

import exceptions.ReturnNotFoundException;
import models.entities.returns.ParameterDataType;
import models.entities.returns.Return;

public interface IReturnsFactory {

    ParameterDataType createParameterDataType();

    Return createPrimitiveReturn(String type) throws ReturnNotFoundException;

    Return createParameterizedReturn(String type, ParameterDataType dataType) throws ReturnNotFoundException;

    Return createInstanceReturn();

}
