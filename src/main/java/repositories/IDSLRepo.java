package repositories;

import models.dtos.UnitTestRequest;
import models.entities.unittests.UnitTest;

public interface IDSLRepo {

    UnitTest saveToDataStore(UnitTestRequest request);
}
