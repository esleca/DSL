package com.dsl.tests.models;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.asserts.types.*;
import com.dsl.models.unittests.asserts.types.java.*;
import com.dsl.models.unittests.asserts.types.csharp.*;


public class AssertsTests {
	
	// JAVA LANGUAGE ASSERTS
	

	//_____________________________________________
    // test_Java_getName_AreEqual
    //
    // GIVEN: getName parent function is called
    // WHEN:  AreEqual instance is executed
    // THEN:  assertName will be 
    //_____________________________________________
	@Test
	public void test_Java_getName_AreEqual() {
		//Arrange
		AssertType assertType = new JavaAreEqual();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("assertEquals", assertName);
	}
	
	
	//_____________________________________________
    // test_Java_getName_AreNotEqual
    //
    // GIVEN: getName parent function is called
    // WHEN:  AreNotEqual instance is executed
    // THEN:  assertName will be areNotEqual
    //_____________________________________________
	@Test
	public void test_Java_getName_AreNotEqual() {
		//Arrange
		AssertType assertType = new JavaAreNotEqual();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("assertNotEquals", assertName);
	}
	
	
	//_____________________________________________
    // test_Java_getName_IsFalse
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsFalse instance is executed
    // THEN:  assertName will be isFalse
    //_____________________________________________
	@Test
	public void test_Java_getName_IsFalse() {
		//Arrange
		AssertType assertType = new JavaIsFalse();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("assertFalse", assertName);
	}
	
	
	//_____________________________________________
    // test_Java_getName_IsTrue
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsTrue instance is executed
    // THEN:  assertName will be isTrue
    //_____________________________________________
	@Test
	public void test_Java_getName_IsTrue() {
		//Arrange
		AssertType assertType = new JavaIsTrue();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("assertTrue", assertName);
	}
	
	
	//_____________________________________________
    // test_Java_getName_IsInstanceOfType
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsInstanceOfType instance is executed
    // THEN:  assertName will be isInstanceOfType
    //_____________________________________________
	@Test
	public void test_Java_getName_IsInstanceOfType() {
		//Arrange
		AssertType assertType = new JavaIsInstanceOfType();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("assertInstanceOfType", assertName);
	}
	
	
	//_____________________________________________
    // test_Java_getName_IsNotNull
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsNotNull instance is executed
    // THEN:  assertName will be isNotNull
    //_____________________________________________
	@Test
	public void test_Java_getName_IsNotNull() {
		//Arrange
		AssertType assertType = new JavaIsNotNull();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("assertNotNull", assertName);
	}
	
	
	//_____________________________________________
    // test_Java_getName_IsNull
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsNull instance is executed
    // THEN:  assertName will be isNull
    //_____________________________________________
	@Test
	public void test_Java_getName_IsNull() {
		//Arrange
		AssertType assertType = new JavaIsNull();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("assertNull", assertName);
	}
	
	
	//_____________________________________________
    // test_Java_getName_AssertTypePair_Size
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  arguments contain 2 elements
    //_____________________________________________
	@Test
	public void test_Java_getName_AssertTypePair_Size() {
		//Arrange
		AssertType assertType = new JavaAreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		
		//Assert
		assertEquals(2, arguments.size());
	}
	
	
	//_____________________________________________
    // test_Java_getName_AssertTypePair_Expected
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  first argument will be expected
    //_____________________________________________
	@Test
	public void test_Java_getName_AssertTypePair_Expected() {
		//Arrange
		AssertType assertType = new JavaAreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument firstArg = arguments.get(0);
		
		//Assert
		assertEquals("expected", firstArg.getValue().toString());
	}
	
	
	//_____________________________________________
    // test_Java_getName_AssertTypePair_Result
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  second argument will be result
    //_____________________________________________
	@Test
	public void test_Java_getName_AssertTypePair_Result() {
		//Arrange
		AssertType assertType = new JavaAreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument secondArg = arguments.get(1);
		
		//Assert
		assertEquals("result", secondArg.getValue().toString());
	}
	
	
	//_____________________________________________
    // test_Java_getName_AssertTypeSingle_Size
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypeSingle instance is executed
    // THEN:  arguments contain 1 element
    //_____________________________________________
	@Test
	public void test_Java_getName_AssertTypeSingle_Size() {
		//Arrange
		AssertType assertType = new JavaIsTrue();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		
		//Assert
		assertEquals(1, arguments.size());
	}
	
	
	//_____________________________________________
    // test_Java_getName_AssertTypeSingle_Result
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypeSingle instance is executed
    // THEN:  only argument will be result
    //_____________________________________________
	@Test
	public void test_Java_getName_AssertTypeSingle_Result() {
		//Arrange
		AssertType assertType = new JavaIsTrue();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument argument = arguments.get(0);
		
		//Assert
		assertEquals("result", argument.getValue().toString());
	}
	
	
	
	
	
	
	
	// CSHARP LANGUAGE ASSERTS

	//_____________________________________________
    // test_CSharp_getName_AreEqual
    //
    // GIVEN: getName parent function is called
    // WHEN:  AreEqual instance is executed
    // THEN:  assertName will be 
    //_____________________________________________
	@Test
	public void test_CSharp_getName_AreEqual() {
		//Arrange
		AssertType assertType = new CSharpAreEqual();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("AreEqual", assertName);
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_AreNotEqual
    //
    // GIVEN: getName parent function is called
    // WHEN:  AreNotEqual instance is executed
    // THEN:  assertName will be areNotEqual
    //_____________________________________________
	@Test
	public void test_CSharp_getName_AreNotEqual() {
		//Arrange
		AssertType assertType = new CSharpAreNotEqual();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("AreNotEqual", assertName);
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_IsFalse
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsFalse instance is executed
    // THEN:  assertName will be isFalse
    //_____________________________________________
	@Test
	public void test_CSharp_getName_IsFalse() {
		//Arrange
		AssertType assertType = new CSharpIsFalse();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("IsFalse", assertName);
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_IsTrue
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsTrue instance is executed
    // THEN:  assertName will be isTrue
    //_____________________________________________
	@Test
	public void test_CSharp_getName_IsTrue() {
		//Arrange
		AssertType assertType = new CSharpIsTrue();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("IsTrue", assertName);
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_IsInstanceOfType
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsInstanceOfType instance is executed
    // THEN:  assertName will be isInstanceOfType
    //_____________________________________________
	@Test
	public void test_CSharp_getName_IsInstanceOfType() {
		//Arrange
		AssertType assertType = new CSharpIsInstanceOfType();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("IsInstanceOfType", assertName);
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_IsNotNull
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsNotNull instance is executed
    // THEN:  assertName will be isNotNull
    //_____________________________________________
	@Test
	public void test_CSharp_getName_IsNotNull() {
		//Arrange
		AssertType assertType = new CSharpIsNotNull();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("IsNotNull", assertName);
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_IsNull
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsNull instance is executed
    // THEN:  assertName will be isNull
    //_____________________________________________
	@Test
	public void test_CSharp_getName_IsNull() {
		//Arrange
		AssertType assertType = new CSharpIsNull();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("IsNull", assertName);
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_AssertTypePair_Size
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  arguments contain 2 elements
    //_____________________________________________
	@Test
	public void test_CSharp_getName_AssertTypePair_Size() {
		//Arrange
		AssertType assertType = new CSharpAreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		
		//Assert
		assertEquals(2, arguments.size());
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_AssertTypePair_Expected
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  first argument will be expected
    //_____________________________________________
	@Test
	public void test_CSharp_getName_AssertTypePair_Expected() {
		//Arrange
		AssertType assertType = new CSharpAreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument firstArg = arguments.get(0);
		
		//Assert
		assertEquals("expected", firstArg.getValue().toString());
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_AssertTypePair_Result
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  second argument will be result
    //_____________________________________________
	@Test
	public void test_CSharp_getName_AssertTypePair_Result() {
		//Arrange
		AssertType assertType = new CSharpAreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument secondArg = arguments.get(1);
		
		//Assert
		assertEquals("result", secondArg.getValue().toString());
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_AssertTypeSingle_Size
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypeSingle instance is executed
    // THEN:  arguments contain 1 element
    //_____________________________________________
	@Test
	public void test_CSharp_getName_AssertTypeSingle_Size() {
		//Arrange
		AssertType assertType = new CSharpIsTrue();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		
		//Assert
		assertEquals(1, arguments.size());
	}
	
	
	//_____________________________________________
    // test_CSharp_getName_AssertTypeSingle_Result
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypeSingle instance is executed
    // THEN:  only argument will be result
    //_____________________________________________
	@Test
	public void test_CSharp_getName_AssertTypeSingle_Result() {
		//Arrange
		AssertType assertType = new CSharpIsTrue();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument argument = arguments.get(0);
		
		//Assert
		assertEquals("result", argument.getValue().toString());
	}
	
}
