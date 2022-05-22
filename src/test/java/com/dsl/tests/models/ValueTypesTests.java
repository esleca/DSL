package com.dsl.tests.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.dsl.models.valuetypes.*;


public class ValueTypesTests {
	
	//_____________________________________________
    // test_getValue_BooleanType_True
    //
    // GIVEN: getValue is called
    // WHEN:  BooleanType instance is executed
	//  AND:  type is set as true
    // THEN:  value will be true
    //_____________________________________________
	@Test
	public void test_getValue_BooleanType_True() {
		//Arrange
		ValueType valueType = new BooleanType();
		valueType.setValue("true");
		
		//Act
		boolean value = (boolean) valueType.getValue();
		
		//Assert
		assertTrue(value);
	}
	
	
	//_____________________________________________
    // test_getValue_BooleanType_False
    //
    // GIVEN: getValue is called
    // WHEN:  BooleanType instance is executed
	//  AND:  type is set as false
    // THEN:  value will be false
    //_____________________________________________
	@Test
	public void test_getValue_BooleanType_False() {
		//Arrange
		ValueType valueType = new BooleanType();
		valueType.setValue("false");
		
		//Act
		boolean value = (boolean) valueType.getValue();
		
		//Assert
		assertFalse(value);
	}
	
	
	//_____________________________________________
    // test_getType_BooleanType
    //
    // GIVEN: getType is called
    // WHEN:  BooleanType instance is executed
    // THEN:  Type will be boolean
    //_____________________________________________
	@Test
	public void test_getType_BooleanType() {
		//Arrange
		ValueType valueType = new BooleanType();
		
		//Act
		String type = valueType.getType();
		
		//Assert
		assertEquals("boolean", type);
	}
	
	
	//_____________________________________________
    // test_getValue_CharType
    //
    // GIVEN: getValue is called
    // WHEN:  CharType instance is executed
    // THEN:  value will be the char given
    //_____________________________________________
	@Test
	public void test_getValue_CharType() {
		//Arrange
		ValueType valueType = new CharType();
		valueType.setValue("a");
		
		//Act
		char value = (char) valueType.getValue();
		
		//Assert
		assertEquals('a', value);
	}
	
	
	//_____________________________________________
    // test_getType_CharType
    //
    // GIVEN: getType is called
    // WHEN:  CharType instance is executed
    // THEN:  Type will be boolean
    //_____________________________________________
	@Test
	public void test_getType_CharType() {
		//Arrange
		ValueType valueType = new CharType();
		
		//Act
		String type = valueType.getType();
		
		//Assert
		assertEquals("char", type);
	}
	
	
	//_____________________________________________
    // test_getValue_DoubleType
    //
    // GIVEN: getValue is called
    // WHEN:  DoubleType instance is executed
    // THEN:  value will be the double given
    //_____________________________________________
	@Test
	public void test_getValue_DoubleType() {
		//Arrange
		ValueType valueType = new DoubleType();
		valueType.setValue("3.1482734");
		
		//Act
		double value = (double) valueType.getValue();
		
		//Assert
		assertEquals(3.1482734, value, 0);
	}
	
	
	//_____________________________________________
    // test_getType_DoubleType
    //
    // GIVEN: getType is called
    // WHEN:  DoubleType instance is executed
    // THEN:  Type will be Double
    //_____________________________________________
	@Test
	public void test_getType_DoubleType() {
		//Arrange
		ValueType valueType = new DoubleType();
		
		//Act
		String type = valueType.getType();
		
		//Assert
		assertEquals("double", type);
	}
	
	
	//_____________________________________________
    // test_getValue_FloatType
    //
    // GIVEN: getValue is called
    // WHEN:  FloatType instance is executed
    // THEN:  value will be the float given
    //_____________________________________________
	@Test
	public void test_getValue_FloatType() {
		//Arrange
		ValueType valueType = new FloatType();
		valueType.setValue("3.14F");
		
		//Act
		float value = (float) valueType.getValue();
		
		//Assert
		assertEquals(3.14F, value, 0);
	}
	
	
	//_____________________________________________
    // test_getType_FloatType
    //
    // GIVEN: getType is called
    // WHEN:  FloatType instance is executed
    // THEN:  Type will be Float
    //_____________________________________________
	@Test
	public void test_getType_FloatType() {
		//Arrange
		ValueType valueType = new FloatType();
		
		//Act
		String type = valueType.getType();
		
		//Assert
		assertEquals("float", type);
	}
	
	
	//_____________________________________________
    // test_getValue_IntegerType
    //
    // GIVEN: getValue is called
    // WHEN:  IntegerType instance is executed
    // THEN:  value will be the integer given
    //_____________________________________________
	@Test
	public void test_getValue_IntegerType() {
		//Arrange
		ValueType valueType = new IntegerType();
		valueType.setValue("7");
		
		//Act
		int value = (int) valueType.getValue();
		
		//Assert
		assertEquals(7, value);
	}
	
	
	//_____________________________________________
    // test_getType_IntegerType
    //
    // GIVEN: getType is called
    // WHEN:  IntegerType instance is executed
    // THEN:  Type will be int
    //_____________________________________________
	@Test
	public void test_getType_IntegerType() {
		//Arrange
		ValueType valueType = new IntegerType();
		
		//Act
		String type = valueType.getType();
		
		//Assert
		assertEquals("int", type);
	}
	
	
	//_____________________________________________
    // test_getValue_LongType
    //
    // GIVEN: getValue is called
    // WHEN:  LongType instance is executed
    // THEN:  value will be the long given
    //_____________________________________________
	@Test
	public void test_getValue_LongType() {
		//Arrange
		ValueType valueType = new LongType();
		valueType.setValue("999999999");
		
		//Act
		long value = (long) valueType.getValue();
		
		//Assert
		assertEquals(999999999, value);
	}
	
	
	//_____________________________________________
    // test_getType_LongType
    //
    // GIVEN: getType is called
    // WHEN:  LongType instance is executed
    // THEN:  Type will be Long
    //_____________________________________________
	@Test
	public void test_getType_LongType() {
		//Arrange
		ValueType valueType = new LongType();
		
		//Act
		String type = valueType.getType();
		
		//Assert
		assertEquals("long", type);
	}
	
	
	//_____________________________________________
    // test_getValue_StringType
    //
    // GIVEN: getValue is called
    // WHEN:  StringType instance is executed
    // THEN:  value will be the String given
    //_____________________________________________
	@Test
	public void test_getValue_StringType() {
		//Arrange
		ValueType valueType = new StringType();
		valueType.setValue("text");
		
		//Act
		String value = (String) valueType.getValue();
		
		//Assert
		assertEquals("text", value);
	}
	
	
	//_____________________________________________
    // test_getType_StringType
    //
    // GIVEN: getType is called
    // WHEN:  StringType instance is executed
    // THEN:  Type will be String
    //_____________________________________________
	@Test
	public void test_getType_StringType() {
		//Arrange
		ValueType valueType = new StringType();
		
		//Act
		String type = valueType.getType();
		
		//Assert
		assertEquals("String", type);
	}
	
	
	//_____________________________________________
    // test_getValue_NotNull
    //
    // GIVEN: getValue is called
    // WHEN:  setValue was called previously
    // THEN:  value will not be null
    //_____________________________________________
	@Test
	public void test_getValue_NotNull() {
		//Arrange
		ValueType valueType = new StringType();
		valueType.setValue("String");
		
		//Act
		String value = (String) valueType.getValue();
		
		//Assert
		assertNotNull(value);
	}
	
	
	//_____________________________________________
    // test_getValue_Null
    //
    // GIVEN: getValue is called
    // WHEN:  setValue was not called previously
    // THEN:  value will be null
    //_____________________________________________
	@Test
	public void test_getValue_Null() {
		//Arrange
		ValueType valueType = new StringType();
		
		//Act
		String value = (String) valueType.getValue();
		
		//Assert
		assertNull(value);
	}
	
}
