package com.dsl.tests.logic;

import static com.dsl.factories.AggregatesFactory.createFunction;
import static com.dsl.factories.ModifiersFactory.createModifier;
import static com.dsl.factories.ReturnsFactory.createPrimitiveReturn;
import static com.dsl.factories.ValueTypeFactory.createValueType;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.logic.unittests.asserts.IUnitTestAssertHandler;
import com.dsl.logic.unittests.asserts.UnitTestAssertHandler;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.ExpectedResultPrimitive;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.Assert;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.unittests.asserts.types.csharp.CSharpAreEqual;
import com.dsl.models.unittests.asserts.types.java.JavaAreEqual;
import com.dsl.models.valuetypes.ValueType;
import gastmappers.exceptions.UnsupportedLanguageException;


public class UnitTestAssertHandlerTests {
	
	private IUnitTestAssertHandler sut = new UnitTestAssertHandler();
	

	//_________________________________________________
    // test_processUnitTestAssert_Java_notNull
    //
    // GIVEN: Unit test scenario is provisioned
	// AND:   Language provided is Java
    // WHEN:  processUnitTestAssert is called
    // THEN:  Assert result is not null
    //_________________________________________________
	@Test
	public void test_processUnitTestAssert_Java_notNull() throws ValueTypeNotFoundException, ModifierNotFoundException, ReturnNotFoundException, AssertNotFoundException, UnsupportedLanguageException {
		// Arrange
		String testName = "testName";
		String language = "Java";
    	
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));

    	ValueType expected = createValueType("String", "John");
    	
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
    	
		// Action 
    	Assert assertionRes = sut.processUnitTestAssert(testScenario, language);
	
    	// Assert
    	assertNotNull(assertionRes);
	}
	
	
	//_________________________________________________
    // test_processUnitTestAssert_CSharp_notNull
    //
    // GIVEN: Unit test scenario is provisioned
	// AND:   Language provided is CSharp
    // WHEN:  processUnitTestAssert is called
    // THEN:  Assert result is not null
    //_________________________________________________
	@Test
	public void test_processUnitTestAssert_CSharp_notNull() throws ValueTypeNotFoundException, ModifierNotFoundException, ReturnNotFoundException, AssertNotFoundException, UnsupportedLanguageException {
		// Arrange
		String testName = "testName";
		String language = "Java";
    	
		Function function = createFunction(new Class("CSharp", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(false);
    	function.setReturn(createPrimitiveReturn("String"));
    	function.addModifier(createModifier("public"));

    	ValueType expected = createValueType("String", "John");
    	
    	ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		ExpectedResult expectedResult = new ExpectedResultPrimitive(expected);

		String assertion = "areEqual";
    	AssertType assertType = new CSharpAreEqual();
    	
    	TestScenario testScenario = new TestScenario
    			(testName, function, parameterScenarios, expectedResult, assertion, assertType);		
    	
		// Action 
    	Assert assertionRes = sut.processUnitTestAssert(testScenario, language);
	
    	// Assert
    	assertNotNull(assertionRes);
	}


}
