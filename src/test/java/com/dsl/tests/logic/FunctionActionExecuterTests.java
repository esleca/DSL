package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.dsl.logic.programscopes.IFunctionActionExecuter;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.unittests.asserts.types.java.JavaAreEqual;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Types.TypeReference;

import com.dsl.logic.programscopes.FunctionActionExecuter;


public class FunctionActionExecuterTests {

	private IFunctionActionExecuter sut = new FunctionActionExecuter();
	
	
	//____________________________________________________
    // test_test_ActExecution_VariableDefinition_NotNull
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition result is not null
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "";

    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		
		//Assert
		assertNotNull(result);
	}
	
	
	//____________________________________________________
    // test_test_ActExecution_VariableDefinition_NotNull
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition result is not null
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_Fragments_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "";

    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		List<Fragment> fragments = result.getFragments();
		
		//Assert
		assertNotNull(fragments);
	}

	
	//____________________________________________________
    // test_ActExecution_VariableDefinition_DefType_NotNull
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition type result is not null
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_DefType_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "";

    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		TypeReference defTypeResult = result.getDefinitionType();
		
		//Assert
		assertNotNull(defTypeResult);
	}
	
}
