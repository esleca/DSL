package com.dsl.exceptions;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ExceptionsTests {

	//______________________________________________
    // test_AssertNotFoundException_Message
    //
    // GIVEN: AssertNotFoundException is triggered
    // THEN:  Correct exception message is mapped
    //______________________________________________
	@Test
	public void test_AssertNotFoundException_Message() {
		//Arrange and act
		Exception exception = new AssertNotFoundException();
		
		String expectedMessage = "Invalid DSL unit test assert";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	

	//______________________________________________
    // test_ModifierNotFoundException_Message
    //
    // GIVEN: ModifierNotFoundException is triggered
    // THEN:  Correct exception message is mapped
    //______________________________________________
	@Test
	public void test_ModifierNotFoundException_Message() {
		//Arrange and act
		Exception exception = new ModifierNotFoundException();
		
		String expectedMessage = "Invalid DSL function modifier";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	

	//______________________________________________
    // test_ReturnNotFoundException_Message
    //
    // GIVEN: ReturnNotFoundException is triggered
    // THEN:  Correct exception message is mapped
    //______________________________________________
	@Test
	public void test_ReturnNotFoundException_Message() {
		//Arrange and act
		Exception exception = new ReturnNotFoundException();
		
		String expectedMessage = "Invalid DSL function return";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	

	//______________________________________________
    // test_ValueTypeNotFoundException_Message
    //
    // GIVEN: ValueTypeNotFoundException is triggered
    // THEN:  Correct exception message is mapped
    //______________________________________________
	@Test
	public void test_ValueTypeNotFoundException_Message() {
		//Arrange and act
		Exception exception = new ValueTypeNotFoundException();
		
		String expectedMessage = "Invalid DSL value type";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
