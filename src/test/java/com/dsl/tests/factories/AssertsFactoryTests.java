package com.dsl.tests.factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.factories.AssertTypesFactory;
import com.dsl.models.unittests.asserts.types.*;
import static com.dsl.utils.Constants.LANGUAGE_JAVA;


public class AssertsFactoryTests {
	
	// JAVA TESTS
	

	//___________________________________________
    // test_Java_createAssertType_AreEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  areEqual type is passed
    // THEN:  AreEqual type is returned
    //___________________________________________
	@Test
	public void test_Java_createAssertType_AreEqual() throws AssertNotFoundException {
		//Arrange
		String type = "areEqual";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertEquals("assertEquals", assertType.getName());
	}
	
	
	//______________________________________________
    // test_Java_createAssertType_InstanceOfAreEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  areEqual type is passed
    // THEN:  AssertType is instance of AreEqual
    //______________________________________________
	@Test
	public void test_Java_createAssertType_InstanceOfAreEqual() throws AssertNotFoundException {
		//Arrange
		String type = "areEqual";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertTrue(assertType instanceof AreEqual);
	}
	
	
	//___________________________________________
    // test_Java_createAssertType_AreNotEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  AreNotEqual type is passed
    // THEN:  AreNotEqual type is returned
    //___________________________________________
	@Test
	public void test_Java_createAssertType_AreNotEqual() throws AssertNotFoundException {
		//Arrange
		String type = "areNotEqual";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertEquals("assertNotEquals", assertType.getName());
	}
	
	
	//______________________________________________
    // test_Java_createAssertType_InstanceOfAreNotEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  AreNotEqual type is passed
    // THEN:  AssertType is instance of AreNotEqual
    //______________________________________________
	@Test
	public void test_Java_createAssertType_InstanceOfAreNotEqual() throws AssertNotFoundException {
		//Arrange
		String type = "areNotEqual";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertTrue(assertType instanceof AreNotEqual);
	}
	
	
	//___________________________________________
    // test_Java_createAssertType_IsTrue
    //
    // GIVEN: createAssertType is called
    // WHEN:  isTrue type is passed
    // THEN:  IsTrue type is returned
    //___________________________________________
	@Test
	public void test_Java_createAssertType_IsTrue() throws AssertNotFoundException {
		//Arrange
		String type = "isTrue";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertEquals("assertTrue", assertType.getName());
	}
	
	
	//______________________________________________
    // test_Java_createAssertType_InstanceOfIsTrue
    //
    // GIVEN: createAssertType is called
    // WHEN:  isTrue type is passed
    // THEN:  AssertType is instance of IsTrue
    //______________________________________________
	@Test
	public void test_Java_createAssertType_InstanceOfIsTrue() throws AssertNotFoundException {
		//Arrange
		String type = "isTrue";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertTrue(assertType instanceof IsTrue);
	}
	
	
	//___________________________________________
    // test_Java_createAssertType_IsFalse
    //
    // GIVEN: createAssertType is called
    // WHEN:  isFalse type is passed
    // THEN:  IsFalse type is returned
    //___________________________________________
	@Test
	public void test_Java_createAssertType_IsFalse() throws AssertNotFoundException {
		//Arrange
		String type = "isFalse";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertEquals("assertFalse", assertType.getName());
	}
	
	
	//______________________________________________
    // test_Java_createAssertType_InstanceOfIsFalse
    //
    // GIVEN: createAssertType is called
    // WHEN:  isFalse type is passed
    // THEN:  AssertType is instance of IsFalse
    //______________________________________________
	@Test
	public void test_Java_createAssertType_InstanceOfIsFalse() throws AssertNotFoundException {
		//Arrange
		String type = "isFalse";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertTrue(assertType instanceof IsFalse);
	}
	
	
	//___________________________________________
    // test_Java_createAssertType_IsNull
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsNull type is passed
    // THEN:  IsNull type is returned
    //___________________________________________
	@Test
	public void test_Java_createAssertType_IsNull() throws AssertNotFoundException {
		//Arrange
		String type = "isNull";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertEquals("assertNull", assertType.getName());
	}
	
	
	//______________________________________________
    // test_Java_createAssertType_InstanceOfIsNull
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsNull type is passed
    // THEN:  AssertType is instance of IsNull
    //______________________________________________
	@Test
	public void test_Java_createAssertType_InstanceOfIsNull() throws AssertNotFoundException {
		//Arrange
		String type = "isNull";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertTrue(assertType instanceof IsNull);
	}
	
	
	//___________________________________________
    // test_Java_createAssertType_IsNotNull
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsNotNull type is passed
    // THEN:  IsNotNull type is returned
    //___________________________________________
	@Test
	public void test_Java_createAssertType_IsNotNull() throws AssertNotFoundException {
		//Arrange
		String type = "isNotNull";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertEquals("assertNotNull", assertType.getName());
	}
	
	
	//______________________________________________
    // test_Java_createAssertType_InstanceOfIsNotNull
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsNotNull type is passed
    // THEN:  AssertType is instance of IsNotNull
    //______________________________________________
	@Test
	public void test_Java_createAssertType_InstanceOfIsNotNull() throws AssertNotFoundException {
		//Arrange
		String type = "isNotNull";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertTrue(assertType instanceof IsNotNull);
	}
	
	
	//___________________________________________
    // test_Java_createAssertType_IsInstanceOfType
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsInstanceOfType type is passed
    // THEN:  IsInstanceOfType type is returned
    //___________________________________________
	@Test
	public void test_Java_createAssertType_IsInstanceOfType() throws AssertNotFoundException {
		//Arrange
		String type = "isInstanceOfType";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertEquals("assertInstanceOfType", assertType.getName());
	}
	
	
	//__________________________________________________
    // test_Java_createAssertType_InstanceOfType
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsInstanceOfType type is passed
    // THEN:  AssertType is instance of IsInstanceOfType
    //__________________________________________________
	@Test
	public void test_Java_createAssertType_InstanceOfType() throws AssertNotFoundException {
		//Arrange
		String type = "isInstanceOfType";
		
		//Act
		AssertType assertType = AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		
		//Assert
		assertTrue(assertType instanceof IsInstanceOfType);
	}
	
	
	//___________________________________________
    // test_Java_createAssertType_AreEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  areEqual type is passed
    // THEN:  AreEqual type is returned
    //___________________________________________
	@Test
	public void test_Java_createAssertType_NotFoundException() throws AssertNotFoundException {
		//Arrange
		String type = "invalid";
		
		//Act
		Exception exception = assertThrows(AssertNotFoundException.class, () -> {
			AssertTypesFactory.createAssertType(type, LANGUAGE_JAVA);
		});
		
		String expectedMessage = "Invalid DSL unit test assert";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
