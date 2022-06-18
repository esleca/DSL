package com.dsl.tests.logic;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.dsl.logic.programscopes.FunctionActionInstantiator;
import com.dsl.logic.programscopes.IFunctionActionInstantiator;
import com.dsl.models.unittests.acts.ActNewType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Expression.NewExpression;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;
import ASTMCore.ASTMSyntax.Types.TypeReference;


public class FunctionActionInstantiatorTests {

	private IFunctionActionInstantiator sut = new FunctionActionInstantiator();
	
	
	//_________________________________________________
    // test_ActNewType_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_ActNewType_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		
		//Assert
		assertNotNull(result);
	}

	
	//_________________________________________________
    // test_ActNewType_Fragments_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragments are not null
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragments_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		
		//Assert
		assertNotNull(fragments);
	}

	
	//_________________________________________________
    // test_ActNewType_Fragments_Size
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragments size is one
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragments_Size() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		
		//Assert
		assertEquals(1, fragments.size());
	}

	
	//_________________________________________________
    // test_ActNewType_DefType_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result definition type is not null
    //_________________________________________________
	@Test
	public void test_ActNewType_DefType_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		TypeReference definitionType = result.getDefinitionType();
		
		//Assert
		assertNotNull(definitionType);
	}

	
	//_________________________________________________
    // test_ActNewType_DefType_Type
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result definition type is named reference
    //_________________________________________________
	@Test
	public void test_ActNewType_DefType_Type() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		TypeReference definitionType = result.getDefinitionType();
		
		//Assert
		assertTrue(definitionType instanceof NamedTypeReference);
	}


	//_________________________________________________
    // test_ActNewType_DefTypeName_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result definition type Name is not null
    //_________________________________________________
	@Test
	public void test_ActNewType_DefTypeName_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		NamedTypeReference definitionType = (NamedTypeReference) result.getDefinitionType();
		Name nameRes = definitionType.getTypeName();
		
		//Assert
		assertNotNull(nameRes);
	}

	
	//_________________________________________________
    // test_ActNewType_DefType_TypName
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result definition type name value match
    //_________________________________________________
	@Test
	public void test_ActNewType_DefType_TypeName() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		NamedTypeReference definitionType = (NamedTypeReference) result.getDefinitionType();
		Name nameRes = definitionType.getTypeName();
		
		//Assert
		assertEquals("ClassName", nameRes.getNameString());
	}

	
	//_________________________________________________
    // test_ActNewType_Fragment_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragment is not null
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragment_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		
		//Assert
		assertNotNull(fragment);
	}

	
	//_________________________________________________
    // test_ActNewType_Fragment_InitialValue_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragment initial value is not null
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragment_InitialValue_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Expression expression = fragment.getInitialValue();
		
		//Assert
		assertNotNull(expression);
	}

	
	//_________________________________________________
    // test_ActNewType_Fragment_InitialValue_Type
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragment initial value type match
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragment_InitialValue_Type() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Expression expression = fragment.getInitialValue();
		
		//Assert
		assertTrue(expression instanceof NewExpression);
	}

	
	//_________________________________________________
    // test_ActNewType_Fragment_InitialValue_NewType_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragment initial value is not null
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragment_InitialValue_NewType_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		NewExpression expression = (NewExpression) fragment.getInitialValue();
		TypeReference namedTypeReference = expression.getNewType();
		
		//Assert
		assertNotNull(namedTypeReference);
	}

	
	//_________________________________________________
    // test_ActNewType_Fragment_InitialValue_NewTypeName_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragment initial value new type name is not null
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragment_InitialValue_NewTypeName_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		NewExpression expression = (NewExpression) fragment.getInitialValue();
		NamedTypeReference namedTypeReference = (NamedTypeReference) expression.getNewType();
		Name typeName = namedTypeReference.getTypeName();
		
		//Assert
		assertNotNull(typeName);
	}

	
	//_________________________________________________
    // test_ActNewType_Fragment_InitialValue_NewTypeName
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragment initial value new type name match
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragment_InitialValue_NewTypeName() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		NewExpression expression = (NewExpression) fragment.getInitialValue();
		NamedTypeReference namedTypeReference = (NamedTypeReference) expression.getNewType();
		Name typeName = namedTypeReference.getTypeName();
		
		//Assert
		assertEquals("ClassName", typeName.getNameString());
	}

	
	//_________________________________________________
    // test_ActNewType_Fragment_IdentifierName_NotNull
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragment identifier name is not null
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragment_IdentifierName_NotNull() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Name identifier = fragment.getIdentifierName();
		
		//Assert
		assertNotNull(identifier);
	}

	
	//_________________________________________________
    // test_ActNewType_Fragment_IdentifierName_Value
    //
    // GIVEN: ActNewType is correctly provisioned
    // WHEN:  getActNewTypeVariableDefinition is called
    // THEN:  result fragment identifier name is sut
    //_________________________________________________
	@Test
	public void test_ActNewType_Fragment_IdentifierName_Value() {
		//Arrange
		String type = "ClassName";
	    String name = "sut";
		ActNewType actNewType = new ActNewType(type, name);
		
		//Action 
		VariableDefinition result = sut.getActNewTypeVariableDefinition(actNewType);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Name identifier = fragment.getIdentifierName();
		String nameRes = identifier.getNameString();
		
		//Assert
		assertEquals("sut", nameRes);
	}
	
}
