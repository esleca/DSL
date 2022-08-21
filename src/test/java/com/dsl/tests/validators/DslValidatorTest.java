package com.dsl.tests.validators;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;
import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;

import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.valuetypes.StringType;
import com.dsl.models.valuetypes.ValueType;
import com.dsl.validators.DSLFluentValidator;


public class DslValidatorTest {
	
	//__________________________________________________
    // validation_UnitTestRequest_Success
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with all fields passed
    // THEN:  there is a valid validation to proceed
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_Success() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
        String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = "getMessage";
        String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertTrue(result.isValid());
	    assertThat(result.getErrors(), empty());
	}

	
	//__________________________________________________
    // validation_UnitTestRequest_EmptyField_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with no function name
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_EmptyField_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, null, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
}
