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
    // validation_UnitTestRequest_NullClassPath_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with null class path
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_NullClassPath_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = null;
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = "some_function";
    	String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	//__________________________________________________
    // validation_UnitTestRequest_EmptyClassPath_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with empty class path
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_EmptyClassPath_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = "some_function";
    	String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	
	//__________________________________________________
    // validation_UnitTestRequest_NullLanguage_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with null language
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_NullLanguage_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = null;
        String function = "some_function";
    	String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	//__________________________________________________
    // validation_UnitTestRequest_EmptyLanguage_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with empty language
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_EmptyLanguage_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\\\Mapper\\\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "";
        String function = "some_function";
    	String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	
	//__________________________________________________
    // validation_UnitTestRequest_NullOutputPath_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with null output path
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_NullOutputPath_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = null;
    	String language = "JAVA";
        String function = "some_function";
    	String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	//__________________________________________________
    // validation_UnitTestRequest_EmptyOutputPath_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with empty Output path
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_EmptyOutputPath_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "";
    	String language = "JAVA";
        String function = "some_function";
    	String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	
	//__________________________________________________
    // validation_UnitTestRequest_NullFunction_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with null Function
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_NullFunction_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = null;
    	String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	//__________________________________________________
    // validation_UnitTestRequest_EmptyFunction_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with empty Function
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_EmptyFunction_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = "";
    	String testName = "test_getMessage_valid";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	

	//__________________________________________________
    // validation_UnitTestRequest_NullTestName_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with null TestName
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_NullTestName_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = "some_function";;
    	String testName = null;
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	//__________________________________________________
    // validation_UnitTestRequest_EmptyTestName_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with empty TestName
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_EmptyTestName_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = "some_function";
    	String testName = "";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "areEquals";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}


	//__________________________________________________
    // validation_UnitTestRequest_NullAssert_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with null Assert
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_NullAssert_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = "some_function";;
    	String testName = "some_test_name";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = null;
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	//__________________________________________________
    // validation_UnitTestRequest_EmptyAssert_Fail
    //
    // GIVEN: DSLValidator is processing a UnitTestRequest
    // WHEN:  validate is called with empty Assert
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_UnitTestRequest_EmptyAssert_Fail() {
		// Arrange
	    final Validator<UnitTestRequest> dslValidator = new DSLFluentValidator();
        
	    String classPath = "C:\\Mapper\\Clase_Prueba.java";
    	String outputPath = "C:\\Printer\\Output";
    	String language = "JAVA";
        String function = "some_function";
    	String testName = "some_Test_name";
        ValueType expected = new StringType();
        expected.setValue("Costa Rica");
        JSONArray parameters = new JSONArray();
        String assertion = "";
        
	    UnitTestRequest request = new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);

	    // Act
	    final ValidationResult result = dslValidator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	
}
