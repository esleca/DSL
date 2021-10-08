package factories;

import exceptions.AssertNotFoundException;
import models.entities.unittests.asserts.types.*;
import utils.Constants;

public class AssertsFactory implements IAssertTypesFactory {

    @Override
    public AssertType createAssertType(String type) throws AssertNotFoundException {
        AssertType assertType;

        switch (type){
            case Constants.ASSERT_ARE_EQUAL:
                assertType = new AreEqual(); break;
            case Constants.ASSERT_ARE_NOT_EQUAL:
                assertType = new AreNotEqual(); break;
            case Constants.ASSERT_IS_TRUE:
                assertType = new IsTrue(); break;
            case Constants.ASSERT_IS_FALSE:
                assertType = new IsFalse(); break;
            case Constants.ASSERT_IS_NULL:
                assertType = new IsNull(); break;
            case Constants.ASSERT_IS_NOT_NULL:
                assertType = new IsNotNull(); break;
            case Constants.ASSERT_INSTANCE_OF:
                assertType = new IsInstanceOfType(); break;
            default:
                throw new AssertNotFoundException();
        }

        return assertType;
    }

}
