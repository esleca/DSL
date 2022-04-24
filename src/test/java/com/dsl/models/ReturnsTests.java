package com.dsl.models;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.dsl.models.entities.returns.*;

public class ReturnsTests {
	
	//_____________________________________________
    // test_getName_BooleanReturn
    //
    // GIVEN: getName is called
    // WHEN:  BooleanReturn instance is executed
    // THEN:  return name will be boolean
    //_____________________________________________
	@Test
	public void test_getName_BooleanReturn() {
		//Arrange
		Return ret = new BooleanReturn();
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("boolean", returnName);
	}
	
	
	//_____________________________________________
    // test_getName_CharReturn
    //
    // GIVEN: getName is called
    // WHEN:  CharReturn instance is executed
    // THEN:  return name will be char
    //_____________________________________________
	@Test
	public void test_getName_CharReturn() {
		//Arrange
		Return ret = new CharReturn();
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("char", returnName);
	}
	
	
	//_____________________________________________
    // test_getName_DoubleReturn
    //
    // GIVEN: getName is called
    // WHEN:  DoubleReturn instance is executed
    // THEN:  return name will be double
    //_____________________________________________
	@Test
	public void test_getName_DoubleReturn() {
		//Arrange
		Return ret = new DoubleReturn();
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("double", returnName);
	}
	
	
	//_____________________________________________
    // test_getName_FloatReturn
    //
    // GIVEN: getName is called
    // WHEN:  FloatReturn instance is executed
    // THEN:  return name will be float
    //_____________________________________________
	@Test
	public void test_getName_FloatReturn() {
		//Arrange
		Return ret = new FloatReturn();
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("float", returnName);
	}
	
	
	//_____________________________________________
    // test_getName_InstanceReturn
    //
    // GIVEN: getName is called
    // WHEN:  InstanceReturn instance is executed
    // THEN:  return name will be the object name
    //_____________________________________________
	@Test
	public void test_getName_InstanceReturn() {
		//Arrange
		Return ret = new InstanceReturn("objectName");
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("objectName", returnName);
	}
	
	
	//_____________________________________________
    // test_getName_IntegerReturn
    //
    // GIVEN: getName is called
    // WHEN:  IntegerReturn instance is executed
    // THEN:  return name will be int
    //_____________________________________________
	@Test
	public void test_getName_IntegerReturn() {
		//Arrange
		Return ret = new IntegerReturn();
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("int", returnName);
	}
	
	
	//_____________________________________________
    // test_getName_LongReturn
    //
    // GIVEN: getName is called
    // WHEN:  LongReturn instance is executed
    // THEN:  return name will be long
    //_____________________________________________
	@Test
	public void test_getName_LongReturn() {
		//Arrange
		Return ret = new LongReturn();
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("long", returnName);
	}
	
	
	//________________________________________________
    // test_getName_ParameterizedReturn
    //
    // GIVEN: getName is called
    // WHEN:  ParameterizedReturn instance is executed
    // THEN:  return name will be Parameterized
    //________________________________________________
	@Test
	public void test_getName_ParameterizedReturn() {
		//Arrange
		ParameterDataType dataType = new ParameterDataType();
		Return ret = new ParameterizedReturn(dataType);
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("Parameterized", returnName);
	}
	
	
	//____________________________________________________
    // test_getName_ParameterizedReturn_DataTypeName
    //
    // GIVEN: getParameterDataType is called
    // WHEN:  The function return an ArrayList<Integer>
    // THEN:  Parameter data type name will be ArrayList
    //____________________________________________________
	@Test
	public void test_getName_ParameterizedReturn_DataTypeName() {
		//Arrange
		ParameterDataType dataType = new ParameterDataType();
		dataType.setName("ArrayList");
		
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("Integer");
		
		dataType.setArgumentType(arguments);
		ParameterizedReturn ret = new ParameterizedReturn(dataType);
		
		//Act
		ParameterDataType parameterDataType = ret.getParameterDataType();
		
		//Assert
		assertEquals("ArrayList", parameterDataType.getName());
	}
	
	
	//___________________________________________________
    // test_getName_ParameterizedReturn_DataTypeName
    //
    // GIVEN: getParameterDataType is called
    // WHEN:  The function return an ArrayList<Integer>
    // THEN:  Parameter data type args will be Integer
    //___________________________________________________
	@Test
	public void test_getName_ParameterizedReturn_DataTypeArguments() {
		//Arrange
		ParameterDataType dataType = new ParameterDataType();
		dataType.setName("ArrayList");
		
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("Integer");
		
		dataType.setArgumentType(arguments);
		ParameterizedReturn ret = new ParameterizedReturn(dataType);
		
		//Act
		ParameterDataType parameterDataType = ret.getParameterDataType();
		
		//Assert
		assertEquals("Integer", parameterDataType.getArgumentTypes().get(0));
	}
	
	
	//_____________________________________________
    // test_getName_StringReturn
    //
    // GIVEN: getName is called
    // WHEN:  StringReturn instance is executed
    // THEN:  return name will be String
    //_____________________________________________
	@Test
	public void test_getName_StringReturn() {
		//Arrange
		Return ret = new StringReturn();
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("String", returnName);
	}
	
	
	//_____________________________________________
    // test_getName_VoidReturn
    //
    // GIVEN: getName is called
    // WHEN:  VoidReturn instance is executed
    // THEN:  return name will be void
    //_____________________________________________
	@Test
	public void test_getName_VoidReturn() {
		//Arrange
		Return ret = new VoidReturn();
		
		//Act
		String returnName = ret.getName();
		
		//Assert
		assertEquals("void", returnName);
	}
	
}
