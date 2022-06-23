package com.dsl.tests.factories;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.dsl.factories.UnitTestAssertsFactory;
import com.dsl.logic.unittests.asserts.UnitTestAssertBaseHandler;
import com.dsl.logic.unittests.asserts.UnitTestAssertCSharpHandler;
import com.dsl.logic.unittests.asserts.UnitTestAssertJavaHandler;
import com.dsl.logic.unittests.asserts.UnitTestAssertPythonHandler;
import gastmappers.exceptions.UnsupportedLanguageException;


public class UnitTestAssertFactoryTests {

	
	//_________________________________________________
    // test_createAssertHandler_JavaNotNull
    //
    // GIVEN: function processed has Java language
    // WHEN:  createAssertHandler function is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_createAssertHandler_JavaNotNull() throws UnsupportedLanguageException {
		//Arrange
		String language = "JAVA";
		
		//Act
		UnitTestAssertBaseHandler result = UnitTestAssertsFactory.createAssertHandler(language);
		
		//Assert
		assertNotNull(result);
	}
	

	//_________________________________________________
    // test_createAssertHandler_JavaType
    //
    // GIVEN: function processed has Java language
    // WHEN:  createAssertHandler function is called
    // THEN:  result is of Java type
    //_________________________________________________
	@Test
	public void test_createAssertHandler_JavaType() throws UnsupportedLanguageException {
		//Arrange
		String language = "JAVA";
		
		//Act
		UnitTestAssertBaseHandler result = UnitTestAssertsFactory.createAssertHandler(language);
		
		//Assert
		assertTrue(result instanceof UnitTestAssertJavaHandler);
	}
	
	
	//_________________________________________________
    // test_createAssertHandler_CSharpNotNull
    //
    // GIVEN: function processed has CSharp language
    // WHEN:  createAssertHandler function is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_createAssertHandler_CSharpNotNull() throws UnsupportedLanguageException {
		//Arrange
		String language = "CSharp";
		
		//Act
		UnitTestAssertBaseHandler result = UnitTestAssertsFactory.createAssertHandler(language);
		
		//Assert
		assertNotNull(result);
	}
	

	//_________________________________________________
    // test_createAssertHandler_CSharpType
    //
    // GIVEN: function processed has CSharp language
    // WHEN:  createAssertHandler function is called
    // THEN:  result is of CSharp type
    //_________________________________________________
	@Test
	public void test_createAssertHandler_CSharpType() throws UnsupportedLanguageException {
		//Arrange
		String language = "CSharp";
		
		//Act
		UnitTestAssertBaseHandler result = UnitTestAssertsFactory.createAssertHandler(language);
		
		//Assert
		assertTrue(result instanceof UnitTestAssertCSharpHandler);
	}
	
	
	//_________________________________________________
    // test_createAssertHandler_PythonNotNull
    //
    // GIVEN: function processed has Python language
    // WHEN:  createAssertHandler function is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_createAssertHandler_PythonNotNull() throws UnsupportedLanguageException {
		//Arrange
		String language = "Python";
		
		//Act
		UnitTestAssertBaseHandler result = UnitTestAssertsFactory.createAssertHandler(language);
		
		//Assert
		assertNotNull(result);
	}


	//_________________________________________________
    // test_createAssertHandler_PythonType
    //
    // GIVEN: function processed has Python language
    // WHEN:  createAssertHandler function is called
    // THEN:  result is of Python type
    //_________________________________________________
	@Test
	public void test_createAssertHandler_PythonType() throws UnsupportedLanguageException {
		//Arrange
		String language = "Python";
		
		//Act
		UnitTestAssertBaseHandler result = UnitTestAssertsFactory.createAssertHandler(language);
		
		//Assert
		assertTrue(result instanceof UnitTestAssertPythonHandler);
	}
	
	

	//__________________________________________________
    // test_createAssertHandler_UnsupportedLanguageException
    //
    // GIVEN: createAssertHandler is called
    // WHEN:  invalid type is passed
    // THEN:  UnsupportedLanguageException is returned
    //___________________________________________________
	@Test
	public void test_createAssertHandler_UnsupportedLanguageException() throws UnsupportedLanguageException {
		//Arrange
		String language = "C++";
		
		//Act
		Exception exception = assertThrows(UnsupportedLanguageException.class, () -> {
			UnitTestAssertsFactory.createAssertHandler(language);
        });		

		String expectedMessage = "The selected language is unsupported yet.";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
