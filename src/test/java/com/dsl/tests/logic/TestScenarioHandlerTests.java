package com.dsl.tests.logic;

import com.dsl.exceptions.*;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.ExpectedResultPrimitive;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.asserts.types.AssertType;
import com.dsl.models.valuetypes.ValueType;
import com.dsl.logic.expectedresults.IExpectedResultHandler;
import com.dsl.logic.parameterscenarios.IParameterScenarioHandler;
import com.dsl.logic.testscenarios.TestScenarioHandler;

import static com.dsl.factories.AggregatesFactory.*;
import static com.dsl.factories.ModifiersFactory.*;
import static com.dsl.factories.ReturnsFactory.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TestScenarioHandlerTests {

	@Mock 
	private IParameterScenarioHandler _parameterScenarioHandler;
	
	@Mock 
	private IExpectedResultHandler _expectedResultHandler;
	
	@InjectMocks
	private TestScenarioHandler _sut;
	
	
	//__________________________________________________
    // test_processTestScenario_NotNull
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario returned is not null
    //__________________________________________________
    @Test
    public void test_processTestScenario_NotNull() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("int"));
    	function.addModifier(createModifier("public"));

    	String testName = "testName";
    	
    	JSONArray paramsArray = new JSONArray();

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(new ArrayList<ParameterScenario>());
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);

        // Assert
    	assertNotNull(testScenario);
    }
    
    
    //__________________________________________________
    // test_processTestScenario_Null
    //
    // GIVEN: TestScenarioHandler is executed
    // AND:   function name does not similar
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario returned is null
    //__________________________________________________
    @Test
    public void test_processTestScenario_Null() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName2";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setIsTestable(true);
    	function.setName("functionName");
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONArray paramsArray = new JSONArray();

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);

        // Assert
    	assertNull(testScenario);
    }

	
	//__________________________________________________
    // test_processTestScenario_TestName
    //
    // GIVEN: TestScenarioHandler is executed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario function name match the input
    //__________________________________________________
    @Test
    public void test_processTestScenario_TestName() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("int"));
    	function.addModifier(createModifier("public"));

    	String testName = "testName";
    	
    	JSONArray paramsArray = new JSONArray();

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(new ArrayList<ParameterScenario>());
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	String result = testScenario.getTestName();
    	
        // Assert
    	assertNotNull("testName", result);
    }

	
	//__________________________________________________
    // test_processTestScenario_FunctionNotNull
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   All parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario function is not null
    //__________________________________________________
    @Test
    public void test_processTestScenario_FunctionNotNull() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("int"));
    	function.addModifier(createModifier("public"));

    	String testName = "testName";
    	
    	JSONArray paramsArray = new JSONArray();

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function);
		}};

		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(new ArrayList<ParameterScenario>());
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	Function functionResult = testScenario.getFunction();

        // Assert
    	assertNotNull(functionResult);
    }

	
	//__________________________________________________
    // test_processTestScenario_FunctionName
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   All parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario function name match the input
    //__________________________________________________
    @Test
    public void test_processTestScenario_FunctionName() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("int"));
    	function.addModifier(createModifier("public"));

    	String testName = "testName";
    	
    	JSONArray paramsArray = new JSONArray();

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function);
		}};

		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(new ArrayList<ParameterScenario>());
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	String functionNameResult = testScenario.getFunction().getName();

        // Assert
    	assertEquals("functionName", functionNameResult);
    }

	
	//__________________________________________________
    // test_processTestScenario_FunctionClass
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   All parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario function class match the input
    //__________________________________________________
    @Test
    public void test_processTestScenario_FunctionClass() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.setIsTestable(true);
    	function.setReturn(createPrimitiveReturn("int"));
    	function.addModifier(createModifier("public"));

    	String testName = "testName";
    	
    	JSONArray paramsArray = new JSONArray();

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function);
		}};

		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(new ArrayList<ParameterScenario>());
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	String functionClass = testScenario.getFunction().getFileClass().getName();

        // Assert
    	assertEquals("ClassName", functionClass);
    }

	
	//___________________________________________________
    // test_processTestScenario_ParametersScenarioNotNull
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario parameters are not null
    //___________________________________________________
    @Test
    public void test_processTestScenario_ParametersScenarioNotNull() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("int"));

    	String testName = "testName";
    	
    	JSONArray paramsArray = new JSONArray();

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(new ArrayList<ParameterScenario>());
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ArrayList<ParameterScenario> parameters = testScenario.getParameters();
    	
        // Assert
    	assertNotNull(parameters);
    }

	
	//__________________________________________________
    // test_processTestScenario_ParameterScenarioSize
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario returned is not null
    //__________________________________________________
    @Test
    public void test_processTestScenario_ParameterScenarioSize() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("int"));

    	String testName = "testName";

    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ArrayList<ParameterScenario> paramScenarios = testScenario.getParameters();
    			
        // Assert
    	assertEquals(1, paramScenarios.size());
    }

	
	//__________________________________________________
    // test_processTestScenario_ParameterScenario_ParameterFunctionNotNull
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario parameter function is not null
    //__________________________________________________
    @Test
    public void test_processTestScenario_ParameterScenario_ParameterFunctionNotNull() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("int"));

    	String testName = "testName";

    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ArrayList<ParameterScenario> paramScenarios = testScenario.getParameters();
    	ParameterScenario paramScenario = paramScenarios.get(0);
    	
        // Assert
    	assertNotNull(paramScenario);
    }

	
	//__________________________________________________
    // test_processTestScenario_ParameterScenario_ParameterFunctionType
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario parameter function type match
    //__________________________________________________
    @Test
    public void test_processTestScenario_ParameterScenario_ParameterFunctionType() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ArrayList<ParameterScenario> paramScenarios = testScenario.getParameters();
    	ParameterScenario parameterScenario = paramScenarios.get(0);
    	ParameterFunction parameterFunction = parameterScenario.getParameterFunction();
    	
        // Assert
    	assertEquals("String", parameterFunction.getType());
    }

	
	//__________________________________________________
    // test_processTestScenario_ParameterScenario_ParameterFunctionName
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario parameter function name match
    //__________________________________________________
    @Test
    public void test_processTestScenario_ParameterScenario_ParameterFunctionName() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ArrayList<ParameterScenario> paramScenarios = testScenario.getParameters();
    	ParameterScenario parameterScenario = paramScenarios.get(0);
    	ParameterFunction parameterFunction = parameterScenario.getParameterFunction();
    	
        // Assert
    	assertEquals("firstName", parameterFunction.getName());
    }

	
	//__________________________________________________
    // test_processTestScenario_ParameterScenario_ValueTypeNotNull
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario ValueType is not null
    //__________________________________________________
    @Test
    public void test_processTestScenario_ParameterScenario_ValueTypeNotNull() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange      
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";

    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("int", "14");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};

		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ArrayList<ParameterScenario> paramScenarios = testScenario.getParameters();
    	ParameterScenario paramScenario = paramScenarios.get(0);
    	ValueType valueType = paramScenario.getValueType();
    	
        // Assert
    	assertNotNull(valueType);
    }

	
	//__________________________________________________
    // test_processTestScenario_ParameterScenario_ValueTypeValue
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario value type value match
    //__________________________________________________
    @Test
    public void test_processTestScenario_ParameterScenario_ValueTypeValue() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ArrayList<ParameterScenario> paramScenarios = testScenario.getParameters();
    	ParameterScenario parameterScenario = paramScenarios.get(0);
    	ValueType valueType = parameterScenario.getValueType();
    	
        // Assert
    	assertEquals("John", valueType.getValue());
    }

	
	//__________________________________________________
    // test_processTestScenario_ParameterScenario_ValueType
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario value type type match
    //__________________________________________________
    @Test
    public void test_processTestScenario_ParameterScenario_ValueType() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ArrayList<ParameterScenario> paramScenarios = testScenario.getParameters();
    	ParameterScenario parameterScenario = paramScenarios.get(0);
    	ValueType valueType = parameterScenario.getValueType();
    	
        // Assert
    	assertEquals("String", valueType.getType());
    }

	
	//__________________________________________________
    // test_processTestScenario_ExpectedResultNotNull
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario expected result is not null
    //__________________________________________________
    @Test
    public void test_processTestScenario_ExpectedResultNotNull() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ExpectedResult expectedResult = testScenario.getExpectedResult();
    	
        // Assert
    	assertNotNull(expectedResult);
    }

	
	//__________________________________________________
    // test_processTestScenario_ExpectedResultValue
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario expected result value match
    //__________________________________________________
    @Test
    public void test_processTestScenario_ExpectedResultValue() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ExpectedResult expectedResult = testScenario.getExpectedResult();
    	
        // Assert
    	assertEquals("John", expectedResult.getValueType().getValue());
    }

	
	//__________________________________________________
    // test_processTestScenario_ExpectedResultNotNull
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario expected result is not null
    //__________________________________________________
    @Test
    public void test_processTestScenario_ExpectedResultType() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	ExpectedResult expectedResult = testScenario.getExpectedResult();
    	
        // Assert
    	assertEquals("String", expectedResult.getValueType().getType());
    }

	
	//__________________________________________________
    // test_processTestScenario_Assertion
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario assertion match
    //__________________________________________________
    @Test
    public void test_processTestScenario_Assertion() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	String assertionResult = testScenario.getAssertion();
    	
        // Assert
    	assertEquals("areEqual", assertionResult);
    }

	
	//__________________________________________________
    // test_processTestScenario_AssertTypeAreEqual
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario assert type match
    //__________________________________________________
    @Test
    public void test_processTestScenario_AssertTypeAreEqual() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	AssertType assertType = testScenario.getAssertType();
    	
        // Assert
    	assertEquals("assertEquals", assertType.getName());
    }

	
	//______________________________________________________________
    // test_processTestScenario_AssertType_FunctionArgumentNotNull
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario assert type function argument is not null
    //______________________________________________________________
    @Test
    public void test_processTestScenario_AssertType_FunctionArgumentNotNull() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	AssertType assertType = testScenario.getAssertType();
    	ArrayList<FunctionArgument> assertArguments = assertType.getAssertArguments();
    	
        // Assert
    	assertNotNull(assertArguments);
    }

	
	//______________________________________________________________
    // test_processTestScenario_AssertType_FunctionArgumentSize
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario assert type function argument size match
    //______________________________________________________________
    @Test
    public void test_processTestScenario_AssertType_FunctionArgumentSize() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	AssertType assertType = testScenario.getAssertType();
    	ArrayList<FunctionArgument> assertArguments = assertType.getAssertArguments();
    	
        // Assert
    	assertEquals(2, assertArguments.size());
    }

	
	//______________________________________________________________
    // test_processTestScenario_AssertType_FunctionArgumentValue
    //
    // GIVEN: TestScenarioHandler is executed
	// AND:   all parameters for requested are passed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario assert type function argument value match
    //______________________________________________________________
    @Test
    public void test_processTestScenario_AssertType_FunctionArgumentValue() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	String language = "Java";
    	
    	String functionName = "functionName";
    	
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName(functionName);
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));

    	String testName = "testName";
    	
    	JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        JSONArray paramsArray = new JSONArray();
        paramsArray.add(parameter);

    	ValueType expected = ValueTypeFactory.createValueType("String", "John");
    	
    	String assertion = "areEqual";

    	UnitTestRequest request = new UnitTestRequest(null, null, language, functionName, testName, paramsArray, expected, assertion);
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>() {{
    		add(function); 
		}};

		ArrayList<ParameterScenario> parameterScenarios = new ArrayList<ParameterScenario>() {
			{
				add(new ParameterScenario(new ParameterFunction("String", "firstName"), expected));
			}
		};
		
		when(_parameterScenarioHandler.getParameterScenarios(paramsArray))
			.thenReturn(parameterScenarios);
		
		when(_expectedResultHandler.getExpectedResult(request))
			.thenReturn(new ExpectedResultPrimitive(expected));
		
        // Act
    	TestScenario testScenario = _sut.processTestScenario(request, testableUnits);
    	AssertType assertType = testScenario.getAssertType();
    	ArrayList<FunctionArgument> assertArguments = assertType.getAssertArguments();
    	FunctionArgument functionArgument  = assertArguments.get(0);
    	
        // Assert
    	assertEquals("expected", functionArgument.getValue());
    }
    
    
}
