package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import com.dsl.logic.programscopes.FunctionReturnHandler;
import com.dsl.logic.programscopes.IFunctionReturnHandler;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;
import ASTMCore.ASTMSyntax.Types.TypeReference;


public class FunctionReturnHandlerTests {
	
	private IFunctionReturnHandler sut = new FunctionReturnHandler();

	
    //_________________________________________________
    // test_getReturnType_NotNull
    //
    // GIVEN: getReturnType function is executed
    // WHEN:  result is returned correctly
    // THEN:  result is an abstract class TypeReference
    //_________________________________________________
	@Test
	public void test_getReturnType_NotNull() {
		// Act
		TypeReference result = sut.getReturnType();
		
		// Assert
		assertNotNull(result);
	}

    //_________________________________________________
    // test_getReturnType_NotNull
    //
    // GIVEN: getReturnType function is executed
    // WHEN:  result is returned correctly
    // THEN:  Result is instance of NamedTypeReference
    //_________________________________________________
	@Test
	public void test_getReturnType_TypeOf_NamedTypeReference() {
		// Act
		TypeReference result = sut.getReturnType();
		
		// Assert
		assertTrue(result instanceof NamedTypeReference);
	}
	
    //_________________________________________________
    // test_getReturnType_NotNull
    //
    // GIVEN: getReturnType function is executed
    // WHEN:  result is returned correctly
    // THEN:  Name object is not null
    //_________________________________________________
	@Test
	public void test_getReturnType_Name_NotNull() {
		// Act
		NamedTypeReference result = (NamedTypeReference) sut.getReturnType();
		
		Name name = result.getTypeName();
		
		// Assert
		assertNotNull(name);
	}
	
	
	//_________________________________________________
    // test_getReturnType_Name_TypeOf
    //
    // GIVEN: getReturnType function is executed
    // WHEN:  result is returned correctly
    // THEN:  return type name is of instance Name
    //_________________________________________________
	@Test
	public void test_getReturnType_Name_TypeOf() {
		// Act
		NamedTypeReference result = (NamedTypeReference) sut.getReturnType();
		
		Name name = result.getTypeName();
		
		// Assert
		assertTrue(name instanceof Name);
	}
	
	
	//_________________________________________________
    // test_getReturnType_Name_VoidName
    //
    // GIVEN: getReturnType function is executed
    // WHEN:  result is returned correctly
    // THEN:  Return type text is void
    //_________________________________________________
	@Test
	public void test_getReturnType_Name_VoidName() {
		// Act
		NamedTypeReference result = (NamedTypeReference) sut.getReturnType();
		
		Name name = result.getTypeName();
		
		String nameString = name.getNameString();
		
		// Assert
		assertEquals("void", nameString);
	}
}
