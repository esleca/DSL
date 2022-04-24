package com.dsl.factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.models.entities.returns.*;

public class ReturnsFactoryTests {
	
	//___________________________________________
    // test_createPrimitiveReturn_IntegerName
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  int type is passed
    // THEN:  IntegerReturn instance is returned
    //___________________________________________
	@Test
	public void test_createPrimitiveReturn_IntegerName() throws ReturnNotFoundException {
		//Arrange
		String type = "int";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertEquals("int", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createPrimitiveReturn_InstanceOfInteger
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  int type is passed
    // THEN:  Return is instance of IntegerReturn
    //______________________________________________
	@Test
	public void test_createPrimitiveReturn_InstanceOfInteger() throws ReturnNotFoundException {
		//Arrange
		String type = "int";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof IntegerReturn);
	}
	
	
	//___________________________________________
    // test_createPrimitiveReturn_StringName
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  String type is passed
    // THEN:  return name returned is String
    //___________________________________________
	@Test
	public void test_createPrimitiveReturn_StringName() throws ReturnNotFoundException {
		//Arrange
		String type = "String";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertEquals("String", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createPrimitiveReturn_InstanceOfString
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  String type is passed
    // THEN:  Return is instance of StringReturn
    //______________________________________________
	@Test
	public void test_createPrimitiveReturn_InstanceOfString() throws ReturnNotFoundException {
		//Arrange
		String type = "String";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof StringReturn);
	}
	
	
	//___________________________________________
    // test_createPrimitiveReturn_BooleanName
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  boolean type is passed
    // THEN:  return name returned is boolean
    //___________________________________________
	@Test
	public void test_createPrimitiveReturn_BooleanName() throws ReturnNotFoundException {
		//Arrange
		String type = "boolean";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertEquals("boolean", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createPrimitiveReturn_InstanceOfBoolean
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  boolean type is passed
    // THEN:  Return is instance of BooleanReturn
    //______________________________________________
	@Test
	public void test_createPrimitiveReturn_InstanceOfBoolean() throws ReturnNotFoundException {
		//Arrange
		String type = "boolean";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof BooleanReturn);
	}
	
	
	//___________________________________________
    // test_createPrimitiveReturn_FloatName
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  float type is passed
    // THEN:  return name returned is float
    //___________________________________________
	@Test
	public void test_createPrimitiveReturn_FloatName() throws ReturnNotFoundException {
		//Arrange
		String type = "float";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertEquals("float", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createPrimitiveReturn_InstanceOfFloat
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  float type is passed
    // THEN:  Return is instance of FloatReturn
    //______________________________________________
	@Test
	public void test_createPrimitiveReturn_InstanceOfFloat() throws ReturnNotFoundException {
		//Arrange
		String type = "float";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof FloatReturn);
	}
	
	
	//___________________________________________
    // test_createPrimitiveReturn_LongName
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  long type is passed
    // THEN:  return name returned is long
    //___________________________________________
	@Test
	public void test_createPrimitiveReturn_LongName() throws ReturnNotFoundException {
		//Arrange
		String type = "long";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertEquals("long", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createPrimitiveReturn_InstanceOfLong
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  long type is passed
    // THEN:  Return is instance of LongReturn
    //______________________________________________
	@Test
	public void test_createPrimitiveReturn_InstanceOfLong() throws ReturnNotFoundException {
		//Arrange
		String type = "long";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof LongReturn);
	}
	
	
	//___________________________________________
    // test_createPrimitiveReturn_DoubleName
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  double type is passed
    // THEN:  return name returned is double
    //___________________________________________
	@Test
	public void test_createPrimitiveReturn_DoubleName() throws ReturnNotFoundException {
		//Arrange
		String type = "double";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertEquals("double", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createPrimitiveReturn_InstanceOfDouble
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  double type is passed
    // THEN:  Return is instance of DoubleReturn
    //______________________________________________
	@Test
	public void test_createPrimitiveReturn_InstanceOfDouble() throws ReturnNotFoundException {
		//Arrange
		String type = "double";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof DoubleReturn);
	}
	
	
	//___________________________________________
    // test_createPrimitiveReturn_CharName
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  char type is passed
    // THEN:  return name returned is char
    //___________________________________________
	@Test
	public void test_createPrimitiveReturn_CharName() throws ReturnNotFoundException {
		//Arrange
		String type = "char";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertEquals("char", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createPrimitiveReturn_InstanceOfChar
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  char type is passed
    // THEN:  Return is instance of CharReturn
    //______________________________________________
	@Test
	public void test_createPrimitiveReturn_InstanceOfChar() throws ReturnNotFoundException {
		//Arrange
		String type = "char";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof CharReturn);
	}
	
	
	//___________________________________________
    // test_createPrimitiveReturn_VoidName
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  void type is passed
    // THEN:  return name returned is void
    //___________________________________________
	@Test
	public void test_createPrimitiveReturn_VoidName() throws ReturnNotFoundException {
		//Arrange
		String type = "void";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertEquals("void", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createPrimitiveReturn_InstanceOfVoid
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  void type is passed
    // THEN:  Return is instance of VoidReturn
    //______________________________________________
	@Test
	public void test_createPrimitiveReturn_InstanceOfVoid() throws ReturnNotFoundException {
		//Arrange
		String type = "void";
		
		//Act
		Return lReturn = ReturnsFactory.createPrimitiveReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof VoidReturn);
	}
	
	
	//_____________________________________________
    // test_createPrimitiveReturn_NotFoundException
    //
    // GIVEN: createPrimitiveReturn is called
    // WHEN:  invalid type is passed
    // THEN:  ReturnNotFoundException is returned
    //_____________________________________________
	@Test
	public void test_createPrimitiveReturn_NotFoundException() throws ReturnNotFoundException {
		//Arrange
		String type = "invalid";
		
		//Act
		Exception exception = assertThrows(ReturnNotFoundException.class, () -> {
			 ReturnsFactory.createPrimitiveReturn(type);
        });		

		String expectedMessage = "Invalid DSL function return";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	//___________________________________________
    // test_createInstanceReturn_ObjName
    //
    // GIVEN: createInstanceReturn is called
    // WHEN:  objResponse type is passed
    // THEN:  return name returned is objResponse
    //___________________________________________
	@Test
	public void test_createInstanceReturn_ObjName() throws ReturnNotFoundException {
		//Arrange
		String type = "objResponse";
		
		//Act
		Return lReturn = ReturnsFactory.createInstanceReturn(type);
		
		//Assert
		assertEquals("objResponse", lReturn.getName());
	}
	
	
	//______________________________________________
    // test_createInstanceReturn_InstanceOfObj
    //
    // GIVEN: createInstanceReturn is called
    // WHEN:  void type is passed
    // THEN:  Return is instance of InstanceReturn
    //______________________________________________
	@Test
	public void test_createInstanceReturn_InstanceOfObj() throws ReturnNotFoundException {
		//Arrange
		String type = "objResponse";
		
		//Act
		Return lReturn = ReturnsFactory.createInstanceReturn(type);
		
		//Assert
		assertTrue(lReturn instanceof InstanceReturn);
	}
	
	
	//__________________________________________________
    // test_createParameterizedReturn_ParameterizedName
    //
    // GIVEN: createParameterizedReturn is called
    // WHEN:  Parameterized type is passed
    // THEN:  return name returned is Parameterized
    //__________________________________________________
	@Test
	public void test_createParameterizedReturn_ParameterizedName() throws ReturnNotFoundException {
		//Arrange
		String type = "Parameterized";
		ParameterDataType dataType = ReturnsFactory.createParameterDataType();
		
		//Act
		Return lReturn = ReturnsFactory.createParameterizedReturn(type, dataType);
		
		//Assert
		assertTrue(lReturn instanceof ParameterizedReturn);
	}
	
	
	//________________________________________________________
    // test_createParameterizedReturn_InstanceOfParameterized
    //
    // GIVEN: createParameterizedReturn is called
    // WHEN:  Parameterized type is passed
    // THEN:  Return is instance of ParameterizedReturn
    //________________________________________________________
	@Test
	public void test_createParameterizedReturn_InstanceOfParameterized() throws ReturnNotFoundException {
		//Arrange
		String type = "Parameterized";
		ParameterDataType dataType = ReturnsFactory.createParameterDataType();
		
		//Act
		Return lReturn = ReturnsFactory.createParameterizedReturn(type, dataType);
		
		//Assert
		assertTrue(lReturn instanceof ParameterizedReturn);
	}
	
	
	//__________________________________________________
    // test_createParameterizedReturn_NotFoundException
    //
    // GIVEN: createParameterizedReturn is called
    // WHEN:  invalid type is passed
    // THEN:  ReturnNotFoundException is returned
    //___________________________________________________
	@Test
	public void test_createParameterizedReturn_NotFoundException() throws ReturnNotFoundException {
		//Arrange
		String type = "invalid";
		ParameterDataType dataType = ReturnsFactory.createParameterDataType();
		
		//Act
		Exception exception = assertThrows(ReturnNotFoundException.class, () -> {
			 ReturnsFactory.createParameterizedReturn(type, dataType);
        });		

		String expectedMessage = "Invalid DSL function return";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
