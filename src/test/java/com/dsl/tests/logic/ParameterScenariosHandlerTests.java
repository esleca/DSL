package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.logic.parameterscenarios.*;
import com.dsl.models.parameters.ParameterScenario;


public class ParameterScenariosHandlerTests {

	private IParameterScenarioHandler sut = new ParameterScenarioHandler();
	
    //_________________________________________________
    // test_getParameterScenarios_EmptyList
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  No parameters are given 
    // THEN:  Handler identifies an empty list
    //_________________________________________________
	@Test
	public void test_getParameterScenarios_EmptyList() throws ValueTypeNotFoundException {
		//Arrange
        JSONArray parameters = new JSONArray();
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
        
		//Assert
		assertTrue(paramScenarios.isEmpty());
	}
	
	
	//__________________________________________________
    // test_getParameterScenarios_ElementsList
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  One parameter is given 
    // THEN:  Handler identifies a list with one element
    //__________________________________________________
	@Test
	public void test_getParameterScenarios_ElementsList() throws ValueTypeNotFoundException {
		//Arrange
		JSONArray parameters = getJsonArrayWithParameter();
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
        
		//Assert
		assertFalse(paramScenarios.isEmpty());
	}
	
	
	//_____________________________________________
    // test_getParameterScenarios_StringParameterType
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  One parameter is given 
    // THEN:  Handler identifies type as String
    //_____________________________________________
	@Test
	public void test_getParameterScenarios_StringParameterType() throws ValueTypeNotFoundException{
		//Arrange
		JSONArray parameters = getJsonArrayWithParameter();
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
        ParameterScenario paramScenario = paramScenarios.get(0);
        
		//Assert
		assertEquals("String", paramScenario.getParameterFunction().getType());
	}
	
	
	//_____________________________________________
    // test_getParameterScenarios_IntParameterType
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  One parameter is given 
    // THEN:  Handler identifies type as int
    //_____________________________________________
	@Test
	public void test_getParameterScenarios_IntParameterType() throws ValueTypeNotFoundException{
		//Arrange
		JSONObject parameter = new JSONObject();
		parameter.put("value", "1");
		parameter.put("name", "firstName");
        parameter.put("type", "int");
        
        JSONArray parameters = new JSONArray();
        parameters.add(parameter);
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
        ParameterScenario paramScenario = paramScenarios.get(0);
        
		//Assert
		assertEquals("int", paramScenario.getParameterFunction().getType());
	}
	
	
	//_____________________________________________
    // test_getParameterScenarios_FloatParameterType
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  One parameter is given 
    // THEN:  Handler identifies type as Float
    //_____________________________________________
	@Test
	public void test_getParameterScenarios_FloatParameterType() throws ValueTypeNotFoundException{
		//Arrange
		JSONObject parameter = new JSONObject();
		parameter.put("value", "3.14F");
		parameter.put("name", "firstName");
        parameter.put("type", "float");
        
        JSONArray parameters = new JSONArray();
        parameters.add(parameter);
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
        ParameterScenario paramScenario = paramScenarios.get(0);
        
		//Assert
		assertEquals("float", paramScenario.getParameterFunction().getType());
	}
	
	
	//_____________________________________________
    // test_getParameterScenarios_DoubleParameterType
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  One parameter is given 
    // THEN:  Handler identifies type as Double
    //_____________________________________________
	@Test
	public void test_getParameterScenarios_DoubleParameterType() throws ValueTypeNotFoundException{
		//Arrange
		JSONObject parameter = new JSONObject();
		parameter.put("value", "1.55555D");
		parameter.put("name", "firstName");
        parameter.put("type", "double");
        
        JSONArray parameters = new JSONArray();
        parameters.add(parameter);
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
        ParameterScenario paramScenario = paramScenarios.get(0);
        
		//Assert
		assertEquals("double", paramScenario.getParameterFunction().getType());
	}
	
	
	//_____________________________________________
    // test_getParameterScenarios_LongParameterType
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  One parameter is given 
    // THEN:  Handler identifies type as Long
    //_____________________________________________
	@Test
	public void test_getParameterScenarios_LongParameterType() throws ValueTypeNotFoundException{
		//Arrange
		JSONObject parameter = new JSONObject();
		parameter.put("value", "5555555555");
		parameter.put("name", "firstName");
        parameter.put("type", "long");
        
        JSONArray parameters = new JSONArray();
        parameters.add(parameter);
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
        ParameterScenario paramScenario = paramScenarios.get(0);
        
		//Assert
		assertEquals("long", paramScenario.getParameterFunction().getType());
	}
	
	
	//_____________________________________________
    // test_getParameterScenarios_ParameterName
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  One parameter is given 
    // THEN:  Handler identifies name as firstName
    //_____________________________________________
	@Test
	public void test_getParameterScenarios_ParameterName() throws ValueTypeNotFoundException{
		//Arrange
		JSONArray parameters = getJsonArrayWithParameter();
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
    	ParameterScenario paramScenario = paramScenarios.get(0);
        
		//Assert
		assertEquals("firstName", paramScenario.getParameterFunction().getName());
	}
	

	//_____________________________________________
    // test_getParameterScenarios_ParameterValue
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  One parameter is given 
    // THEN:  Handler identifies value as John
    //_____________________________________________
	@Test
	public void test_getParameterScenarios_ParameterValue() throws ValueTypeNotFoundException{
		//Arrange
        JSONArray parameters = getJsonArrayWithParameter();
        
		//Act
        ArrayList<ParameterScenario> paramScenarios = sut.getParameterScenarios(parameters);
        ParameterScenario paramScenario = paramScenarios.get(0);
        
		//Assert
		assertEquals("John", paramScenario.getValueType().getValue());
	}
	

	//_____________________________________________
    // test_getParameterScenarios_ExceptionValue
    //
    // GIVEN: getParameterScenarios is executed
    // WHEN:  Invalid value type is passed
    // THEN:  Exception is thrown
    //_____________________________________________
	@Test
	public void test_getParameterScenarios_ExceptionValue() throws ValueTypeNotFoundException{
		//Arrange
		JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "invalid");
        parameter.put("value", "John");
        
        JSONArray parameters = new JSONArray();
        parameters.add(parameter);
        
        //Act
  		Exception exception = assertThrows(ValueTypeNotFoundException.class, () -> {
  			sut.getParameterScenarios(parameters);
  		});
  		
  		String expectedMessage = "Invalid DSL value type";
  		String actualMessage = exception.getMessage();
  		
  		//Assert
  		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	private JSONArray getJsonArrayWithParameter() {
		JSONObject parameter = new JSONObject();
        parameter.put("name", "firstName");
        parameter.put("type", "String");
        parameter.put("value", "John");
        
        JSONArray parameters = new JSONArray();
        parameters.add(parameter);
        
        return parameters;
	}
}
