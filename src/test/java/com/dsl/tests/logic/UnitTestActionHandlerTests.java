package com.dsl.tests.logic;

import static com.dsl.factories.AggregatesFactory.createFunction;
import static com.dsl.factories.ModifiersFactory.createModifier;
import static com.dsl.factories.ReturnsFactory.createPrimitiveReturn;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.logic.unittests.action.IUnitTestActionHandler;
import com.dsl.logic.unittests.action.UnitTestActionHandler;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.ExpectedResultPrimitive;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.acts.Act;
import com.dsl.models.unittests.acts.InstanceAct;
import com.dsl.models.unittests.acts.StaticAct;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.unittests.asserts.types.java.JavaAreEqual;
import com.dsl.models.valuetypes.ValueType;

public class UnitTestActionHandlerTests {

	
	private IUnitTestActionHandler sut = new UnitTestActionHandler();
	
	
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
    // test_processUnitTestAct_Act_InstanceType
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act result is of type InstanceAct
    //_________________________________________________
	@Test
	public void test_processUnitTestAct_Act_InstanceType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
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
	

	
	//_________________________________________________
    // test_processUnitTestAct_Act_StaticType
    //
    // GIVEN: Unit test scenario is provisioned
    // WHEN:  processUnitTestAct is called
    // THEN:  Act result is of type StaticAct
    //_________________________________________________
	@Test
	public void test_processUnitTestAct_Act_StaticType() throws ReturnNotFoundException, ModifierNotFoundException, ValueTypeNotFoundException  {
		//Arrange
		String testName = "testName";
		
		Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("functionName");
    	function.setIsTestable(true);
    	function.setStatic(true);
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
		assertTrue(act instanceof StaticAct);
	}
	
}
