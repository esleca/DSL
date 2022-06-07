package com.dsl.tests.logic;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static com.dsl.factories.AggregatesFactory.createFunction;
import static com.dsl.factories.ModifiersFactory.createModifier;
import static com.dsl.factories.ReturnsFactory.createPrimitiveReturn;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.logic.unittests.arrange.IUnitTestArrangeHandler;
import com.dsl.logic.unittests.arrange.UnitTestArrangeHandler;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.ExpectedResultPrimitive;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.arranges.ArrangeDefinition;
import com.dsl.models.unittests.arranges.ArrangeStatement;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.unittests.asserts.types.java.JavaAreEqual;
import com.dsl.models.unittests.asserts.types.java.JavaIsNull;
import com.dsl.models.valuetypes.ValueType;


public class UnitTestArrangeHandlerTests {
	
	private IUnitTestArrangeHandler sut = new UnitTestArrangeHandler();
	
	
	//__________________________________________________
    // test_processUnitTestArrange_notNull
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   All requested parameters are passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result is not null
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_notNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange32
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	
    	//Assert
    	assertNotNull(arrange);
	}
	
	
	//__________________________________________________
    // test_processUnitTestArrange_StatementsNotNull
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   All requested parameters are passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result statements are not null
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_StatementsNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	
    	ArrayList<ArrangeStatement> arranges = arrange.getArrangeStatements();
    	
    	//Assert
    	assertNotNull(arranges);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_SizeStatements
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result statements size is two
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_SizeStatements() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
    	//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	
    	ArrayList<ArrangeStatement> arranges = arrange.getArrangeStatements();
    	
    	//Assert
    	assertEquals(2, arranges.size());
	}
	
    
	//__________________________________________________
    // test_processUnitTestArrange_SizeStatements
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result statements size is two
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_SizeStatementsWithNoExpected() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType paramValue = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), paramValue));
			}
		};

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaIsNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, null, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	
    	ArrayList<ArrangeStatement> arranges = arrange.getArrangeStatements();
    	
    	//Assert
    	assertEquals(1, arranges.size());
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_DeclarationNotNull
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result declaration is not null
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_DeclarationNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType paramValue = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), paramValue));
			}
		};

    	String assertion = "isNull";
    	
    	AssertType assertType = new JavaIsNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, null, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(0);
    	Declaration declaration = arrangeStatement.getDeclaration();
    	
    	//Assert
    	assertNotNull(declaration);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_DeclarationType
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result declaration type match
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_DeclarationType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType paramValue = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), paramValue));
			}
		};

    	String assertion = "isNull";
    	
    	AssertType assertType = new JavaIsNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, null, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(0);
    	Declaration declaration = arrangeStatement.getDeclaration();
    	String declarationType = declaration.getType();
    	
    	//Assert
    	assertEquals("String", declarationType);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_DeclarationName
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result declaration name value match 
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_DeclarationName() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType paramValue = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), paramValue));
			}
		};

    	String assertion = "isNull";
    	
    	AssertType assertType = new JavaIsNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, null, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(0);
    	Declaration declaration = arrangeStatement.getDeclaration();
		String declarationName = declaration.getName();
    	
    	//Assert
    	assertEquals("firstName", declarationName);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_ArrangeDefinitionNotNull
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result ArrangeDefinition is not null
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_ArrangeDefinitionNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType paramValue = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), paramValue));
			}
		};

    	String assertion = "isNull";
    	
    	AssertType assertType = new JavaIsNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, null, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(0);
    	ArrangeDefinition arrangeDefinition = arrangeStatement.getDefinition();
    	
    	//Assert
    	assertNotNull(arrangeDefinition);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_ArrangeDefinitionType
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result ArrangeDefinition type match
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_ArrangeDefinitionType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType paramValue = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), paramValue));
			}
		};

    	String assertion = "isNull";
    	
    	AssertType assertType = new JavaIsNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, null, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(0);
    	ArrangeDefinition arrangeDefinition = arrangeStatement.getDefinition();
    	String arrangeDefinitionType = arrangeDefinition.getValueType().getType();
    	
    	//Assert
    	assertEquals("String", arrangeDefinitionType);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_ArrangeDefinitionValue
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result declaration name value match 
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_ArrangeDefinitionValue() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType paramValue = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), paramValue));
			}
		};

    	String assertion = "isNull";
    	
    	AssertType assertType = new JavaIsNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, null, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(0);
    	ArrangeDefinition arrangeDefinition = arrangeStatement.getDefinition();
    	String arrangeDefinitionValue = (String) arrangeDefinition.getValueType().getValue();
    	
    	//Assert
    	assertEquals("John", arrangeDefinitionValue);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_DeclarationWithExpectedNotNull
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result declaration is not null
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_DeclarationWithExpectedNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(1);
    	Declaration declaration = arrangeStatement.getDeclaration();
    	
    	//Assert
    	assertNotNull(declaration);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_DeclarationWithExpectedType
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result declaration type match
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_DeclarationWithExpectedType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(1);
    	Declaration declaration = arrangeStatement.getDeclaration();
    	String declarationType = declaration.getType();
    	
    	//Assert
    	assertEquals("String", declarationType);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_DeclarationWithExpectedName
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result declaration name value match 
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_DeclarationWithExpectedName() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(1);
    	Declaration declaration = arrangeStatement.getDeclaration();
		String declarationName = declaration.getName();
    	
    	//Assert
    	assertEquals("expected", declarationName);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_ArrangeDefinitionWithExpectedNotNull
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result ArrangeDefinition is not null
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_ArrangeDefinitionWithExpectedNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(1);
    	ArrangeDefinition arrangeDefinition = arrangeStatement.getDefinition();
    	
    	//Assert
    	assertNotNull(arrangeDefinition);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_ArrangeDefinitionWithExpectedType
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result ArrangeDefinition type match
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_ArrangeDefinitionWithExpectedType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(1);
    	ArrangeDefinition arrangeDefinition = arrangeStatement.getDefinition();
    	String arrangeDefinitionType = arrangeDefinition.getValueType().getType();
    	
    	//Assert
    	assertEquals("String", arrangeDefinitionType);
	}

	
	//__________________________________________________
    // test_processUnitTestArrange_ArrangeDefinitionWithExpectedValue
    //
    // GIVEN: UnitTestArrangeHandler is executed
	// AND:   One parameter is passed
    // WHEN:  processUnitTestArrange is called
    // THEN:  Result declaration name value match 
    //__________________________________________________
    @Test
	public void test_processUnitTestArrange_ArrangeDefinitionWithExpectedValue() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		//Arrange
    	String testName = "testName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));
    	
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

    	String assertion = "areEqual";
    	
    	AssertType assertType = new JavaAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
    	
    	//Act
    	Arrange arrange = sut.processUnitTestArrange(testScenario);
    	ArrangeStatement arrangeStatement = arrange.getArrangeStatements().get(1);
    	ArrangeDefinition arrangeDefinition = arrangeStatement.getDefinition();
    	String arrangeDefinitionValue = (String) arrangeDefinition.getValueType().getValue();
    	
    	//Assert
    	assertEquals("John", arrangeDefinitionValue);
	}
    
    
    
    
    
}
