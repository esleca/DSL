package com.dsl.factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.models.entities.unittests.asserts.types.*;

public class AssertsFactoryTests {

	//___________________________________________
    // test_createAssertType_AreEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  areEqual type is passed
    // THEN:  AreEqual type is returned
    //___________________________________________
	@Test
	public void test_createAssertType_AreEqual() throws AssertNotFoundException {
		//Arrange
		String type = "areEqual";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertEquals("areEqual", assertType.getName());
	}
	
	
	//______________________________________________
    // test_createAssertType_InstanceOfAreEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  areEqual type is passed
    // THEN:  AssertType is instance of AreEqual
    //______________________________________________
	@Test
	public void test_createAssertType_InstanceOfAreEqual() throws AssertNotFoundException {
		//Arrange
		String type = "areEqual";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertTrue(assertType instanceof AreEqual);
	}
	
	
	//___________________________________________
    // test_createAssertType_AreNotEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  AreNotEqual type is passed
    // THEN:  AreNotEqual type is returned
    //___________________________________________
	@Test
	public void test_createAssertType_AreNotEqual() throws AssertNotFoundException {
		//Arrange
		String type = "areNotEqual";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertEquals("areNotEqual", assertType.getName());
	}
	
	
	//______________________________________________
    // test_createAssertType_InstanceOfAreNotEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  AreNotEqual type is passed
    // THEN:  AssertType is instance of AreNotEqual
    //______________________________________________
	@Test
	public void test_createAssertType_InstanceOfAreNotEqual() throws AssertNotFoundException {
		//Arrange
		String type = "areNotEqual";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertTrue(assertType instanceof AreNotEqual);
	}
	
	
	//___________________________________________
    // test_createAssertType_IsTrue
    //
    // GIVEN: createAssertType is called
    // WHEN:  isTrue type is passed
    // THEN:  IsTrue type is returned
    //___________________________________________
	@Test
	public void test_createAssertType_IsTrue() throws AssertNotFoundException {
		//Arrange
		String type = "isTrue";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertEquals("isTrue", assertType.getName());
	}
	
	
	//______________________________________________
    // test_createAssertType_InstanceOfIsTrue
    //
    // GIVEN: createAssertType is called
    // WHEN:  isTrue type is passed
    // THEN:  AssertType is instance of IsTrue
    //______________________________________________
	@Test
	public void test_createAssertType_InstanceOfIsTrue() throws AssertNotFoundException {
		//Arrange
		String type = "isTrue";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertTrue(assertType instanceof IsTrue);
	}
	
	
	//___________________________________________
    // test_createAssertType_IsFalse
    //
    // GIVEN: createAssertType is called
    // WHEN:  isFalse type is passed
    // THEN:  IsFalse type is returned
    //___________________________________________
	@Test
	public void test_createAssertType_IsFalse() throws AssertNotFoundException {
		//Arrange
		String type = "isFalse";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertEquals("isFalse", assertType.getName());
	}
	
	
	//______________________________________________
    // test_createAssertType_InstanceOfIsFalse
    //
    // GIVEN: createAssertType is called
    // WHEN:  isFalse type is passed
    // THEN:  AssertType is instance of IsFalse
    //______________________________________________
	@Test
	public void test_createAssertType_InstanceOfIsFalse() throws AssertNotFoundException {
		//Arrange
		String type = "isFalse";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertTrue(assertType instanceof IsFalse);
	}
	
	
	//___________________________________________
    // test_createAssertType_IsNull
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsNull type is passed
    // THEN:  IsNull type is returned
    //___________________________________________
	@Test
	public void test_createAssertType_IsNull() throws AssertNotFoundException {
		//Arrange
		String type = "isNull";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertEquals("isNull", assertType.getName());
	}
	
	
	//______________________________________________
    // test_createAssertType_InstanceOfIsNull
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsNull type is passed
    // THEN:  AssertType is instance of IsNull
    //______________________________________________
	@Test
	public void test_createAssertType_InstanceOfIsNull() throws AssertNotFoundException {
		//Arrange
		String type = "isNull";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertTrue(assertType instanceof IsNull);
	}
	
	
	//___________________________________________
    // test_createAssertType_IsNotNull
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsNotNull type is passed
    // THEN:  IsNotNull type is returned
    //___________________________________________
	@Test
	public void test_createAssertType_IsNotNull() throws AssertNotFoundException {
		//Arrange
		String type = "isNotNull";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertEquals("isNotNull", assertType.getName());
	}
	
	
	//______________________________________________
    // test_createAssertType_InstanceOfIsNotNull
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsNotNull type is passed
    // THEN:  AssertType is instance of IsNotNull
    //______________________________________________
	@Test
	public void test_createAssertType_InstanceOfIsNotNull() throws AssertNotFoundException {
		//Arrange
		String type = "isNotNull";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertTrue(assertType instanceof IsNotNull);
	}
	
	
	//___________________________________________
    // test_createAssertType_IsInstanceOfType
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsInstanceOfType type is passed
    // THEN:  IsInstanceOfType type is returned
    //___________________________________________
	@Test
	public void test_createAssertType_IsInstanceOfType() throws AssertNotFoundException {
		//Arrange
		String type = "isInstanceOfType";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertEquals("isInstanceOfType", assertType.getName());
	}
	
	
	//__________________________________________________
    // test_createAssertType_InstanceOfType
    //
    // GIVEN: createAssertType is called
    // WHEN:  IsInstanceOfType type is passed
    // THEN:  AssertType is instance of IsInstanceOfType
    //__________________________________________________
	@Test
	public void test_createAssertType_InstanceOfType() throws AssertNotFoundException {
		//Arrange
		String type = "isInstanceOfType";
		
		//Act
		AssertType assertType = AssertsFactory.createAssertType(type);
		
		//Assert
		assertTrue(assertType instanceof IsInstanceOfType);
	}
	
	
	//___________________________________________
    // test_createAssertType_AreEqual
    //
    // GIVEN: createAssertType is called
    // WHEN:  areEqual type is passed
    // THEN:  AreEqual type is returned
    //___________________________________________
	@Test
	public void test_createAssertType_NotFoundException() throws AssertNotFoundException {
		//Arrange
		String type = "invalid";
		
		//Act
		Exception exception = assertThrows(AssertNotFoundException.class, () -> {
			AssertsFactory.createAssertType(type);
		});
		
		String expectedMessage = "Invalid DSL unit test assert";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
