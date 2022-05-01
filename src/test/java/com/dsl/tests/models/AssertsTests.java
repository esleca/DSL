package com.dsl.tests.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.asserts.types.*;


public class AssertsTests {

	//_____________________________________________
    // test_getName_AreEqual
    //
    // GIVEN: getName parent function is called
    // WHEN:  AreEqual instance is executed
    // THEN:  assertName will be 
    //_____________________________________________
	@Test
	public void test_getName_AreEqual() {
		//Arrange
		AssertType assertType = new AreEqual();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("areEqual", assertName);
	}
	
	
	//_____________________________________________
    // test_getName_AreNotEqual
    //
    // GIVEN: getName parent function is called
    // WHEN:  AreNotEqual instance is executed
    // THEN:  assertName will be areNotEqual
    //_____________________________________________
	@Test
	public void test_getName_AreNotEqual() {
		//Arrange
		AssertType assertType = new AreNotEqual();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("areNotEqual", assertName);
	}
	
	
	//_____________________________________________
    // test_getName_IsFalse
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsFalse instance is executed
    // THEN:  assertName will be isFalse
    //_____________________________________________
	@Test
	public void test_getName_IsFalse() {
		//Arrange
		AssertType assertType = new IsFalse();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("isFalse", assertName);
	}
	
	
	//_____________________________________________
    // test_getName_IsTrue
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsTrue instance is executed
    // THEN:  assertName will be isTrue
    //_____________________________________________
	@Test
	public void test_getName_IsTrue() {
		//Arrange
		AssertType assertType = new IsTrue();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("isTrue", assertName);
	}
	
	
	//_____________________________________________
    // test_getName_IsInstanceOfType
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsInstanceOfType instance is executed
    // THEN:  assertName will be isInstanceOfType
    //_____________________________________________
	@Test
	public void test_getName_IsInstanceOfType() {
		//Arrange
		AssertType assertType = new IsInstanceOfType();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("isInstanceOfType", assertName);
	}
	
	
	//_____________________________________________
    // test_getName_IsNotNull
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsNotNull instance is executed
    // THEN:  assertName will be isNotNull
    //_____________________________________________
	@Test
	public void test_getName_IsNotNull() {
		//Arrange
		AssertType assertType = new IsNotNull();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("isNotNull", assertName);
	}
	
	
	//_____________________________________________
    // test_getName_IsNull
    //
    // GIVEN: getName parent function is called
    // WHEN:  IsNull instance is executed
    // THEN:  assertName will be isNull
    //_____________________________________________
	@Test
	public void test_getName_IsNull() {
		//Arrange
		AssertType assertType = new IsNull();
		
		//Act
		String assertName = assertType.getName();
		
		//Assert
		assertEquals("isNull", assertName);
	}
	
	
	//_____________________________________________
    // test_getName_AssertTypePair_Size
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  arguments contain 2 elements
    //_____________________________________________
	@Test
	public void test_getName_AssertTypePair_Size() {
		//Arrange
		AssertType assertType = new AreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		
		//Assert
		assertEquals(2, arguments.size());
	}
	
	
	//_____________________________________________
    // test_getName_AssertTypePair_Expected
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  first argument will be expected
    //_____________________________________________
	@Test
	public void test_getName_AssertTypePair_Expected() {
		//Arrange
		AssertType assertType = new AreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument firstArg = arguments.get(0);
		
		//Assert
		assertEquals("expected", firstArg.getValue());
	}
	
	
	//_____________________________________________
    // test_getName_AssertTypePair_Result
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypePair instance is executed
    // THEN:  second argument will be result
    //_____________________________________________
	@Test
	public void test_getName_AssertTypePair_Result() {
		//Arrange
		AssertType assertType = new AreEqual();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument secondArg = arguments.get(1);
		
		//Assert
		assertEquals("result", secondArg.getValue());
	}
	
	
	//_____________________________________________
    // test_getName_AssertTypeSingle_Size
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypeSingle instance is executed
    // THEN:  arguments contain 1 element
    //_____________________________________________
	@Test
	public void test_getName_AssertTypeSingle_Size() {
		//Arrange
		AssertType assertType = new IsTrue();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		
		//Assert
		assertEquals(1, arguments.size());
	}
	
	
	//_____________________________________________
    // test_getName_AssertTypeSingle_Result
    //
    // GIVEN: getAssertArguments function is called
    // WHEN:  AssertTypeSingle instance is executed
    // THEN:  only argument will be result
    //_____________________________________________
	@Test
	public void test_getName_AssertTypeSingle_Result() {
		//Arrange
		AssertType assertType = new IsTrue();
		
		//Act
		ArrayList<FunctionArgument> arguments = assertType.getAssertArguments();
		FunctionArgument argument = arguments.get(0);
		
		//Assert
		assertEquals("result", argument.getValue());
	}
	
}
