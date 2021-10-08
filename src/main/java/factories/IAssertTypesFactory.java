package factories;

import exceptions.AssertNotFoundException;
import models.entities.unittests.asserts.types.AssertType;

public interface IAssertTypesFactory {

    AssertType createAssertType(String type) throws AssertNotFoundException;
}
