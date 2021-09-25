package factories;

import models.entities.unittests.asserts.*;

public class AssertsFactory {

    public AssertType createAssert(String type){
        AssertType assertion = null;

        switch (type){
            case "areEqual":
                assertion = new AreEqual(); break;
            case "areNotEqual":
                assertion = new AreNotEqual(); break;
            case "isTrue":
                assertion = new IsTrue(); break;
            case "isFalse":
                assertion = new IsFalse(); break;
            case "isNull":
                assertion = new IsNull(); break;
            case "isNotNull":
                assertion = new IsNotNull(); break;
            case "isInstanceOfType":
                assertion = new IsInstanceOfType(); break;
        }

        return assertion;
    }

}
