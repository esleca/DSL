package factories;

import exceptions.ReturnNotFoundException;
import models.entities.returns.Return;

public interface IReturnsFactory {

    Return createReturn(String type) throws ReturnNotFoundException;
}
