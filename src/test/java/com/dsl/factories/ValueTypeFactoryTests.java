package com.dsl.factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.entities.valuetypes.*;


public class ValueTypeFactoryTests {

	//___________________________________________
    // test_createValueType_IntegerType
    //
    // GIVEN: createValueType is called
    // WHEN:  int type is passed
	//  AND:  object is a string 
    // THEN:  Value is returned as correct string
    //___________________________________________
	@Test
	public void test_createValueType_IntegerType() throws ValueTypeNotFoundException {
		//Arrange
		String type = "int";
		Object obj = "-1";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertEquals(-1, valueType.getValue());
	}
	
	
	//___________________________________________
    // test_createValueType_InstanceOfInteger
    //
    // GIVEN: createValueType is called
    // WHEN:  int type is passed
	//  AND:  object is a string 
    // THEN:  IntegerType instance is returned
    //___________________________________________
	@Test
	public void test_createValueType_InstanceOfInteger() throws ValueTypeNotFoundException {
		//Arrange
		String type = "int";
		Object obj = "-1";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertTrue(valueType instanceof IntegerType);
	}
	
	
	//___________________________________________
    // test_createValueType_StringType
    //
    // GIVEN: createValueType is called
    // WHEN:  String type is passed
	//  AND:  object is a string 
    // THEN:  Value is returned as correct string
    //___________________________________________
	@Test
	public void test_createValueType_StringType() throws ValueTypeNotFoundException {
		//Arrange
		String type = "String";
		Object obj = "Hello World!";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertEquals("Hello World!", valueType.getValue());
	}
	
	
	//___________________________________________
    // test_createValueType_InstanceOfString
    //
    // GIVEN: createValueType is called
    // WHEN:  String type is passed
	//  AND:  object is a string 
    // THEN:  StringType instance is returned
    //___________________________________________
	@Test
	public void test_createValueType_InstanceOfString() throws ValueTypeNotFoundException {
		//Arrange
		String type = "String";
		Object obj = "Hello World!";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertTrue(valueType instanceof StringType);
	}
	
	
	//___________________________________________
    // test_createValueType_BooleanType_True
    //
    // GIVEN: createValueType is called
    // WHEN:  boolean type is passed
	//  AND:  object is a true string 
    // THEN:  Value is returned as correct string
    //___________________________________________
	@Test
	public void test_createValueType_BooleanType_True() throws ValueTypeNotFoundException {
		//Arrange
		String type = "boolean";
		Object obj = "true";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertEquals(true, valueType.getValue());
	}
	
	
	//___________________________________________
    // test_createValueType_BooleanType_False
    //
    // GIVEN: createValueType is called
    // WHEN:  boolean type is passed
	//  AND:  object is a false string 
    // THEN:  Value is returned as correct string
    //___________________________________________
	@Test
	public void test_createValueType_BooleanType_False() throws ValueTypeNotFoundException {
		//Arrange
		String type = "boolean";
		Object obj = "false";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertEquals(false, valueType.getValue());
	}
	
	
	//___________________________________________
    // test_createValueType_InstanceOfBoolean
    //
    // GIVEN: createValueType is called
    // WHEN:  Boolean type is passed
	//  AND:  object is a string 
    // THEN:  BooleanType instance is returned
    //___________________________________________
	@Test
	public void test_createValueType_InstanceOfBoolean() throws ValueTypeNotFoundException {
		//Arrange
		String type = "boolean";
		Object obj = "true";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertTrue(valueType instanceof BooleanType);
	}
	
	
	//___________________________________________
    // test_createValueType_FloatType
    //
    // GIVEN: createValueType is called
    // WHEN:  Float type is passed
	//  AND:  object is a string 
    // THEN:  Value is returned as correct string
    //___________________________________________
	@Test
	public void test_createValueType_FloatType() throws ValueTypeNotFoundException {
		//Arrange
		String type = "float";
		Object obj = "3.14F";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertEquals(3.14F, valueType.getValue());
	}
	
	
	//___________________________________________
    // test_createValueType_InstanceOfFloat
    //
    // GIVEN: createValueType is called
    // WHEN:  Float type is passed
	//  AND:  object is a string 
    // THEN:  FloatType instance is returned
    //___________________________________________
	@Test
	public void test_createValueType_InstanceOfFloat() throws ValueTypeNotFoundException {
		//Arrange
		String type = "float";
		Object obj = "3.14F";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertTrue(valueType instanceof FloatType);
	}
	
	
	//___________________________________________
    // test_createValueType_LongType
    //
    // GIVEN: createValueType is called
    // WHEN:  Long type is passed
	//  AND:  object is a string 
    // THEN:  Value is returned as correct string
    //___________________________________________
	@Test
	public void test_createValueType_LongType() throws ValueTypeNotFoundException {
		//Arrange
		String type = "long";
		Object obj = "9990449935";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertEquals(9990449935L, valueType.getValue());
	}
	
	
	//___________________________________________
    // test_createValueType_InstanceOfLong
    //
    // GIVEN: createValueType is called
    // WHEN:  Long type is passed
	//  AND:  object is a string 
    // THEN:  LongType instance is returned
    //___________________________________________
	@Test
	public void test_createValueType_InstanceOfLong() throws ValueTypeNotFoundException {
		//Arrange
		String type = "long";
		Object obj = "9990449935";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertTrue(valueType instanceof LongType);
	}
	
	
	//___________________________________________
    // test_createValueType_DoubleType
    //
    // GIVEN: createValueType is called
    // WHEN:  Double type is passed
	//  AND:  object is a string 
    // THEN:  Value is returned as correct string
    //___________________________________________
	@Test
	public void test_createValueType_DoubleType() throws ValueTypeNotFoundException {
		//Arrange
		String type = "double";
		Object obj = "7.123123D";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertEquals(7.123123D, valueType.getValue());
	}
	
	
	//___________________________________________
    // test_createValueType_InstanceOfDouble
    //
    // GIVEN: createValueType is called
    // WHEN:  Double type is passed
	//  AND:  object is a string 
    // THEN:  DoubleType instance is returned
    //___________________________________________
	@Test
	public void test_createValueType_InstanceOfDouble() throws ValueTypeNotFoundException {
		//Arrange
		String type = "double";
		Object obj = "7.123123D";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertTrue(valueType instanceof DoubleType);
	}
	
	
	//___________________________________________
    // test_createValueType_CharType
    //
    // GIVEN: createValueType is called
    // WHEN:  Char type is passed
	//  AND:  object is a string 
    // THEN:  Value is returned as correct string
    //___________________________________________
	@Test
	public void test_createValueType_CharType() throws ValueTypeNotFoundException {
		//Arrange
		String type = "char";
		Object obj = "a";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertEquals('a', valueType.getValue());
	}
	
	
	//___________________________________________
    // test_createValueType_InstanceOfChar
    //
    // GIVEN: createValueType is called
    // WHEN:  Char type is passed
	//  AND:  object is a string 
    // THEN:  CharType instance is returned
    //___________________________________________
	@Test
	public void test_createValueType_InstanceOfChar() throws ValueTypeNotFoundException {
		//Arrange
		String type = "char";
		Object obj = "a";
		
		//Act
		ValueType valueType = ValueTypeFactory.createValueType(type, obj);
		
		//Assert
		assertTrue(valueType instanceof CharType);
	}
	
	
	//______________________________________________
    // test_createValueType_ValueTypeNotFound
    //
    // GIVEN: createValueType is called
    // WHEN:  invalid type is passed
	//  AND:  object is a string 
    // THEN:  ValueTypeNotFoundException is returned
    //______________________________________________
	@Test
	public void test_createValueType_ValueTypeNotFound() throws ValueTypeNotFoundException {
		//Arrange
		String type = "Invalid";
		Object obj = "402";

		//Act
		Exception exception = assertThrows(ValueTypeNotFoundException.class, () -> {
			ValueTypeFactory.createValueType(type, obj);
		});
		
		String expectedMessage = "Invalid DSL value type";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
