package com.dsl.tests.logic;

import com.dsl.logic.annotations.AnnotationsHandler;
import com.dsl.logic.annotations.IAnnotationsHandler;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import gastmappers.exceptions.UnsupportedLanguageException;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


public class AnnotationsHandlerTests {

	
	private IAnnotationsHandler handler = new AnnotationsHandler();
	
	
	//___________________________________________
    // test_createTestAnnotation_Java_NotNull
    //
    // GIVEN: Java language is used
    // WHEN:  createTestAnnotation is called
    // THEN:  Result is not null
    //___________________________________________
	@Test
	public void test_createTestAnnotation_Java_NotNull() throws UnsupportedLanguageException {
		// Arrange
		String language = "Java";
		
		// Act
		AnnotationModifier modifier = handler.createTestAnnotation(language);
		
		// Assert
		assertNotNull(modifier);
	}
	
	
	//___________________________________________
    // test_createTestAnnotation_CSharp_NotNull
    //
    // GIVEN: CSharp language is used
    // WHEN:  createTestAnnotation is called
    // THEN:  Result is not null
    //___________________________________________
	@Test
	public void test_createTestAnnotation_CSharp_NotNull() throws UnsupportedLanguageException {
		// Arrange
		String language = "CSharp";
		
		// Act
		AnnotationModifier modifier = handler.createTestAnnotation(language);
		
		// Assert
		assertNotNull(modifier);
	}
	
	
	//___________________________________________
    // test_createTestAnnotation_Python_NotNull
    //
    // GIVEN: Python language is used
    // WHEN:  createTestAnnotation is called
    // THEN:  Result is not null
    //___________________________________________
	@Test
	public void test_createTestAnnotation_Python_NotNull() throws UnsupportedLanguageException {
		// Arrange
		String language = "Python";
		
		// Act
		AnnotationModifier modifier = handler.createTestAnnotation(language);
		
		// Assert
		assertNotNull(modifier);
	}
	
	
	
	
	//___________________________________________
    // test_createTestAnnotation_Java_TestName
    //
    // GIVEN: Java language is used
    // WHEN:  createTestAnnotation is called
    // THEN:  Result has Test name
    //___________________________________________
	@Test
	public void test_createTestAnnotation_Java_TestName() throws UnsupportedLanguageException {
		// Arrange
		String language = "Java";
		
		// Act
		AnnotationModifier modifier = handler.createTestAnnotation(language);
		
		// Assert
		assertEquals("Test", modifier.getModifier());
	}
	
	
	//___________________________________________
    // test_createTestAnnotation_CSharp_TestName
    //
    // GIVEN: CSharp language is used
    // WHEN:  createTestAnnotation is called
    // THEN:  Result has TestMethod name
    //___________________________________________
	@Test
	public void test_createTestAnnotation_CSharp_TestName() throws UnsupportedLanguageException {
		// Arrange
		String language = "CSharp";
		
		// Act
		AnnotationModifier modifier = handler.createTestAnnotation(language);
		
		// Assert
		assertEquals("TestMethod", modifier.getModifier());
	}
	
	
	
	//_______________________________________________________
    // test_createTestAnnotation_UnsupportedLanguageException
    //
    // GIVEN: RPG language is used
    // WHEN:  createTestAnnotation is called
    // THEN:  execution throw an exception
    //_______________________________________________________
	@Test
	public void test_AnnotationModifier_UnsupportedLanguageException() throws UnsupportedLanguageException {
		// Arrange
		String language = "RPG";
		
		// Act
		Exception exception = assertThrows(UnsupportedLanguageException.class, () -> {
			handler.createTestAnnotation(language);
		});
		
		String expectedMessage = "The selected language is unsupported yet.";
		String actualMessage = exception.getMessage();
		
		// Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	//_______________________________________________________
    // test_createTestAnnotation_UnsupportedLanguageException
    //
    // GIVEN: C++ language is used
    // WHEN:  createTestAnnotation is called
    // THEN:  execution throw an exception
    //_______________________________________________________
	@Test
	public void test_AnnotationModifier_CPP_UnsupportedLanguageException() throws UnsupportedLanguageException {
		// Arrange
		String language = "C++";
		
		// Act
		Exception exception = assertThrows(UnsupportedLanguageException.class, () -> {
			handler.createTestAnnotation(language);
		});
		
		String expectedMessage = "The selected language is unsupported yet.";
		String actualMessage = exception.getMessage();
		
		// Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
}
