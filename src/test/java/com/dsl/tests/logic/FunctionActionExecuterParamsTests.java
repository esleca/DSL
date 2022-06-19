package com.dsl.tests.logic;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.dsl.logic.programscopes.action.FunctionActionExecuterParams;
import com.dsl.logic.programscopes.action.IFunctionActionExecuterParams;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.acts.ActExecution;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;
import ASTMCore.ASTMSyntax.Expression.ActualParameterExpression;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Expression.IdentifierReference;


public class FunctionActionExecuterParamsTests {
	
	private IFunctionActionExecuterParams sut = new FunctionActionExecuterParams(); 

	
	//_________________________________________________
    // test_getActualParameterExpressions_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_getActualParameterExpressions_NotNull() {
		//Arrange
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param1"));
	    		add(new FunctionArgument("param2"));
	    		add(new FunctionArgument("param3"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(null, null, null, functionArguments);

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		
		//Assert
		assertNotNull(result);
	}

	
	//_________________________________________________
    // test_getActualParameterExpressions_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result is empty
    //_________________________________________________
	@Test
	public void test_getActualParameterExpressions_Empty() {
		//Arrange
	    ActExecution actExecution = new ActExecution(null, null, null, new ArrayList<FunctionArgument>());

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		
		//Assert
		assertTrue(result.isEmpty());
	}
	
	
	//_________________________________________________
    // test_getActualParameterExpressions_Size
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result size match
    //_________________________________________________
	@Test
	public void test_getActualParameterExpressions_Size() {
		//Arrange
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param1"));
	    		add(new FunctionArgument("param2"));
	    		add(new FunctionArgument("param3"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(null, null, null, functionArguments);

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		
		//Assert
		assertEquals(3, result.size());
	}
	
	
	//_________________________________________________
    // test_getActualParameterExpression_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_getActualParameterExpression_NotNull() {
		//Arrange
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param1"));
	    		add(new FunctionArgument("param2"));
	    		add(new FunctionArgument("param3"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(null, null, null, functionArguments);

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		ActualParameter actualParameter = result.get(0);
		
		//Assert
		assertNotNull(actualParameter);
	}
	
	
	//_________________________________________________
    // test_getActualParameterExpression_Type
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result type is Expression parameter
    //_________________________________________________
	@Test
	public void test_getActualParameterExpression_Type() {
		//Arrange
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param1"));
	    		add(new FunctionArgument("param2"));
	    		add(new FunctionArgument("param3"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(null, null, null, functionArguments);

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		ActualParameter actualParameter = result.get(0);
		
		//Assert
		assertTrue(actualParameter instanceof ActualParameterExpression);
	}
	
	
	//_________________________________________________
    // test_getActualParameterExpression_Value_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result expression value is not null
    //_________________________________________________
	@Test
	public void test_getActualParameterExpression_Value_NotNull() {
		//Arrange
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param1"));
	    		add(new FunctionArgument("param2"));
	    		add(new FunctionArgument("param3"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(null, null, null, functionArguments);

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		ActualParameterExpression actualParameter = (ActualParameterExpression) result.get(0);
		Expression expression = actualParameter.getValue();
		
		//Assert
		assertNotNull(expression);
	}
	
	
	//_________________________________________________
    // test_getActualParameterExpression_Value_Type
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result expression value type match
    //_________________________________________________
	@Test
	public void test_getActualParameterExpression_Value_Type() {
		//Arrange
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param1"));
	    		add(new FunctionArgument("param2"));
	    		add(new FunctionArgument("param3"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(null, null, null, functionArguments);

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		ActualParameterExpression actualParameter = (ActualParameterExpression) result.get(0);
		Expression expression = actualParameter.getValue();
		
		//Assert
		assertTrue(expression instanceof IdentifierReference);
	}
	
	
	//_________________________________________________
    // test_getActualParameterExpression_ValueName_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result expression value name is not null
    //_________________________________________________
	@Test
	public void test_getActualParameterExpression_ValueName_NotNull() {
		//Arrange
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param1"));
	    		add(new FunctionArgument("param2"));
	    		add(new FunctionArgument("param3"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(null, null, null, functionArguments);

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		ActualParameterExpression actualParameter = (ActualParameterExpression) result.get(0);
		IdentifierReference expression = (IdentifierReference) actualParameter.getValue();
		Name name = expression.getIdentifierName();
		
		//Assert
		assertNotNull(name);
	}
	
	
	//_________________________________________________
    // test_getActualParameterExpression_ValueNames
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActualParameterExpressions is called
    // THEN:  result expression value name match
	//		  param1, param2 and param3
    //_________________________________________________
	@Test
	public void test_getActualParameterExpression_ValueNames() {
		//Arrange
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param1"));
	    		add(new FunctionArgument("param2"));
	    		add(new FunctionArgument("param3"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(null, null, null, functionArguments);

		//Action 
		ArrayList<ActualParameter> result = sut.getActualParameterExpressions(actExecution);
		
		ActualParameterExpression actualParameter1 = (ActualParameterExpression) result.get(0);
		ActualParameterExpression actualParameter2 = (ActualParameterExpression) result.get(1);
		ActualParameterExpression actualParameter3 = (ActualParameterExpression) result.get(2);
		
		IdentifierReference expression1 = (IdentifierReference) actualParameter1.getValue();
		IdentifierReference expression2 = (IdentifierReference) actualParameter2.getValue();
		IdentifierReference expression3 = (IdentifierReference) actualParameter3.getValue();

		Name name1 = expression1.getIdentifierName();
		Name name2 = expression2.getIdentifierName();
		Name name3 = expression3.getIdentifierName();
		
		//Assert
		assertEquals("param1", name1.getNameString());
		assertEquals("param2", name2.getNameString());
		assertEquals("param3", name3.getNameString());
	}
}
