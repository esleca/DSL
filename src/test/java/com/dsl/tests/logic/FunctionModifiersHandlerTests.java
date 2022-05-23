package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.dsl.logic.annotations.AnnotationsHandler;
import com.dsl.logic.annotations.IAnnotationsHandler;
import com.dsl.logic.programscopes.FunctionModifiersHandler;
import com.dsl.logic.programscopes.IFunctionModifiersHandler;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;
import gastmappers.exceptions.UnsupportedLanguageException;


public class FunctionModifiersHandlerTests {
	
	private IAnnotationsHandler annHandler = new AnnotationsHandler();
	private IFunctionModifiersHandler handler = new FunctionModifiersHandler(annHandler);

	
    //_________________________________________________
    // test_getModifiers_ListNotNull_Java
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is Java
    // WHEN:  handler map the unit test modifiers
    // THEN:  Results will not be null
    //_________________________________________________
	@Test
	public void test_getModifiers_ListNotNull_Java() throws UnsupportedLanguageException{
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("JAVA");
		
		// Assert
		assertNotNull(results);
	}
	
	
    //_________________________________________________
    // test_getModifiers_FirstNotNull_Java
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is Java
    // WHEN:  handler map the unit test modifiers
    // THEN:  First modifier will not be null
    //_________________________________________________
	@Test
	public void test_getModifiers_FirstNotNull_Java() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("JAVA");
		Modifiers result = results.get(0);
		
		// Assert
		assertNotNull(result);
	}
	
	
	//_________________________________________________
    // test_getModifiers_SecondNotNull_Java
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is Java
    // WHEN:  handler map the unit test modifiers
    // THEN:  Second modifier will not be null
    //_________________________________________________
	@Test
	public void test_getModifiers_SecondNotNull_Java() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("JAVA");
		Modifiers result = results.get(1);
		
		// Assert
		assertNotNull(result);
	}
	
	
	//_________________________________________________
    // test_getModifiers_FirstAnnotation_Java
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is Java
    // WHEN:  handler map the unit test modifiers
    // THEN:  First modifier is AnnotationModifier
    //_________________________________________________
	@Test
	public void test_getModifiers_FirstAnnotation_Java() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("JAVA");
		Modifiers result = results.get(0);
		
		// Assert
		assertTrue(result instanceof AnnotationModifier);
	}
	
	
    //_________________________________________________
    // test_getModifiers_SecondPublic_Java
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is Java
    // WHEN:  handler map the unit test modifiers
    // THEN:  Second modifier is public
    //_________________________________________________
	@Test
	public void test_getModifiers_SecondPublic_Java() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("JAVA");
		Modifiers result = results.get(1);
		
		// Assert
		assertTrue(result instanceof PublicModifier);
	}
	
	
	//_________________________________________________
    // test_getModifiers_AnnotationTest_Java
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is Java
    // WHEN:  handler map the unit test modifiers
    // THEN:  First modifier has Test text
    //_________________________________________________
	@Test
	public void test_getModifiers_AnnotationTest_Java() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("JAVA");
		AnnotationModifier result = (AnnotationModifier) results.get(0);
		
		// Assert
		assertEquals("Test", result.getModifier());
	}
	
	
    //_________________________________________________
    // test_getModifiers_ModifiersSize_Java
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is Java
    // WHEN:  handler map the unit test modifiers
    // THEN:  Modifiers size is 2
    //_________________________________________________
	@Test
	public void test_getModifiers_ModifiersSize_Java() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("JAVA");
		
		// Assert
		assertTrue(results.size() == 2);
	}
	
	
	
	
	
	
	
	
	//_________________________________________________
    // test_getModifiers_ListNotNull_CSharp
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is CSharp
    // WHEN:  handler map the unit test modifiers
    // THEN:  Results will not be null
    //_________________________________________________
	@Test
	public void test_getModifiers_ListNotNull_CSharp() throws UnsupportedLanguageException{
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("CSharp");
		
		// Assert
		assertNotNull(results);
	}
	
	
    //_________________________________________________
    // test_getModifiers_FirstNotNull_CSharp
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is CSharp
    // WHEN:  handler map the unit test modifiers
    // THEN:  First modifier will not be null
    //_________________________________________________
	@Test
	public void test_getModifiers_FirstNotNull_CSharp() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("CSharp");
		Modifiers result = results.get(0);
		
		// Assert
		assertNotNull(result);
	}
	
	
	//_________________________________________________
    // test_getModifiers_SecondNotNull_CSharp
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is CSharp
    // WHEN:  handler map the unit test modifiers
    // THEN:  Second modifier will not be null
    //_________________________________________________
	@Test
	public void test_getModifiers_SecondNotNull_CSharp() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("CSharp");
		Modifiers result = results.get(1);
		
		// Assert
		assertNotNull(result);
	}
	
	
	//_________________________________________________
    // test_getModifiers_FirstAnnotation_CSharp
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is CSharp
    // WHEN:  handler map the unit test modifiers
    // THEN:  First modifier is AnnotationModifier
    //_________________________________________________
	@Test
	public void test_getModifiers_FirstAnnotation_CSharp() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("CSharp");
		Modifiers result = results.get(0);
		
		// Assert
		assertTrue(result instanceof AnnotationModifier);
	}
	
	
    //_________________________________________________
    // test_getModifiers_SecondPublic_CSharp
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is CSharp
    // WHEN:  handler map the unit test modifiers
    // THEN:  Second modifier is public
    //_________________________________________________
	@Test
	public void test_getModifiers_SecondPublic_CSharp() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("CSharp");
		Modifiers result = results.get(1);
		
		// Assert
		assertTrue(result instanceof PublicModifier);
	}
	
	
	//_________________________________________________
    // test_getModifiers_AnnotationTest_CSharp
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is CSharp
    // WHEN:  handler map the unit test modifiers
    // THEN:  First modifier has Test text
    //_________________________________________________
	@Test
	public void test_getModifiers_AnnotationTest_CSharp() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("CSharp");
		AnnotationModifier result = (AnnotationModifier) results.get(0);
		
		// Assert
		assertEquals("TestMethod", result.getModifier());
	}
	
	
    //_________________________________________________
    // test_getModifiers_ModifiersSize_CSharp
    //
    // GIVEN: getModifiers function is executed
	// AND:   language is CSharp
    // WHEN:  handler map the unit test modifiers
    // THEN:  Modifiers size is 2
    //_________________________________________________
	@Test
	public void test_getModifiers_ModifiersSize_CSharp() throws UnsupportedLanguageException {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers("CSharp");
		
		// Assert
		assertTrue(results.size() == 2);
	}
	
}
