package com.dsl.tests.logic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.logic.expectedresults.ExpectedResultHandler;
import com.dsl.logic.expectedresults.IExpectedResultHandler;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.valuetypes.ValueType;


public class ExpectedResultHandlerTests {	
	
	private IExpectedResultHandler sut = new ExpectedResultHandler();


	//__________________________________________________________
    // test_getExpectedResult_NotNull
    //
    // GIVEN: Expected result is an integer
    // WHEN:  getExpectedResult is executed
    // THEN:  result is not null
    //__________________________________________________________
	@Test
	public void test_getExpectedResult_NotNull() throws ValueTypeNotFoundException {
		//Arrange
		ValueType expected = ValueTypeFactory.createValueType("int", "14");
        
		UnitTestRequest request = new UnitTestRequest(null, null, null, null, null, null, expected, null);
		
		//Act
		ExpectedResult result = sut.getExpectedResult(request);
		
		//Assert
		assertNotNull(result);
	}
	
	
	//__________________________________________________________
    // test_getExpectedResult_Null
    //
    // GIVEN: Expected result is null
    // WHEN:  getExpectedResult is executed
    // THEN:  result is null
    //__________________________________________________________
	@Test
	public void test_getExpectedResult_Null() throws ValueTypeNotFoundException {
		//Arrange
		UnitTestRequest request = new UnitTestRequest(null, null, null, null, null, null, null, null);
		
		//Act
		ExpectedResult result = sut.getExpectedResult(request);
		
		//Assert
		assertNull(result);
	}


	//__________________________________________________________
    // test_getExpectedResult_ExpectedTypeNotNull
    //
    // GIVEN: Expected result is an integer
    // WHEN:  getExpectedResult is executed
    // THEN:  result type is not null
    //__________________________________________________________
	@Test
	public void test_getExpectedResult_ExpectedTypeNotNull() throws ValueTypeNotFoundException {
		//Arrange
		ValueType expected = ValueTypeFactory.createValueType("int", "14");
        
		UnitTestRequest request = new UnitTestRequest(null, null, null, null, null, null, expected, null);
		
		//Act
		ExpectedResult result = sut.getExpectedResult(request);
		String type = result.getExpectedType();
		
		//Assert
		assertNotNull(type);
	}

	
	//__________________________________________________________
    // test_getExpectedResult_ExpectedType
    //
    // GIVEN: Expected result is an integer
    // WHEN:  getExpectedResult is executed
    // THEN:  result type is an integer
    //__________________________________________________________
	@Test
	public void test_getExpectedResult_ExpectedType() throws ValueTypeNotFoundException {
		//Arrange
		ValueType expected = ValueTypeFactory.createValueType("int", "14");
        
		UnitTestRequest request = new UnitTestRequest(null, null, null, null, null, null, expected, null);
		
		//Act
		ExpectedResult result = sut.getExpectedResult(request);
		String type = result.getExpectedType();
		
		//Assert
		assertEquals("int", type);
	}


	//__________________________________________________________
    // test_getExpectedResult_ValueTypeNotNull
    //
    // GIVEN: Expected result is an integer
    // WHEN:  getExpectedResult is executed
    // THEN:  result value type is not null
    //__________________________________________________________
	@Test
	public void test_getExpectedResult_ValueTypeNotNull() throws ValueTypeNotFoundException {
		//Arrange
		ValueType expected = ValueTypeFactory.createValueType("int", "14");
        
		UnitTestRequest request = new UnitTestRequest(null, null, null, null, null, null, expected, null);
		
		//Act
		ExpectedResult result = sut.getExpectedResult(request);
		ValueType valueType = result.getValueType();
		
		//Assert
		assertNotNull(valueType);
	}

	
	//__________________________________________________________
    // test_getExpectedResult_ValueType
    //
    // GIVEN: Expected result is an integer
    // WHEN:  getExpectedResult is executed
    // THEN:  result type is an integer
    //__________________________________________________________
	@Test
	public void test_getExpectedResult_ValueType() throws ValueTypeNotFoundException {
		//Arrange
		ValueType expected = ValueTypeFactory.createValueType("int", "14");
        
		UnitTestRequest request = new UnitTestRequest(null, null, null, null, null, null, expected, null);
		
		//Act
		ExpectedResult result = sut.getExpectedResult(request);
		ValueType valueType = result.getValueType();
		
		//Assert
		assertEquals(expected, valueType);
	}

	
	//__________________________________________________________
    // test_getExpectedResult_ValueType_Type
    //
    // GIVEN: Expected result is an integer
    // WHEN:  getExpectedResult is executed
    // THEN:  result type is an int
    //__________________________________________________________
	@Test
	public void test_getExpectedResult_ValueType_Type() throws ValueTypeNotFoundException {
		//Arrange
		ValueType expected = ValueTypeFactory.createValueType("int", "14");
        
		UnitTestRequest request = new UnitTestRequest(null, null, null, null, null, null, expected, null);
		
		//Act
		ExpectedResult result = sut.getExpectedResult(request);
		ValueType valueType = result.getValueType();
		String type = valueType.getType();

		//Assert
		assertEquals("int", type);
	}

	
	//__________________________________________________________
    // test_getExpectedResult_ValueType_Value
    //
    // GIVEN: Expected result is an integer
    // WHEN:  getExpectedResult is executed
    // THEN:  result type is 14
    //__________________________________________________________
	@Test
	public void test_getExpectedResult_ValueType_Value() throws ValueTypeNotFoundException {
		//Arrange
		ValueType expected = ValueTypeFactory.createValueType("int", "14");
        
		UnitTestRequest request = new UnitTestRequest(null, null, null, null, null, null, expected, null);
		
		//Act
		ExpectedResult result = sut.getExpectedResult(request);
		ValueType valueType = result.getValueType();
		int value = (int) valueType.getValue();

		//Assert
		assertEquals(14, value);
	}

}
