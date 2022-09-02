package com.dsl.tests.validators;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.validators.ClassTestsRequestValidator;


public class ClassTestsRequestValidatorTest {
	
	//__________________________________________________
    // validation_ClassTestsRequest_Success
    //
    // GIVEN: ClassTestsRequestValidator is processing a ClassTestsRequest
    // WHEN:  validate is called with all fields passed
    // THEN:  there is a valid validation to proceed
    //__________________________________________________
	@Test
	public void validation_ClassTestsRequest_Success() {
		// Arrange
	    final Validator<ClassTestsRequest> validator = new ClassTestsRequestValidator();
        
        String packageName = "com.dsl";
        String className = "ClassName";
        
	    ClassTestsRequest request = new ClassTestsRequest(packageName, className);

	    // Act
	    final ValidationResult result = validator.validate(request);
	
	    // Asserts
	    assertTrue(result.isValid());
	    assertThat(result.getErrors(), empty());
	}


	//__________________________________________________
    // validation_ClassTestsRequest_NullPackageName_Fail
    //
    // GIVEN: ClassTestsRequestValidator is processing a ClassTestsRequest
    // WHEN:  validate is called with null PackageName
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_ClassTestsRequest_NullPackageName_Fail() {
		// Arrange
	    final Validator<ClassTestsRequest> validator = new ClassTestsRequestValidator();
        
	    String packageName = null;
	    String className = "ClassName";
        
	    ClassTestsRequest request = new ClassTestsRequest(packageName, className);
	    
	    // Act
	    final ValidationResult result = validator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	
	//__________________________________________________
    // validation_ClassTestsRequest_EmptyPackageName_Fail
    //
    // GIVEN: ClassTestsRequestValidator is processing a ClassTestsRequest
    // WHEN:  validate is called with empty Package
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_ClassTestsRequest_EmptyPackageName_Fail() {
		// Arrange
	    final Validator<ClassTestsRequest> validator = new ClassTestsRequestValidator();
        
	    String packageName = "";
	    String className = "ClassName";
        
	    ClassTestsRequest request = new ClassTestsRequest(packageName, className);
	    
	    // Act
	    final ValidationResult result = validator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}

	//__________________________________________________
    // validation_ClassTestsRequest_NullClassName_Fail
    //
    // GIVEN: ClassTestsRequestValidator is processing a ClassTestsRequest
    // WHEN:  validate is called with null Class
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_ClassTestsRequest_NullClassName_Fail() {
		// Arrange
	    final Validator<ClassTestsRequest> validator = new ClassTestsRequestValidator();
        
	    String packageName = "com.dsl";
	    String className = null;
        
	    ClassTestsRequest request = new ClassTestsRequest(packageName, className);
	    
	    // Act
	    final ValidationResult result = validator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}

	
	//__________________________________________________
    // validation_ClassTestsRequest_EmptyClassName_Fail
    //
    // GIVEN: ClassTestsRequestValidator is processing a ClassTestsRequest
    // WHEN:  validate is called with empty Class
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_ClassTestsRequest_EmptyClassName_Fail() {
		// Arrange
	    final Validator<ClassTestsRequest> validator = new ClassTestsRequestValidator();
        
	    String packageName = "com.dsl";
	    String className = "";
        
	    ClassTestsRequest request = new ClassTestsRequest(packageName, className);
	    
	    // Act
	    final ValidationResult result = validator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
}
