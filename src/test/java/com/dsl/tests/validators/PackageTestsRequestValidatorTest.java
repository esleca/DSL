package com.dsl.tests.validators;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.validators.PackageTestsRequestValidator;


public class PackageTestsRequestValidatorTest {
	
	//__________________________________________________
    // validation_PackageTestsRequest_Success
    //
    // GIVEN: PackageTestsRequestValidator is processing a PackageTestsRequest
    // WHEN:  validate is called with all fields passed
    // THEN:  there is a valid validation to proceed
    //__________________________________________________
	@Test
	public void validation_PackageTestsRequest_Success() {
		// Arrange
	    final Validator<PackageTestsRequest> validator = new PackageTestsRequestValidator();
        
        String packageName = "com.dsl";
        
	    PackageTestsRequest request = new PackageTestsRequest(packageName);

	    // Act
	    final ValidationResult result = validator.validate(request);
	
	    // Asserts
	    assertTrue(result.isValid());
	    assertThat(result.getErrors(), empty());
	}


	//__________________________________________________
    // validation_PackageTestsRequest_NullPackageName_Fail
    //
    // GIVEN: PackageTestsRequestValidator is processing a PackageTestsRequest
    // WHEN:  validate is called with null PackageName
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_PackageTestsRequest_NullPackageName_Fail() {
		// Arrange
	    final Validator<PackageTestsRequest> validator = new PackageTestsRequestValidator();
        
	    String packageName = null;
        
	    PackageTestsRequest request = new PackageTestsRequest(packageName);
	    
	    // Act
	    final ValidationResult result = validator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
	
	//__________________________________________________
    // validation_PackageTestsRequest_EmptyPackageName_Fail
    //
    // GIVEN: PackageTestsRequestValidator is processing a PackageTestsRequest
    // WHEN:  validate is called with empty PackageName
    // THEN:  there is an invalid validation
    //__________________________________________________
	@Test
	public void validation_PackageTestsRequest_EmptyPackageName_Fail() {
		// Arrange
	    final Validator<PackageTestsRequest> validator = new PackageTestsRequestValidator();
        
	    String packageName = "";
        
	    PackageTestsRequest request = new PackageTestsRequest(packageName);
	    
	    // Act
	    final ValidationResult result = validator.validate(request);
	
	    // Asserts
	    assertFalse(result.isValid());
	    assertThat(result.getErrors(), not(empty()));
	}
	
}
