package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.dsl.logic.programscopes.modifiers.ClassModifiersHandler;
import com.dsl.logic.programscopes.modifiers.IClassModifiersHandler;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;


public class ClassModifiersHandlerTests {
	
	//private IClassModifiersHandler sut = new ClassModifiersHandler();
	
	
	//__________________________________________________________
    // test_processClassModifiers_NotNull
    //
    // GIVEN: Class is being provisioned
    // WHEN:  processClassModifiers is called
    // THEN:  Response is not null
    //__________________________________________________________
	/*@Test
	public void test_processClassModifiers_NotNull() {
		// Arrange 
		// Act
		ArrayList<Modifiers> modifiers = sut.processClassModifiers();
		
		// Assert 
		assertNotNull(modifiers);
	}*/
	
	//__________________________________________________________
    // test_processClassModifiers_Size
    //
    // GIVEN: Class is being provisioned
    // WHEN:  processClassModifiers is called
    // THEN:  Response size is one
    //__________________________________________________________
	/*@Test
	public void test_processClassModifiers_Size() {
		// Arrange 
		// Act
		ArrayList<Modifiers> modifiers = sut.processClassModifiers();
		
		// Assert 
		assertEquals(1, modifiers.size());
	}*/
	
	//__________________________________________________________
    // test_processClassModifier_Public
    //
    // GIVEN: Class is being provisioned
    // WHEN:  processClassModifiers is called
    // THEN:  Response modifier is public
    //__________________________________________________________
	/*@Test
	public void test_processClassModifier_Public() {
		// Arrange 
		// Act
		ArrayList<Modifiers> modifiers = sut.processClassModifiers();
		Modifiers modifier = modifiers.get(0);
		
		// Assert 
		assertTrue(modifier instanceof PublicModifier);
	}*/
}
