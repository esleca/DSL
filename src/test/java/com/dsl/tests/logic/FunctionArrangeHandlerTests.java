package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

import com.dsl.logic.programscopes.arrange.FunctionArrangeHandler;
import com.dsl.logic.programscopes.arrange.IFunctionArrangeHandler;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.arranges.ArrangeDefinition;
import com.dsl.models.unittests.arranges.ArrangeStatement;
import com.dsl.models.valuetypes.BooleanType;
import com.dsl.models.valuetypes.CharType;
import com.dsl.models.valuetypes.DoubleType;
import com.dsl.models.valuetypes.FloatType;
import com.dsl.models.valuetypes.IntegerType;
import com.dsl.models.valuetypes.LongType;
import com.dsl.models.valuetypes.StringType;
import com.dsl.models.valuetypes.ValueType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.BooleanLiteral;
import ASTMCore.ASTMSyntax.Expression.CharLiteral;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Expression.IntegerLiteral;
import ASTMCore.ASTMSyntax.Expression.Literal;
import ASTMCore.ASTMSyntax.Expression.RealLiteral;
import ASTMCore.ASTMSyntax.Expression.StringLiteral;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;
import ASTMCore.ASTMSyntax.Types.TypeReference;



public class FunctionArrangeHandlerTests {

	private IFunctionArrangeHandler sut = new FunctionArrangeHandler();
	
	
	//_________________________________________________
    // test_getArrangeVariableDefinition_ResultNotNull
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result is not null
    //_________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_ResultNotNull() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		
		//Assert
		assertNotNull(result);
	}
	
	
	//_____________________________________________________
    // test_getArrangeVariableDefinition_FragmentsNotNull
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragments are not null
    //_____________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentsNotNull() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		
		//Assert
		assertNotNull(fragments);
	}
	
	
	//_________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNotNull
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type is not null
    //_________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNotNull() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		TypeReference typeReference = result.getDefinitionType();
		
		//Assert
		assertNotNull(typeReference);
	}
	
	
	//_________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNamed
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type is named type
    //_________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNamed() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		TypeReference typeReference = result.getDefinitionType();
		
		//Assert
		assertTrue(typeReference instanceof NamedTypeReference);
	}
	
	
	//_____________________________________________________
    // test_getArrangeVariableDefinition_FragmentsSize
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragments size should be 1
    //_____________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentsSize() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		
		//Assert
		assertEquals(1, fragments.size());
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentNotNull
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment is not null
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentNotNull() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		
		//Assert
		assertNotNull(fragment);
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueExpression
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value expression is not null
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueNotNull() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value_given");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Expression expression = fragment.getInitialValue();

		//Assert
		assertNotNull(expression);
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueLiteral
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value is a literal
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueLiteral() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value_given");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Expression expression = fragment.getInitialValue();

		//Assert
		assertTrue(expression instanceof Literal);
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueString
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value is value_given
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueString() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value_given");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		StringLiteral expression = (StringLiteral) fragment.getInitialValue();

		//Assert
		assertEquals("value_given", expression.getValue());
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueBoolean
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value is a bool
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueBoolean() {
		// Arrange
		Declaration declaration = new Declaration("boolean", "valueVar");
		
		ValueType valueType = new BooleanType();
		valueType.setValue("true");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		BooleanLiteral expression = (BooleanLiteral) fragment.getInitialValue();

		//Assert
		assertEquals("true", expression.getValue());
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueInteger
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value is 5
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueInteger() {
		// Arrange
		Declaration declaration = new Declaration("int", "valueVar");
		
		ValueType valueType = new IntegerType();
		valueType.setValue("5");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		IntegerLiteral expression = (IntegerLiteral) fragment.getInitialValue();

		//Assert
		assertEquals("5", expression.getValue());
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueChar
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value is C
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueChar() {
		// Arrange
		Declaration declaration = new Declaration("char", "valueVar");
		
		ValueType valueType = new CharType();
		valueType.setValue("C");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		CharLiteral expression = (CharLiteral) fragment.getInitialValue();

		//Assert
		assertEquals("C", expression.getValue());
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueFloat
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value is 5F
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueFloat() {
		// Arrange
		Declaration declaration = new Declaration("float", "valueVar");
		
		ValueType valueType = new FloatType();
		valueType.setValue("5.0");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		RealLiteral expression = (RealLiteral) fragment.getInitialValue();

		//Assert
		assertEquals("5.0", expression.getValue());
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueLong
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value is 333333
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueLong() {
		// Arrange
		Declaration declaration = new Declaration("long", "valueVar");
		
		ValueType valueType = new LongType();
		valueType.setValue("3333333");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		RealLiteral expression = (RealLiteral) fragment.getInitialValue();

		//Assert
		assertEquals("3333333", expression.getValue());
	}
	
	
	//________________________________________________________
    // test_getArrangeVariableDefinition_FragmentInitialValueDouble
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment initial value is 5
    //________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentInitialValueDouble() {
		// Arrange
		Declaration declaration = new Declaration("double", "valueVar");
		
		ValueType valueType = new DoubleType();
		valueType.setValue("5.3");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		RealLiteral expression = (RealLiteral) fragment.getInitialValue();

		//Assert
		assertEquals("5.3", expression.getValue());
	}
	
	
	
	
	//__________________________________________________________
    // test_getArrangeVariableDefinition_FragmentIdentifierNameNotNull
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment identifier name is not null
    //__________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentIdentifierNameNotNull() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value_given");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Name name = fragment.getIdentifierName();

		//Assert
		assertNotNull(name);
	}
	
	
	
	//__________________________________________________________
    // test_getArrangeVariableDefinition_FragmentIdentifierName
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result fragment identifier name is valueVar
    //__________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_FragmentIdentifierName() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value_given");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		List<Fragment> fragments = result.getFragments();
		Fragment fragment = fragments.get(0);
		Name name = fragment.getIdentifierName();

		//Assert
		assertEquals("valueVar", name.getNameString());
	}

	
	
	//__________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNameNotNull
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type name is not null
    //__________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNameNotNull() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value_given");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		NamedTypeReference defType = (NamedTypeReference) result.getDefinitionType();
		Name name = defType.getTypeName();
		
		//Assert
		assertNotNull(name);
	}
	
	
	//____________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNameString
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type name is String
    //____________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNameString() {
		// Arrange
		Declaration declaration = new Declaration("String", "valueVar");
		
		ValueType valueType = new StringType();
		valueType.setValue("value_given");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		NamedTypeReference defType = (NamedTypeReference) result.getDefinitionType();
		Name name = defType.getTypeName();
		
		//Assert
		assertEquals("String", name.getNameString());
	}
	
	
	//____________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNameBoolean
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type name is Boolean
    //____________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNameBoolean() {
		// Arrange
		Declaration declaration = new Declaration("boolean", "valueVar");
		
		ValueType valueType = new BooleanType();
		valueType.setValue(true);
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		NamedTypeReference defType = (NamedTypeReference) result.getDefinitionType();
		Name name = defType.getTypeName();
		
		//Assert
		assertEquals("boolean", name.getNameString());
	}
	
	
	//____________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNameString
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type name is an integer
    //____________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNameInt() {
		// Arrange
		Declaration declaration = new Declaration("int", "valueVar");
		
		ValueType valueType = new IntegerType();
		valueType.setValue("5");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		NamedTypeReference defType = (NamedTypeReference) result.getDefinitionType();
		Name name = defType.getTypeName();
		
		//Assert
		assertEquals("int", name.getNameString());
	}
	
	
	//____________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNameChar
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type name is char
    //____________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNameChar() {
		// Arrange
		Declaration declaration = new Declaration("char", "valueVar");
		
		ValueType valueType = new CharType();
		valueType.setValue("C");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		NamedTypeReference defType = (NamedTypeReference) result.getDefinitionType();
		Name name = defType.getTypeName();
		
		//Assert
		assertEquals("char", name.getNameString());
	}
	
	
	//____________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNameString
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type name is float
    //____________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNameFloat() {
		// Arrange
		Declaration declaration = new Declaration("float", "valueVar");
		
		ValueType valueType = new FloatType();
		valueType.setValue("5F");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		NamedTypeReference defType = (NamedTypeReference) result.getDefinitionType();
		Name name = defType.getTypeName();
		
		//Assert
		assertEquals("float", name.getNameString());
	}
	
	
	//____________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNameLong
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type name is Long
    //____________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNameLong() {
		// Arrange
		Declaration declaration = new Declaration("long", "valueVar");
		
		ValueType valueType = new LongType();
		valueType.setValue("333333333");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		NamedTypeReference defType = (NamedTypeReference) result.getDefinitionType();
		Name name = defType.getTypeName();
		
		//Assert
		assertEquals("long", name.getNameString());
	}
	
	
	//____________________________________________________________
    // test_getArrangeVariableDefinition_DefinitionTypeNameDouble
    //
    // GIVEN: A String valueVar variable is declared
    // WHEN:  getArrangeVariableDefinition is executed
    // THEN:  Result definition type name is Double
    //____________________________________________________________
	@Test
	public void test_getArrangeVariableDefinition_DefinitionTypeNameDouble() {
		// Arrange
		Declaration declaration = new Declaration("double", "valueVar");
		
		ValueType valueType = new DoubleType();
		valueType.setValue("5D");
		
		ArrangeDefinition definition = new ArrangeDefinition(valueType);
		
		ArrangeStatement arrangeStatement = new ArrangeStatement(declaration, definition);
		
		// Act
		VariableDefinition result = sut.getArrangeVariableDefinition(arrangeStatement);
		NamedTypeReference defType = (NamedTypeReference) result.getDefinitionType();
		Name name = defType.getTypeName();
		
		//Assert
		assertEquals("double", name.getNameString());
	}
	
	
	
}
