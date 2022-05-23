package com.dsl.tests.logic;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

import com.dsl.logic.programscopes.FunctionArrangeHandler;
import com.dsl.logic.programscopes.IFunctionArrangeHandler;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.arranges.ArrangeDefinition;
import com.dsl.models.unittests.arranges.ArrangeStatement;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;


public class FunctionArrangeHandlerTests {

	private IFunctionArrangeHandler sut = new FunctionArrangeHandler();
	
	
	//_________________________________________________
    // test_getArrangeVariableDefinition_ResultNotNull
    //
    // GIVEN: 
    // WHEN:  
    // THEN:  
    //_________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_ResultNotNull() {
		// Arrange
		Declaration declaration = new Declaration(null, null);
		ArrangeDefinition definition = new ArrangeDefinition(null);
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		//VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		
		//Assert
		//assertNotNull(result);
	}
	
	
	//_________________________________________________
    // test_
    //
    // GIVEN: 
    // WHEN:  
    // THEN:  
    //_________________________________________________
	@Test
	public void test_2() {
		// Arrange
		//ArrangeStatement arrangeStatement = new ArrangeStatement(null, null);

		// Act
		//VariableDefinition result = sut.getArrangeVariableDefinition(null);
		
		//Assert
		
	}
	
}
