package com.dsl.tests.logic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.dsl.logic.programscopes.FunctionModifiersHandler;
import com.dsl.logic.programscopes.IFunctionModifiersHandler;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;


public class FunctionModifiersHandlerTests {
	
	private IFunctionModifiersHandler handler = new FunctionModifiersHandler();

	
    //_________________________________________________
    // test_getModifiers_ListNotNull
    //
    // GIVEN: getModifiers function is executed
    // WHEN:  handler map the unit test modifiers
    // THEN:  Results will not be null
    //_________________________________________________
	@Test
	public void test_getModifiers_ListNotNull() {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers();
		
		// Assert
		assertNotNull(results);
	}
	
	
    //_________________________________________________
    // test_getModifiers_FirstNotNull
    //
    // GIVEN: getModifiers function is executed
    // WHEN:  handler map the unit test modifiers
    // THEN:  First modifier will not be null
    //_________________________________________________
	@Test
	public void test_getModifiers_FirstNotNull() {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers();
		Modifiers result = results.get(0);
		
		// Assert
		assertNotNull(result);
	}
	
	
    //_________________________________________________
    // test_getModifiers_FirstPublic
    //
    // GIVEN: getModifiers function is executed
    // WHEN:  handler map the unit test modifiers
    // THEN:  First modifier is public
    //_________________________________________________
	@Test
	public void test_getModifiers_FirstPublic() {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers();
		Modifiers result = results.get(0);
		
		// Assert
		assertTrue(result instanceof PublicModifier);
	}
	
	
    //_________________________________________________
    // test_getModifiers_ModifiersSize
    //
    // GIVEN: getModifiers function is executed
    // WHEN:  handler map the unit test modifiers
    // THEN:  Modifiers size is 1
    //_________________________________________________
	@Test
	public void test_getModifiers_ModifiersSize() {
		// Act
		ArrayList<Modifiers> results = handler.getModifiers();
		
		// Assert
		assertTrue(results.size() == 1);
	}
	
}
