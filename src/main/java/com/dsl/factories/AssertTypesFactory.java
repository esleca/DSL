package com.dsl.factories;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.models.unittests.asserts.types.*;
import com.dsl.models.unittests.asserts.types.java.*;
import com.dsl.models.unittests.asserts.types.csharp.*;

import static com.dsl.utils.Constants.*;

public class AssertTypesFactory {

	public static AssertType createAssertType(String type, String language) throws AssertNotFoundException {
		AssertType assertType;

        switch (language.toUpperCase()){
            case LANGUAGE_JAVA:
                assertType = createJavaAssertType(type); break;
            case LANGUAGE_CSHARP:
                assertType = createCSharpAssertType(type); break;
            default:
                throw new AssertNotFoundException();
        }

        return assertType;
	}
	
    private static AssertType createJavaAssertType(String type) throws AssertNotFoundException {
        AssertType assertType;

        switch (type){
            case ASSERT_ARE_EQUAL:
                assertType = new JavaAreEqual(); break;
            case ASSERT_ARE_NOT_EQUAL:
                assertType = new JavaAreNotEqual(); break;
            case ASSERT_IS_TRUE:
                assertType = new JavaIsTrue(); break;
            case ASSERT_IS_FALSE:
                assertType = new JavaIsFalse(); break;
            case ASSERT_IS_NULL:
                assertType = new JavaIsNull(); break;
            case ASSERT_IS_NOT_NULL:
                assertType = new JavaIsNotNull(); break;
            case ASSERT_INSTANCE_OF:
                assertType = new JavaIsInstanceOfType(); break;
            default:
                throw new AssertNotFoundException();
        }

        return assertType;
    }

    private static AssertType createCSharpAssertType(String type) throws AssertNotFoundException {
        AssertType assertType;

        switch (type){
            case ASSERT_ARE_EQUAL:
                assertType = new CSharpAreEqual(); break;
            case ASSERT_ARE_NOT_EQUAL:
                assertType = new CSharpAreNotEqual(); break;
            case ASSERT_IS_TRUE:
                assertType = new CSharpIsTrue(); break;
            case ASSERT_IS_FALSE:
                assertType = new CSharpIsFalse(); break;
            case ASSERT_IS_NULL:
                assertType = new CSharpIsNull(); break;
            case ASSERT_IS_NOT_NULL:
                assertType = new CSharpIsNotNull(); break;
            case ASSERT_INSTANCE_OF:
                assertType = new CSharpIsInstanceOfType(); break;
            default:
                throw new AssertNotFoundException();
        }

        return assertType;
    }
    
}
