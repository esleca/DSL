package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.dsl.logic.programscopes.IFunctionAssertHandler;
import com.dsl.logic.programscopes.FunctionAssertHandler;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.asserts.AssertExpression;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.unittests.asserts.types.csharp.CSharpAreEqual;
import com.dsl.models.unittests.asserts.types.csharp.CSharpAreNotEqual;
import com.dsl.models.unittests.asserts.types.csharp.CSharpIsFalse;
import com.dsl.models.unittests.asserts.types.csharp.CSharpIsNotNull;
import com.dsl.models.unittests.asserts.types.csharp.CSharpIsNull;
import com.dsl.models.unittests.asserts.types.csharp.CSharpIsTrue;
import com.dsl.models.unittests.asserts.types.java.JavaAreEqual;
import com.dsl.models.unittests.asserts.types.java.JavaAreNotEqual;
import com.dsl.models.unittests.asserts.types.java.JavaIsFalse;
import com.dsl.models.unittests.asserts.types.java.JavaIsNotNull;
import com.dsl.models.unittests.asserts.types.java.JavaIsNull;
import com.dsl.models.unittests.asserts.types.java.JavaIsTrue;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;
import ASTMCore.ASTMSyntax.Expression.ActualParameterExpression;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;
import ASTMCore.ASTMSyntax.Expression.IdentifierReference;



public class FunctionAssertHandlerTests {

	private IFunctionAssertHandler sut = new FunctionAssertHandler();
	

	//_________________________________________________
    // test_getAssertExpression_ResultNotNull
    //
    // GIVEN: Java are equals assert is invoked
    // WHEN:  getAssertExpression is executed
    // THEN:  Result is not null
    //_________________________________________________
	@Test
	public void test_getAssertExpression_ResultNotNull() {
		// Arrange
		String calledFunction = "";
		AssertType assertType = new JavaAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		Expression result = sut.getAssertExpression(assertExpression);
		
		// Assert
		assertNotNull(result);
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_FunctionCallExpression
    //
    // GIVEN: Java are equals assert is invoked
    // WHEN:  getAssertExpression is executed
    // THEN:  Result expressions is a function call
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionCallExpression() {
		// Arrange
		String calledFunction = "";
		AssertType assertType = new JavaAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		Expression result = sut.getAssertExpression(assertExpression);

		// Assert
		assertTrue(result instanceof FunctionCallExpression);
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_CalledFunctionNull
    //
    // GIVEN: Java are equals assert is invoked
	// AND:   No calledFunction is given
    // WHEN:  getAssertExpression is executed
    // THEN:  Result called function is null
    //_________________________________________________
	@Test
	public void test_getAssertExpression_CalledFunctionNull() {
		// Arrange
		String calledFunction = "";
		AssertType assertType = new JavaAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Expression identifierReference = result.getCalledFunction();
		
		// Assert
		assertNull(identifierReference);
	}

	
	//_________________________________________________
    // test_getAssertExpression_CalledFunctionNotNull
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   CalledFunction is given
    // WHEN:  getAssertExpression is executed
    // THEN:  Result called function is not null
    //_________________________________________________
	@Test
	public void test_getAssertExpression_CalledFunctionNotNull() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Expression identifierReference = result.getCalledFunction();
		
		// Assert
		assertNotNull(identifierReference);
	}

	
	//_________________________________________________
    // test_getAssertExpression_CalledFunctionNameNotNull
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   CalledFunction is given
    // WHEN:  getAssertExpression is executed
    // THEN:  Result called function name is not null
    //_________________________________________________
	@Test
	public void test_getAssertExpression_CalledFunctionNameNotNull() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		IdentifierReference identifierReference = (IdentifierReference) result.getCalledFunction();
		
		Name name = identifierReference.getIdentifierName();
		
		// Assert
		assertNotNull(name);
	}

	
	//_________________________________________________
    // test_getAssertExpression_CalledFunctionValue_Csharp
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   CalledFunction is given
    // WHEN:  getAssertExpression is executed
    // THEN:  Result called function is AreEqual
    //_________________________________________________
	@Test
	public void test_getAssertExpression_CalledFunctionValue_Csharp() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		IdentifierReference identifierReference = (IdentifierReference) result.getCalledFunction();
		
		Name name = identifierReference.getIdentifierName();
		
		// Assert
		assertEquals("Assert", name.getNameString());
	}

	
	//_________________________________________________
    // test_getAssertExpression_CalledFunctionValue_JavaNull
    //
    // GIVEN: CSharp AreEquals assert is invoked
    // WHEN:  getAssertExpression is executed
    // THEN:  Result called function is assertEquals
    //_________________________________________________
	@Test
	public void test_getAssertExpression_CalledFunctionValue_JavaNull() {
		// Arrange
		String calledFunction = "";
		AssertType assertType = new JavaAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		IdentifierReference identifierReference = (IdentifierReference) result.getCalledFunction();
		
		// Assert
		assertNull(identifierReference);
	}

	
	
	//_________________________________________________
    // test_getAssertExpression_ActualParamsNotNull
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Result Actual Parameters are not null
    //_________________________________________________
	@Test
	public void test_getAssertExpression_ActualParamsNotNull() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		ArrayList<ActualParameter> parameters = result.getActualParams();
		
		// Assert
		assertNotNull(parameters);
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_ActualParamsSize
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Result Actual Parameters have 2 elements
    //_________________________________________________
	@Test
	public void test_getAssertExpression_ActualParamsSize() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		ArrayList<ActualParameter> parameters = result.getActualParams();
		
		// Assert
		assertEquals(2, parameters.size());
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_ActualParamFirstNotNull
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Actual Parameters 1 is not null
    //_________________________________________________
	@Test
	public void test_getAssertExpression_ActualParamFirstNotNull() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		ArrayList<ActualParameter> parameters = result.getActualParams();
		
		ActualParameterExpression parameter = (ActualParameterExpression) parameters.get(0);
		
		// Assert
		assertNotNull(parameter);
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_ActualParamSecondNotNull
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Actual Parameters 2 is not null
    //_________________________________________________
	@Test
	public void test_getAssertExpression_ActualParamSecondNotNull() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		ArrayList<ActualParameter> parameters = result.getActualParams();
		
		ActualParameterExpression parameter = (ActualParameterExpression) parameters.get(1);
		
		// Assert
		assertNotNull(parameter);
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_ActualParamFirstValue
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Actual Parameters 1 is expected
    //_________________________________________________
	@Test
	public void test_getAssertExpression_ActualParamFirstValue() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		ArrayList<ActualParameter> parameters = result.getActualParams();
		
		ActualParameterExpression parameter = (ActualParameterExpression) parameters.get(0);
		
		IdentifierReference identifier = (IdentifierReference) parameter.getValue();
		
		Name name = identifier.getIdentifierName();
		
		// Assert
		assertEquals("expected", name.getNameString());
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_ActualParamSecondValue
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Actual Parameters 2 is expected
    //_________________________________________________
	@Test
	public void test_getAssertExpression_ActualParamSecondValue() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		ArrayList<ActualParameter> parameters = result.getActualParams();
		
		ActualParameterExpression parameter = (ActualParameterExpression) parameters.get(1);
		
		IdentifierReference identifier = (IdentifierReference) parameter.getValue();
		
		Name name = identifier.getIdentifierName();
		
		// Assert
		assertEquals("result", name.getNameString());
	}
	
	

	
	//_________________________________________________
    // test_getAssertExpression_FunctionNameNotNull
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Result Actual Parameters are not null
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionNameNotNull() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertNotNull(name);
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_FunctionName_AreEqual
    //
    // GIVEN: CSharp AreEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is AreEqual
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_AreEqual() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("AreEqual", name.getNameString());
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_FunctionName_AreNotEqual
    //
    // GIVEN: CSharp AreNotEqual assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is AreNotEqual
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_AreNotEqual() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpAreNotEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("AreNotEqual", name.getNameString());
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_FunctionName_IsFalse
    //
    // GIVEN: CSharp IsFalse assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is IsFalse
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_IsFalse() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpIsFalse();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("IsFalse", name.getNameString());
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_FunctionName_IsNotNull
    //
    // GIVEN: CSharp IsNotNull assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is IsNotNull
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_IsNotNull() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpIsNotNull();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("IsNotNull", name.getNameString());
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_FunctionName_IsNull
    //
    // GIVEN: CSharp IsNull assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is IsNull
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_IsNull() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpIsNull();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("IsNull", name.getNameString());
	}
	
	
	//_________________________________________________
    // test_getAssertExpression_FunctionName_IsTrue
    //
    // GIVEN: CSharp IsTrue assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is IsTrue
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_IsTrue() {
		// Arrange
		String calledFunction = "Assert";
		AssertType assertType = new CSharpIsTrue();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(calledFunction, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("IsTrue", name.getNameString());
	}
	
	
	
	/* Java Asserts */
	
	//_________________________________________________
    // test_getAssertExpression_FunctionName_AssertEquals
    //
    // GIVEN: Java assertEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is assertEquals
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_AssertEquals() {
		// Arrange
		AssertType assertType = new JavaAreEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(null, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("assertEquals", name.getNameString());
	}
	

	//_________________________________________________
    // test_getAssertExpression_FunctionName_AssertNotEquals
    //
    // GIVEN: Java assertNotEquals assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is assertNotEquals
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_AssertNotEquals() {
		// Arrange
		AssertType assertType = new JavaAreNotEqual();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(null, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("assertNotEquals", name.getNameString());
	}
	

	//_________________________________________________
    // test_getAssertExpression_FunctionName_AssertIsFalse
    //
    // GIVEN: Java AssertIsFalse assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is assertFalse
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_AssertIsFalse() {
		// Arrange
		AssertType assertType = new JavaIsFalse();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(null, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("assertFalse", name.getNameString());
	}
	

	//_________________________________________________
    // test_getAssertExpression_FunctionName_AssertNotNull
    //
    // GIVEN: Java assertNotNull assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is assertNotNull
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_AssertNotNull() {
		// Arrange
		AssertType assertType = new JavaIsNotNull();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(null, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("assertNotNull", name.getNameString());
	}
	

	//_________________________________________________
    // test_getAssertExpression_FunctionName_AssertNull
    //
    // GIVEN: Java AssertNull assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is assertNull
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_AssertNull() {
		// Arrange
		AssertType assertType = new JavaIsNull();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(null, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("assertNull", name.getNameString());
	}
	

	//_________________________________________________
    // test_getAssertExpression_FunctionName_AssertTrue
    //
    // GIVEN: Java assertTrue assert is invoked
	// AND:   Parameters are given
    // WHEN:  getAssertExpression is executed
    // THEN:  Function name is assertTrue
    //_________________________________________________
	@Test
	public void test_getAssertExpression_FunctionName_AssertTrue() {
		// Arrange
		AssertType assertType = new JavaIsTrue();
	    ArrayList<FunctionArgument> functionArguments = new ArrayList<FunctionArgument>(){
	    	{
	    		add(new FunctionArgument("expected"));
	    		add(new FunctionArgument("result"));
	    	}
	    };
		
		AssertExpression assertExpression = new AssertExpression(null, assertType, functionArguments);
		
		// Act
		FunctionCallExpression result = (FunctionCallExpression) sut.getAssertExpression(assertExpression);

		Name name = result.getFunctionName();
		
		// Assert
		assertEquals("assertTrue", name.getNameString());
	}
	
	
	
}
