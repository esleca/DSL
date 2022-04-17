package repositories;

import models.dtos.UnitTestRequest;
import models.entities.unittests.UnitTest;

public class DSLRepo implements IDSLRepo{

    public DSLRepo(){
        
    }

    @Override
    public UnitTest saveToDataStore(UnitTestRequest request) {
        return null;
    }
}
