package com.dsl.tests.logic;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import static com.dsl.factories.AggregatesFactory.createFunction;
import static com.dsl.factories.ModifiersFactory.createModifier;
import static com.dsl.factories.ReturnsFactory.createPrimitiveReturn;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.logic.programscopes.action.IFunctionActionHandler;
import com.dsl.logic.programscopes.arrange.IFunctionArrangeHandler;
import com.dsl.logic.programscopes.asserts.IFunctionAssertHandler;
import com.dsl.logic.programscopes.body.FunctionBodyHandler;
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
import com.dsl.models.unittests.UnitTest;
import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;
import com.dsl.models.unittests.acts.InstanceAct;
import com.dsl.models.unittests.acts.StaticAct;
import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.arranges.ArrangeDefinition;
import com.dsl.models.unittests.arranges.ArrangeStatement;
import com.dsl.models.unittests.asserts.Assert;
import com.dsl.models.unittests.asserts.AssertExpression;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.unittests.asserts.types.java.JavaAreEqual;
import com.dsl.models.valuetypes.StringType;
import com.dsl.models.valuetypes.ValueType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.DefintionObject;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;
import ASTMCore.ASTMSyntax.Statement.BlockStatement;
import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;
import ASTMCore.ASTMSyntax.Statement.ExpressionStatement;
import ASTMCore.ASTMSyntax.Statement.Statement;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;



@ExtendWith(MockitoExtension.class)
public class FunctionBodyHandlerTests {

	@Mock
	private IFunctionArrangeHandler _arrangeHandler;
	
	@Mock
	private IFunctionActionHandler _actionHandler;
	
	@Mock
	private IFunctionAssertHandler _assertHandler;
	
	@InjectMocks
	private FunctionBodyHandler sut;
	


	//_____________________________________________
    // test_processFunctionBody_NotNull
    //
    // GIVEN: UnitTest is correctly provided
    // WHEN:  processFunctionBody is called
    // THEN:  Body Statement is not null
    //_____________________________________________
	@Test
	public void test_processFunctionBody_NotNull() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		ActNewType actNewType = new ActNewType("ClassName", "sut");
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new InstanceAct(actNewType, actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementNew = new DeclarationOrDefinitionStatement();
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementNewType(actNewType))
			.thenReturn(decOrDefStatementNew);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		Statement result = sut.processFunctionBody(unitTest);
		
		// Assert
		assertNotNull(result);
	}

	//_____________________________________________
    // test_processFunctionBody_BlockStatementType
    //
    // GIVEN: UnitTest is correctly provided
    // WHEN:  processFunctionBody is called
    // THEN:  Body Statement is block statement
    //_____________________________________________
	@Test
	public void test_processFunctionBody_BlockStatementType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		ActNewType actNewType = new ActNewType("ClassName", "sut");
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new InstanceAct(actNewType, actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementNew = new DeclarationOrDefinitionStatement();
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementNewType(actNewType))
			.thenReturn(decOrDefStatementNew);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		Statement result = sut.processFunctionBody(unitTest);
		
		// Assert
		assertTrue(result instanceof BlockStatement);
	}	
	
	
	//_____________________________________________
    // test_processFunctionBody_Instance_SubStatementSize
    //
    // GIVEN: UnitTest is correctly provided
    // WHEN:  processFunctionBody is called
	// AND:   function being processed is instance
    // THEN:  Body Statements has 4 elements
    //_____________________________________________
	@Test
	public void test_processFunctionBody_Instance_SubStatementSize() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		ActNewType actNewType = new ActNewType("ClassName", "sut");
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new InstanceAct(actNewType, actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementNew = new DeclarationOrDefinitionStatement();
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementNewType(actNewType))
			.thenReturn(decOrDefStatementNew);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		BlockStatement result = (BlockStatement) sut.processFunctionBody(unitTest);
		ArrayList<Statement> subStatements = result.getSubStatements();
		
		// Assert
		assertEquals(4, subStatements.size());
	}
	

	//_____________________________________________
    // test_processFunctionBody_Static_SubStatementSize
    //
    // GIVEN: UnitTest is correctly provided
    // WHEN:  processFunctionBody is called
	// AND:   function being processed is static
    // THEN:  Body Statements has 3 elements
    //_____________________________________________
	@Test
	public void test_processFunctionBody_Static_SubStatementSize() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.setStatic(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new StaticAct(actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		BlockStatement result = (BlockStatement) sut.processFunctionBody(unitTest);
		ArrayList<Statement> subStatements = result.getSubStatements();
		
		// Assert
		assertEquals(3, subStatements.size());
	}
	

	//_____________________________________________
    // test_processFunctionBody_Arrange_DecOrDefStatement_Type
    //
    // GIVEN: UnitTest is correctly provided
    // WHEN:  processFunctionBody is called
    // THEN:  Body Statements arrange type match
    //_____________________________________________
	@Test
	public void test_processFunctionBody_Arrange_DecOrDefStatement_Type() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		ActNewType actNewType = new ActNewType("ClassName", "sut");
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new InstanceAct(actNewType, actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementNew = new DeclarationOrDefinitionStatement();
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementNewType(actNewType))
			.thenReturn(decOrDefStatementNew);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		BlockStatement result = (BlockStatement) sut.processFunctionBody(unitTest);
		ArrayList<Statement> subStatements = result.getSubStatements();
		Statement statement = subStatements.get(0);
		
		// Assert
		assertTrue(statement instanceof DeclarationOrDefinitionStatement);
	}

	//_____________________________________________
    // test_processFunctionBody_Arrange_DecOrDefStatement_VarDef
    //
    // GIVEN: UnitTest is correctly provided
    // WHEN:  processFunctionBody is called
    // THEN:  Body Statements arrange var type match
    //_____________________________________________
	@Test
	public void test_processFunctionBody_Arrange_DecOrDefStatement_VarDef() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		ActNewType actNewType = new ActNewType("ClassName", "sut");
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new InstanceAct(actNewType, actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementNew = new DeclarationOrDefinitionStatement();
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementNewType(actNewType))
			.thenReturn(decOrDefStatementNew);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		BlockStatement result = (BlockStatement) sut.processFunctionBody(unitTest);
		ArrayList<Statement> subStatements = result.getSubStatements();
		DeclarationOrDefinitionStatement statement = (DeclarationOrDefinitionStatement) subStatements.get(0);
		DefintionObject objDefinition = statement.getDeclOrDefn();
		
		// Assert
		assertTrue(objDefinition instanceof VariableDefinition);
	}


	
	

	
	//_____________________________________________
    // test_processFunctionBody_ActionInstanceDecOrDefStatement_NewType
    //
    // GIVEN: UnitTest is correctly provided
	// AND:   function processed is an instance
    // WHEN:  processFunctionBody is called
    // THEN:  Body Statements action type match
    //_____________________________________________
	@Test
	public void test_processFunctionBody_ActionInstance_DecOrDefStatement_NewType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		ActNewType actNewType = new ActNewType("ClassName", "sut");
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new InstanceAct(actNewType, actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementNew = new DeclarationOrDefinitionStatement();
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementNewType(actNewType))
			.thenReturn(decOrDefStatementNew);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		BlockStatement result = (BlockStatement) sut.processFunctionBody(unitTest);
		ArrayList<Statement> subStatements = result.getSubStatements();
		Statement statement = subStatements.get(1);
		
		// Assert
		assertTrue(statement instanceof DeclarationOrDefinitionStatement);
	}
	
	
	//_____________________________________________
    // test_processFunctionBody_ActionInstance_DecOrDefStatementExec_Type
    //
    // GIVEN: UnitTest is correctly provided
    // WHEN:  processFunctionBody is called
    // THEN:  Body Statements action type match
    //_____________________________________________
	@Test
	public void test_processFunctionBody_ActionInstance_DecOrDefStatementExec_Type() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		ActNewType actNewType = new ActNewType("ClassName", "sut");
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new InstanceAct(actNewType, actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementNew = new DeclarationOrDefinitionStatement();
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementNewType(actNewType))
			.thenReturn(decOrDefStatementNew);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		BlockStatement result = (BlockStatement) sut.processFunctionBody(unitTest);
		ArrayList<Statement> subStatements = result.getSubStatements();
		Statement statement = subStatements.get(2);
		
		// Assert
		assertTrue(statement instanceof DeclarationOrDefinitionStatement);
	}

	
	//_____________________________________________
    // test_processFunctionBody_ActionStatic_DecOrDefStatementExec_Type
    //
    // GIVEN: UnitTest is correctly provided
	// AND:   function processed is a static
    // WHEN:  processFunctionBody is called
    // THEN:  Body Statements action type match
    //_____________________________________________
	@Test
	public void test_processFunctionBody_ActionStatic_DecOrDefStatementExec_Type() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new StaticAct(actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		BlockStatement result = (BlockStatement) sut.processFunctionBody(unitTest);
		ArrayList<Statement> subStatements = result.getSubStatements();
		Statement statement = subStatements.get(1);
		
		// Assert
		assertTrue(statement instanceof DeclarationOrDefinitionStatement);
	}
	
	
	//_____________________________________________
    // test_processFunctionBody_Assert_ExpressionStatement
    //
    // GIVEN: UnitTest is correctly provided
	// AND:   function processed is a static
    // WHEN:  processFunctionBody is called
    // THEN:  Body Statements assert type match
    //_____________________________________________
	@Test
	public void test_processFunctionBody_Assert_ExpressionStatement() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException {
		// Arrange test scenario
		String testName = "testName";
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));    	
    	function.setName("functionName");
    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);
    	String dslAssert = "areEqual";
    	AssertType assertType = new JavaAreEqual();
		TestScenario testScenario = new TestScenario(testName, function, parameterScenarios, expectedResult, dslAssert, assertType);
    	
		
		// Arrange arrange object
		ValueType arrangeValueType = new StringType();
		arrangeValueType.setValue("John");
		Declaration arrangeDeclaration = new Declaration("String", "expected");
		ArrangeDefinition arrangeDefinition = new ArrangeDefinition(arrangeValueType);
		ArrayList<ArrangeStatement> arrangeStatements = new ArrayList<ArrangeStatement>() {
			{
				add(new ArrangeStatement(arrangeDeclaration, arrangeDefinition));
			}
		};
		Arrange arrange = new Arrange(arrangeStatements);
		
		
		// Arrange action object
		Declaration actDeclaration = new Declaration("String", "result");
		String actCalledFunction = "sut";
    	String actFunctionName = "functionName";
	    ArrayList<FunctionArgument> actArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("firstName"));
	    	}
	    };
		ActExecution actExecution = new ActExecution(actDeclaration, actCalledFunction, actFunctionName, actArguments);
		Act act = new StaticAct(actExecution);
		
		
		// Arrange assertion object
		String assertCalledFunction = "assertEquals";
	    ArrayList<FunctionArgument> assertArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
	    AssertExpression assertExpression = new AssertExpression(assertCalledFunction, assertType, assertArguments);
	    ArrayList<AssertExpression> assertExpressions = new ArrayList<AssertExpression>() {
	    	{
	    		add(assertExpression);
	    	}
	    };
	    Assert assertion = new Assert(assertExpressions);
		
	    
		// Arrange unit test
		UnitTest unitTest = new UnitTest("Java", testScenario, arrange, act, assertion);
		
		
		// Mock interfaces
		VariableDefinition varDefinition = new VariableDefinition();
		varDefinition.setFragments(new ArrayList<Fragment>());
		varDefinition.setDefinitionType(new NamedTypeReference());
		
		DeclarationOrDefinitionStatement decOrDefStatementExec = new DeclarationOrDefinitionStatement();
		Expression expression = new FunctionCallExpression();
		
		when(_arrangeHandler.getArrangeVariableDefinition(arrangeStatements.get(0)))
			.thenReturn(varDefinition);
		
		when(_actionHandler.getDeclOrDefStatementExecution(actExecution))
			.thenReturn(decOrDefStatementExec);
		
		when(_assertHandler.getAssertExpression(assertExpression))
			.thenReturn(expression);
		
		// Act
		BlockStatement result = (BlockStatement) sut.processFunctionBody(unitTest);
		ArrayList<Statement> subStatements = result.getSubStatements();
		Statement statement = subStatements.get(2);
		
		// Assert
		assertTrue(statement instanceof ExpressionStatement);
	}
	
	
	
	
}
