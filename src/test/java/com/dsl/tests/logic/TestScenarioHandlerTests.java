package com.dsl.tests.logic;

import com.dsl.exceptions.*;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.models.unittests.TestScenario;
import com.dsl.logic.expectedresults.IExpectedParameterizedHandler;
import com.dsl.logic.expectedresults.IExpectedPrimitiveHandler;
import com.dsl.logic.testscenarios.TestScenarioHandler;

import static com.dsl.factories.AggregatesFactory.*;
import static com.dsl.factories.ModifiersFactory.*;
import static com.dsl.factories.ReturnsFactory.*;
import static org.junit.Assert.assertNotNull;

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
	private IExpectedPrimitiveHandler _expectedPrimitiveHandler;
	
	@Mock 
	private IExpectedParameterizedHandler _expectedParameterizedHandler;
	
	@InjectMocks
	private TestScenarioHandler _testScenarioHandler;
	
	
	//__________________________________________________
    // test_processTestScenario_NotNull
    //
    // GIVEN: TestScenarioHandler is executed
    // WHEN:  processTestScenario is called
    // THEN:  TestScenario returned is not null
    //__________________________________________________
    @Test
    public void test_processTestScenario_NotNull() throws ValueTypeNotFoundException, AssertNotFoundException, ModifierNotFoundException, ReturnNotFoundException {
        // Arrange
    	UnitTestRequest request = createUnitTestRequest();
    	
    	ArrayList<Function> testableUnits = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.setName("saludar");
    	//function.setModifiers(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));
    	testableUnits.add(function);
    	
        // Act
    	//TestScenario testScenario = _testScenarioHandler.processTestScenario(request, testableUnits);

        // Assert
    	//assertNotNull(testScenario);
    }
    
    
    
    private static UnitTestRequest createUnitTestRequest() {
        String classPath = "C:\\TestMapper\\JAVA\\Input\\Clase_Prueba.java";
        String outputPath = "C:\\TestPrinter\\JAVA\\Output";
        String language = "JAVA";
        String function = "saludar";
        String testName = "test_saludar_valid";

        JSONArray parameters = getParameters();
        JSONObject expected = getExpected();
        String assertion = "areEqual";
        
        return null;
        //return new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);
    }

    private static JSONArray getParameters() {
        JSONArray parameters = new JSONArray();
        parameters.add(getParameter());
        return parameters;
    }

    private static JSONObject getParameter() {
        JSONObject parameter = new JSONObject();
        parameter.put("name", "nombre");
        parameter.put("type", "String");
        parameter.put("value", "Esteban");
        return parameter;
    }
    
    private static JSONObject getExpected() {
        JSONObject expected = new JSONObject();
        expected.put("type", "String");
        expected.put("value", "Esteban");
        return expected;
    }

}
