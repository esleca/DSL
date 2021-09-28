package factories;

import exceptions.AssertNotFoundException;
import models.entities.unittests.asserts.types.*;

public class AssertsFactory {

    public AssertType createAssertType(String type) throws AssertNotFoundException {
        AssertType assertType = null;

        switch (type){
            case "areEqual":
                assertType = new AreEqual(); break;
            case "areNotEqual":
                assertType = new AreNotEqual(); break;
            case "isTrue":
                assertType = new IsTrue(); break;
            case "isFalse":
                assertType = new IsFalse(); break;
            case "isNull":
                assertType = new IsNull(); break;
            case "isNotNull":
                assertType = new IsNotNull(); break;
            case "isInstanceOfType":
                assertType = new IsInstanceOfType(); break;
        }

        if (assertType == null){
            throw new AssertNotFoundException();
        }

        return assertType;
    }

}
