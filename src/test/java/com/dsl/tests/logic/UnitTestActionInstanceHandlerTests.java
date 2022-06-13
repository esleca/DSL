package com.dsl.tests.logic;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static com.dsl.factories.AggregatesFactory.createFunction;
import static com.dsl.factories.ModifiersFactory.createModifier;
import static com.dsl.factories.ReturnsFactory.createPrimitiveReturn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.logic.unittests.action.UnitTestActionBaseHandler;
import com.dsl.logic.unittests.action.UnitTestActionInstanceHandler;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.ExpectedResultPrimitive;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;
import com.dsl.models.unittests.acts.InstanceAct;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.unittests.asserts.types.java.JavaAreEqual;
import com.dsl.models.valuetypes.ValueType;


public class UnitTestActionInstanceHandlerTests {
	

	private UnitTestActionBaseHandler sut = new UnitTestActionInstanceHandler();
	
	
	//_________________________________________________
    // test_processUnitTestAct_ActNotNull
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act result is not null
    //_________________________________________________
	@Test
	public void test_processUnitTestAct_ActNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		
		//Assert
		assertNotNull(act);
	}
	
	
	//_________________________________________________
    // test_processUnitTestAct_InstanceActTypeOf
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act result is of type InstanceAct
    //_________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceActTypeOf() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		
		//Assert
		assertTrue(act instanceof InstanceAct);
	}

	
	//_______________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecutionNotNull
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result is not null
    //_______________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecutionNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		
		//Assert
		assertNotNull(actExecution);
	}

	
	//___________________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecution_DeclarationNotNull
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result declaration is not null
    //___________________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecution_DeclarationNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		Declaration declaration = actExecution.getDeclaration();
		
		//Assert
		assertNotNull(declaration);
	}

	
	//________________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecution_DeclarationType
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result declaration type is String
    //________________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecution_DeclarationType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		Declaration declaration = actExecution.getDeclaration();
		String type = declaration.getType();
		
		//Assert
		assertEquals("String", type);
	}

	
	//________________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecution_DeclarationName
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result declaration name is result
    //________________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecution_DeclarationName() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		Declaration declaration = actExecution.getDeclaration();
		String name = declaration.getName();
		
		//Assert
		assertEquals("result", name);
	}

	
	//______________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecution_CalledFunction
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result called function is sut
    //______________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecution_CalledFunction() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		String calledFunction = actExecution.getCalledFunction();
		
		//Assert
		assertEquals("sut", calledFunction);
	}

	
	//____________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecution_FunctionName
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result called function is functionName
    //____________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecution_FunctionName() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		String functionName = actExecution.getFunctionName();
		
		//Assert
		assertEquals("functionName", functionName);
	}

	
	//___________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecution_ArgsNotNull
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result arguments are not null
    //___________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecution_ArgsNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		ArrayList<FunctionArgument> functionArguments = actExecution.getFunctionArguments();
		
		//Assert
		assertNotNull(functionArguments);
	}

	
	//__________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecution_ArgNotNull
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result argument is not null
    //__________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecution_ArgNotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		ArrayList<FunctionArgument> functionArguments = actExecution.getFunctionArguments();
		FunctionArgument functionArgument = functionArguments.get(0);
		
		//Assert
		assertNotNull(functionArgument);
	}

	
	//__________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActExecution_ArgValue
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act execution result argument value is firstName
    //__________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActExecution_ArgValue() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
		Act act = sut.processUnitTestAct(testScenario);
		ActExecution actExecution = act.getActExecution();
		ArrayList<FunctionArgument> functionArguments = actExecution.getFunctionArguments();
		FunctionArgument functionArgument = functionArguments.get(0);
		String argValue = functionArgument.getValue();
		
		//Assert
		assertEquals("firstName", argValue);
	}
	
	
	
	/**** ActNewType unit tests ****/
	


	
	//__________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActNewType_NotNull
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act new type is not null
    //__________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActNewType_NotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
    	InstanceAct act = (InstanceAct) sut.processUnitTestAct(testScenario);
    	ActNewType actNewType = act.getActNewType();
		
		//Assert
		assertNotNull(actNewType);
	}
	
	
	//__________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActNewType_Type
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act new type is valid className
    //__________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActNewType_Type() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
    	InstanceAct act = (InstanceAct) sut.processUnitTestAct(testScenario);
    	ActNewType actNewType = act.getActNewType();
    	String type = actNewType.getType();
		
		//Assert
		assertEquals("ClassName", type);
	}
	
	
	//__________________________________________________________
    // test_processUnitTestAct_InstanceAct_ActNewType_Name
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act new type name is valid sut
    //__________________________________________________________
	@Test
	public void test_processUnitTestAct_InstanceAct_ActNewType_Name() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
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
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);
		
		//Action 
    	InstanceAct act = (InstanceAct) sut.processUnitTestAct(testScenario);
    	ActNewType actNewType = act.getActNewType();
    	String name = actNewType.getName();
		
		//Assert
		assertEquals("sut", name);
	}
	
	
}
