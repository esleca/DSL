package processortests;

import exceptions.*;
import models.dtos.UnitTestRequest;
import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.aggregates.Package;
import models.entities.unittests.TestScenario;
import processor.testscenarios.IExpectedParameterizedHandler;
import processor.testscenarios.IExpectedPrimitiveHandler;
import processor.testscenarios.TestScenarioHandler;

import static factories.AggregatesFactory.*;
import static factories.ModifiersFactory.*;
import static factories.ReturnsFactory.*;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.mockito.Mock;


public class TestScenarioHandlerTests {

	@Mock 
	private IExpectedPrimitiveHandler _expectedPrimitiveHandler;
	
	@Mock 
	private IExpectedParameterizedHandler _expectedParameterizedHandler;
	
	
	private TestScenarioHandler _testScenarioHandler = 
		new TestScenarioHandler(_expectedPrimitiveHandler, _expectedParameterizedHandler);
	
	
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setName("saludar");
    	function.setModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));
    	testableUnits.add(function);
    	
        // Act
    	TestScenario testScenario = _testScenarioHandler.processTestScenario(request, testableUnits);

        // Assert
    	assertNotNull(testScenario);
    }
    
    
    
    private static UnitTestRequest createUnitTestRequest() {
        String classPath = "C:\\TestMapper\\JAVA\\Input\\Clase_Prueba.java";
        String language = "JAVA";
        String function = "saludar";
        String testName = "test_saludar_valid";
        String expected = "Hola Esteban";
        String assertion = "areEqual";
        JSONArray parameters = getParameters();
        return new UnitTestRequest(classPath, language, function, testName, parameters, expected, assertion);
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


}
