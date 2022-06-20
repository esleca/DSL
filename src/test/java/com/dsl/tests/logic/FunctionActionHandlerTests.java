package com.dsl.tests.logic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dsl.logic.programscopes.action.FunctionActionHandler;
import com.dsl.logic.programscopes.action.IFunctionActionExecuter;
import com.dsl.logic.programscopes.action.IFunctionActionInstantiator;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.DefintionObject;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;


@ExtendWith(MockitoExtension.class)
public class FunctionActionHandlerTests {

	@Mock
	private IFunctionActionInstantiator _actionInstantiator;
	
	@Mock
	private IFunctionActionExecuter _actionExecuter;

	@InjectMocks
	private FunctionActionHandler sut;


	
	//_________________________________________________
    // test_DeclOrDefStatementNewType_NotNull
    //
    // GIVEN: ActNewType is provisioned 
    // WHEN:  getDeclOrDefStatementNewType is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_DeclOrDefStatementNewType_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		when(_actionInstantiator.getActNewTypeVariableDefinition(actNewType))
			.thenReturn(varDefinition);
		
		//Action 
		DeclarationOrDefinitionStatement decOrDefStatement = sut.getDeclOrDefStatementNewType(actNewType);
		
		//Assert
		assertNotNull(decOrDefStatement);
	}

	
	//_________________________________________________
    // test_DeclOrDefStatementNewType_VariableDefinition_notNull
    //
    // GIVEN: ActNewType is provisioned 
    // WHEN:  getDeclOrDefStatementNewType is called
    // THEN:  result variable definition is not null
    //_________________________________________________
	@Test
	public void test_DeclOrDefStatementNewType_VariableDefinition_notNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		when(_actionInstantiator.getActNewTypeVariableDefinition(actNewType))
			.thenReturn(varDefinition);
		
		//Action 
		DeclarationOrDefinitionStatement decOrDefStatement = sut.getDeclOrDefStatementNewType(actNewType);
		DefintionObject defObject = decOrDefStatement.getDeclOrDefn();
		
		//Assert
		assertNotNull(defObject);
	}

	
	//_________________________________________________
    // test_DeclOrDefStatementNewType_VariableDefinition
    //
    // GIVEN: ActNewType is provisioned 
    // WHEN:  getDeclOrDefStatementNewType is called
    // THEN:  result variable definition type match
    //_________________________________________________
	@Test
	public void test_DeclOrDefStatementNewType_VariableDefinition() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		when(_actionInstantiator.getActNewTypeVariableDefinition(actNewType))
			.thenReturn(varDefinition);
		
		//Action 
		DeclarationOrDefinitionStatement decOrDefStatement = sut.getDeclOrDefStatementNewType(actNewType);
		DefintionObject defObject = decOrDefStatement.getDeclOrDefn();
		
		//Assert
		assertTrue(defObject instanceof VariableDefinition);
	}
	
	
	
	//_________________________________________________
    // test_getDeclOrDefStatementExecution_NotNull
    //
    // GIVEN: actExecution is provisioned 
    // WHEN:  getDeclOrDefStatementExecution is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_getDeclOrDefStatementExecution_NotNull() {
		//Arrange
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		when(_actionExecuter.getActExecutionVariableDefinition(actExecution))
			.thenReturn(varDefinition);
		
		//Action 
		DeclarationOrDefinitionStatement decOrDefStatement = sut.getDeclOrDefStatementExecution(actExecution);
		
		//Assert
		assertNotNull(decOrDefStatement);
	}

	
	//_________________________________________________
    // test_DeclOrDefStatementExecution_VariableDefinition_notNull
    //
    // GIVEN: actExecution is provisioned 
    // WHEN:  getDeclOrDefStatementExecution is called
    // THEN:  result variable definition is not null
    //_________________________________________________
	@Test
	public void test_DeclOrDefStatementExecution_VariableDefinition_notNull() {
		//Arrange
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());

		when(_actionExecuter.getActExecutionVariableDefinition(actExecution))
			.thenReturn(varDefinition);
		
		//Action 
		DeclarationOrDefinitionStatement decOrDefStatement = sut.getDeclOrDefStatementExecution(actExecution);
		DefintionObject defObject = decOrDefStatement.getDeclOrDefn();
		
		//Assert
		assertNotNull(defObject);
	}

	
	//_________________________________________________
    // test_DeclOrDefStatementExecution_VariableDefinition
    //
    // GIVEN: actExecution is provisioned 
    // WHEN:  getDeclOrDefStatementExecution is called
    // THEN:  result variable definition type match
    //_________________________________________________
	@Test
	public void test_DeclOrDefStatementExecution_VariableDefinition() {
		//Arrange
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		when(_actionExecuter.getActExecutionVariableDefinition(actExecution))
			.thenReturn(varDefinition);
		
		//Action 
		DeclarationOrDefinitionStatement decOrDefStatement = sut.getDeclOrDefStatementExecution(actExecution);
		DefintionObject defObject = decOrDefStatement.getDeclOrDefn();
		
		//Assert
		assertTrue(defObject instanceof VariableDefinition);
	}
	
}
