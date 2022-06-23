package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dsl.logic.programscopes.action.IFunctionActionExecuterFragments;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.factories.GastFactory;
import com.dsl.logic.programscopes.action.FunctionActionExecuter;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;
import ASTMCore.ASTMSyntax.Expression.ActualParameterExpression;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;
import ASTMCore.ASTMSyntax.Expression.IdentifierReference;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;
import ASTMCore.ASTMSyntax.Types.TypeReference;



@ExtendWith(MockitoExtension.class)
public class FunctionActionExecuterTests {

	@Mock
	private IFunctionActionExecuterFragments _actionExecuterFragments;

	@InjectMocks
	private FunctionActionExecuter sut;
	
	
	
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

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
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

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
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
    // test_test_ActExecution_VariableDefinition_Size
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition result size is one
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_Fragments_Size() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		List<Fragment> fragments = result.getFragments();
		
		//Assert
		assertEquals(1, fragments.size());
	}
	
	
	//____________________________________________________
    // test_test_ActExecution_VariableDefinition_Size
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition result fragment is not null
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_Fragment_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		
		//Assert
		assertNotNull(fragment);
	}
	
	
	//____________________________________________________
    // test_ActExecution_VariableDefinition_Fragment_InitialValue_NotNull
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition result fragment is not null
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_Fragment_InitialValue_NotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Mock
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		Name fName = GastFactory.getName(actExecution.getFunctionName());
		
		FunctionCallExpression expression = new FunctionCallExpression();
		expression.setCalledFunction(identifierReference);
        expression.setActualParams(parameterExpressions);
        expression.setFunctionName(fName);
		
		when(_actionExecuterFragments.getActFragmentExpression(actExecution))
			.thenReturn(expression);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Expression expressionRes = fragment.getInitialValue();
		
		//Assert
		assertNotNull(expressionRes);
	}
	
	
	//____________________________________________________
    // test_ActExecution_VariableDefinition_Fragment_InitialValue_Type
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition result fragment type match
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_Fragment_InitialValue_Type() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Mock
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		Name fName = GastFactory.getName(actExecution.getFunctionName());
		
		FunctionCallExpression expression = new FunctionCallExpression();
		expression.setCalledFunction(identifierReference);
        expression.setActualParams(parameterExpressions);
        expression.setFunctionName(fName);
		
		when(_actionExecuterFragments.getActFragmentExpression(actExecution))
			.thenReturn(expression);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Expression expressionRes = fragment.getInitialValue();
		
		//Assert
		assertTrue(expressionRes instanceof FunctionCallExpression);
	}
	
	
	//____________________________________________________
    // test_ActExecution_VariableDefinition_Fragment_InitialValue_NameNotNull
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition result fragment type match
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_Fragment_InitialValue_NameNotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";

    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Mock
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		Name fName = GastFactory.getName(actExecution.getFunctionName());
		
		FunctionCallExpression expression = new FunctionCallExpression();
		expression.setCalledFunction(identifierReference);
        expression.setActualParams(parameterExpressions);
        expression.setFunctionName(fName);
		
		when(_actionExecuterFragments.getActFragmentExpression(actExecution))
			.thenReturn(expression);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		FunctionCallExpression callExpression = (FunctionCallExpression) fragment.getInitialValue();
		Name fctName = callExpression.getFunctionName();
		
		//Assert
		assertNotNull(fctName);
	}
	
	
	//____________________________________________________
    // test_ActExecution_VariableDefinition_Fragment_InitialValue_NameValue
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition result fragment name value match
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_Fragment_InitialValue_NameValue() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";

    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Mock
		IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(new Name("param"));
        
        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
		
		ArrayList<ActualParameter> parameterExpressions = new ArrayList<ActualParameter>() {
			{
				add(actualParameter);
			}
		};
		
		Name fName = GastFactory.getName(actExecution.getFunctionName());
		
		FunctionCallExpression expression = new FunctionCallExpression();
		expression.setCalledFunction(identifierReference);
        expression.setActualParams(parameterExpressions);
        expression.setFunctionName(fName);
		
		when(_actionExecuterFragments.getActFragmentExpression(actExecution))
			.thenReturn(expression);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		FunctionCallExpression callExpression = (FunctionCallExpression) fragment.getInitialValue();
		Name fctName = callExpression.getFunctionName();
		String nameString = fctName.getNameString();
		
		//Assert
		assertEquals("functionName", nameString);
	}

	
	
	
	
	// DefinitionType
	
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

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		TypeReference defTypeResult = result.getDefinitionType();
		
		//Assert
		assertNotNull(defTypeResult);
	}

	
	//____________________________________________________
    // test_ActExecution_VariableDefinition_DefType_Type
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition type result type match
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_DefType_Type() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		TypeReference defTypeResult = result.getDefinitionType();
		
		//Assert
		assertTrue(defTypeResult instanceof NamedTypeReference);
	}
	
	
	//____________________________________________________
    // test_ActExecution_VariableDefinition_DefType_NameNotNull
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition type result name is not null
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_DefType_NameNotNull() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		NamedTypeReference defTypeResult = (NamedTypeReference) result.getDefinitionType();
		Name name = defTypeResult.getTypeName();
		
		//Assert
		assertNotNull(name);
	}

	
	//____________________________________________________
    // test_ActExecution_VariableDefinition_DefType_Name
    //
    // GIVEN: ActExecution is correctly provided
    // WHEN:  getActExecutionVariableDefinition is called
    // THEN:  Variable definition type result name match
    //____________________________________________________
	@Test
	public void test_ActExecution_VariableDefinition_DefType_Name() {
		//Arrange
		Declaration declaration = new Declaration("String", "valueVar");

		String calledFunction = "sut";
    	String functionName = "functionName";
    	
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("param"));
	    	}
	    };
	    
		ActExecution actExecution = new ActExecution(declaration, calledFunction, functionName, functionArguments);
		
		//Action 
		VariableDefinition result = sut.getActExecutionVariableDefinition(actExecution);
		NamedTypeReference defTypeResult = (NamedTypeReference) result.getDefinitionType();
		Name name = defTypeResult.getTypeName();
		String nameString = name.getNameString();
		
		//Assert
		assertEquals("String", nameString);
	}
	
}
