package com.dsl.tests.logic;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.dsl.logic.programscopes.action.FunctionActionExecuterFragments;
import com.dsl.logic.programscopes.action.IFunctionActionExecuterParams;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.acts.ActExecution;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;
import ASTMCore.ASTMSyntax.Expression.ActualParameterExpression;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;
import ASTMCore.ASTMSyntax.Expression.IdentifierReference;


@ExtendWith(MockitoExtension.class)
public class FunctionActionExecuterFragmentsTests {

	@Mock
	private IFunctionActionExecuterParams _actionExecuterParams;
	
	@InjectMocks
	private FunctionActionExecuterFragments sut;
	
	
	
	//_________________________________________________
    // test_ActFragmentExpression_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActFragmentExpression is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_ActFragmentExpression_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "result");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		when(_actionExecuterParams.getActualParameterExpressions(actExecution))
			.thenReturn(parameterExpressions);
		
		//Act
		FunctionCallExpression result = sut.getActFragmentExpression(actExecution);
		
		//Assert
		assertNotNull(result);
	}
	
	
	//_________________________________________________
    // test_ActFragmentExpression_CalledFunction_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActFragmentExpression is called
    // THEN:  result called function is not null
    //_________________________________________________
	@Test
	public void test_ActFragmentExpression_CalledFunction_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "result");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		when(_actionExecuterParams.getActualParameterExpressions(actExecution))
			.thenReturn(parameterExpressions);
		
		//Act
		FunctionCallExpression result = sut.getActFragmentExpression(actExecution);
		Expression expression = result.getCalledFunction();
		
		//Assert
		assertNotNull(expression);
	}
	
	
	//_________________________________________________
    // test_ActFragmentExpression_CalledFunction_NameNotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActFragmentExpression is called
    // THEN:  result called function name is not null
    //_________________________________________________
	@Test
	public void test_ActFragmentExpression_CalledFunction_NameNotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "result");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		when(_actionExecuterParams.getActualParameterExpressions(actExecution))
			.thenReturn(parameterExpressions);
		
		//Act
		FunctionCallExpression result = sut.getActFragmentExpression(actExecution);
		IdentifierReference expression = (IdentifierReference) result.getCalledFunction();
		Name calledFunctionRes = expression.getIdentifierName();
		
		//Assert
		assertNotNull(calledFunctionRes);
	}
	
	
	//_________________________________________________
    // test_ActFragmentExpression_CalledFunction_Name
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActFragmentExpression is called
    // THEN:  result called function name match
    //_________________________________________________
	@Test
	public void test_ActFragmentExpression_CalledFunction_Name() {
		//Arrange
		Declaration declaration = new Declaration("String", "result");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		when(_actionExecuterParams.getActualParameterExpressions(actExecution))
			.thenReturn(parameterExpressions);
		
		//Act
		FunctionCallExpression result = sut.getActFragmentExpression(actExecution);
		IdentifierReference expression = (IdentifierReference) result.getCalledFunction();
		Name calledFunctionRes = expression.getIdentifierName();
		String nameString = calledFunctionRes.getNameString();
		
		//Assert
		assertEquals("sut", nameString);
	}
	
	
	//_________________________________________________
    // test_ActFragmentExpression_ActualParams_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActFragmentExpression is called
    // THEN:  result actual parameters are not null
    //_________________________________________________
	@Test
	public void test_ActFragmentExpression_ActualParams_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "result");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		when(_actionExecuterParams.getActualParameterExpressions(actExecution))
			.thenReturn(parameterExpressions);
		
		//Act
		FunctionCallExpression result = sut.getActFragmentExpression(actExecution);
		ArrayList<ActualParameter> actualparameters = result.getActualParams();
		
		//Assert
		assertNotNull(actualparameters);
	}
	
	
	//_________________________________________________
    // test_ActFragmentExpression_ActualParams_Value
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActFragmentExpression is called
    // THEN:  result actual parameters values match
    //_________________________________________________
	@Test
	public void test_ActFragmentExpression_ActualParams_Value() {
		//Arrange
		Declaration declaration = new Declaration("String", "result");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameterProvision = new ActualParameterExpression();
        actualParameterProvision.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameterProvision);
			}
		};
		
		when(_actionExecuterParams.getActualParameterExpressions(actExecution))
			.thenReturn(parameterExpressions);
		
		//Act
		FunctionCallExpression result = sut.getActFragmentExpression(actExecution);
		ArrayList<ActualParameter> actualparameters = result.getActualParams();
		ActualParameterExpression actualParameter = (ActualParameterExpression) actualparameters.get(0);
		IdentifierReference expression = (IdentifierReference) actualParameter.getValue();
		Name name = expression.getIdentifierName();
		String nameString = name.getNameString();
		
		//Assert
		assertEquals("param", nameString);
	}
	
	
	//_________________________________________________
    // test_ActFragmentExpression_FunctionName_NotNull
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActFragmentExpression is called
    // THEN:  result function name is not null
    //_________________________________________________
	@Test
	public void test_ActFragmentExpression_FunctionName_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "result");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		when(_actionExecuterParams.getActualParameterExpressions(actExecution))
			.thenReturn(parameterExpressions);
		
		//Act
		FunctionCallExpression result = sut.getActFragmentExpression(actExecution);
		Name fcName = result.getFunctionName();
		
		//Assert
		assertNotNull(fcName);
	}
	
	
	//_________________________________________________
    // test_ActFragmentExpression_FunctionName_Value
    //
    // GIVEN: ActExecution is correctly provisioned
    // WHEN:  getActFragmentExpression is called
    // THEN:  result function name match
    //_________________________________________________
	@Test
	public void test_ActFragmentExpression_FunctionName_Value() {
		//Arrange
		Declaration declaration = new Declaration("String", "result");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		when(_actionExecuterParams.getActualParameterExpressions(actExecution))
			.thenReturn(parameterExpressions);
		
		//Act
		FunctionCallExpression result = sut.getActFragmentExpression(actExecution);
		Name fcName = result.getFunctionName();
		String nameString = fcName.getNameString();
		 
		//Assert
		assertEquals("functionName", nameString);
	}
}
