package com.dsl.tests.logic;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static com.dsl.factories.AggregatesFactory.createFunction;
import static com.dsl.factories.ModifiersFactory.createModifier;
import static com.dsl.factories.ReturnsFactory.createPrimitiveReturn;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.logic.unittests.asserts.UnitTestAssertBaseHandler;
import com.dsl.logic.unittests.asserts.UnitTestAssertCSharpHandler;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.ExpectedResultPrimitive;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.Assert;
import com.dsl.models.unittests.asserts.AssertExpression;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.unittests.asserts.types.csharp.CSharpAreEqual;
import com.dsl.models.unittests.asserts.types.csharp.CSharpAreNotEqual;
import com.dsl.models.unittests.asserts.types.csharp.CSharpIsFalse;
import com.dsl.models.unittests.asserts.types.csharp.CSharpIsNotNull;
import com.dsl.models.unittests.asserts.types.csharp.CSharpIsNull;
import com.dsl.models.unittests.asserts.types.csharp.CSharpIsTrue;
import com.dsl.models.valuetypes.ValueType;


public class UnitTestAssertCSharpHandlerTests {
	
	private UnitTestAssertBaseHandler sut = new UnitTestAssertCSharpHandler();
	
	
	//__________________________________________________________
    // test_processUnitTestAssert_NotNull
    //
    // GIVEN: a test scenario is provisioned
    // WHEN:  processUnitTestAssert is called
    // THEN:  result is not null
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_NotNull() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		
		//Assert
    	assertNotNull(resultAssert);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionsNotNull
    //
    // GIVEN: a test scenario is provisioned
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expressions are not null
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionsNotNull() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		
		//Assert
    	assertNotNull(expressions);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionsSizeOne
    //
    // GIVEN: a test scenario is provisioned
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expressions size is one
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionsSizeOne() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		
		//Assert
    	assertEquals(1, expressions.size());
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionNotNull
    //
    // GIVEN: a test scenario is provisioned
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expressions first element is not null
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionNotNull() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		
		//Assert
    	assertNotNull(expression);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionCalledFunction
    //
    // GIVEN: a test scenario is provisioned
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression called function match
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionCalledFunction() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		String calledFunction = expression.getCalledFunction();
		
		//Assert
    	assertEquals("Assert", calledFunction);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_Expression_AssertTypeNotNull
    //
    // GIVEN: a test scenario is provisioned
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression assert type is not null
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_Expression_AssertTypeNotNull() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		AssertType assertTypeRes = expression.getAssertType();
		
		//Assert
    	assertNotNull(assertTypeRes);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionAssertType_AreEqual
    //
    // GIVEN: a test scenario is provisioned
	// AND:   CSharpAreEqual assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression assert name is AreEqual
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionAssertType_AreEqual() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		CSharpAreEqual assertTypeRes = (CSharpAreEqual) expression.getAssertType();
		String assertTypeName = assertTypeRes.getName();
		
		//Assert
    	assertEquals("AreEqual", assertTypeName);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionAssertType_AreNotEqual
    //
    // GIVEN: a test scenario is provisioned
	// AND:   areNotEqual assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression assert name is AreNotEqual
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionAssertType_AreNotEqual() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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

    	String assertion = "areNotEqual";
    	AssertType assertType = new CSharpAreNotEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		CSharpAreNotEqual assertTypeRes = (CSharpAreNotEqual) expression.getAssertType();
		String assertTypeName = assertTypeRes.getName();
		
		//Assert
    	assertEquals("AreNotEqual", assertTypeName);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionAssertType_IsTrue
    //
    // GIVEN: a test scenario is provisioned
	// AND:   isTrue assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression assert name is IsTrue
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionAssertType_IsTrue() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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

    	String assertion = "isTrue";
    	AssertType assertType = new CSharpIsTrue();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		CSharpIsTrue assertTypeRes = (CSharpIsTrue) expression.getAssertType();
		String assertTypeName = assertTypeRes.getName();
		
		//Assert
    	assertEquals("IsTrue", assertTypeName);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionAssertType_IsFalse
    //
    // GIVEN: a test scenario is provisioned
	// AND:   isFalse assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression assert name is IsFalse
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionAssertType_IsFalse() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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

    	String assertion = "isFalse";
    	AssertType assertType = new CSharpIsFalse();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		CSharpIsFalse assertTypeRes = (CSharpIsFalse) expression.getAssertType();
		String assertTypeName = assertTypeRes.getName();
		
		//Assert
    	assertEquals("IsFalse", assertTypeName);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionAssertType_IsNull
    //
    // GIVEN: a test scenario is provisioned
	// AND:   isNull assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression assert name is IsNull
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionAssertType_IsNull() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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

    	String assertion = "isNull";
    	AssertType assertType = new CSharpIsNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		CSharpIsNull assertTypeRes = (CSharpIsNull) expression.getAssertType();
		String assertTypeName = assertTypeRes.getName();
		
		//Assert
    	assertEquals("IsNull", assertTypeName);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionAssertType_IsNotNull
    //
    // GIVEN: a test scenario is provisioned
	// AND:   isNotNull assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression assert name is IsNotNull
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionAssertType_IsNotNull() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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

    	String assertion = "isNotNull";
    	AssertType assertType = new CSharpIsNotNull();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		CSharpIsNotNull assertTypeRes = (CSharpIsNotNull) expression.getAssertType();
		String assertTypeName = assertTypeRes.getName();
		
		//Assert
    	assertEquals("IsNotNull", assertTypeName);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionArguments_NotNull
    //
    // GIVEN: a test scenario is provisioned
	// AND:   areEqual assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression arguments are not null
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionArguments_NotNull() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		ArrayList<FunctionArgument> functionArguments = expression.getFunctionArguments();

		//Assert
    	assertNotNull(functionArguments);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionArguments_Size
    //
    // GIVEN: a test scenario is provisioned
	// AND:   areEqual assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression arguments size match
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionArguments_Size() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		ArrayList<FunctionArgument> functionArguments = expression.getFunctionArguments();

		//Assert
    	assertEquals(2, functionArguments.size());
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionArgument_NotNull
    //
    // GIVEN: a test scenario is provisioned
	// AND:   areEqual assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression arguments size match
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionArgument_NotNull() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		ArrayList<FunctionArgument> functionArguments = expression.getFunctionArguments();
		FunctionArgument functionArgument = functionArguments.get(0);

		//Assert
    	assertNotNull(functionArgument);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionArgument_ExpectedValue
    //
    // GIVEN: a test scenario is provisioned
	// AND:   areEqual assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression argument value match
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionArgument_ExpectedValue() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		ArrayList<FunctionArgument> functionArguments = expression.getFunctionArguments();
		FunctionArgument functionArgument = functionArguments.get(0);
		String value = functionArgument.getValue();
		
		//Assert
    	assertEquals("expected", value);
	}

	
	//__________________________________________________________
    // test_processUnitTestAssert_ExpressionArgument_ResultValue
    //
    // GIVEN: a test scenario is provisioned
	// AND:   areEqual assertType is provided
    // WHEN:  processUnitTestAssert is called
    // THEN:  result expression argument value match
    //__________________________________________________________
	@Test
	public void test_processUnitTestAssert_ExpressionArgument_ResultValue() throws AssertNotFoundException, ValueTypeNotFoundException, ReturnNotFoundException, ModifierNotFoundException {
		//Arrange
		String testName = "testName";
    	
    	Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
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
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Act
		Assert resultAssert = sut.processUnitTestAssert(testScenario);
		ArrayList<AssertExpression> expressions = resultAssert.getAssertExpressions();
		AssertExpression expression = expressions.get(0);
		ArrayList<FunctionArgument> functionArguments = expression.getFunctionArguments();
		FunctionArgument functionArgument = functionArguments.get(1);
		String value = functionArgument.getValue();
		
		//Assert
    	assertEquals("result", value);
	}
	
}
