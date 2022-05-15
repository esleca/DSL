package com.dsl.tests.factories;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.dsl.factories.PrintersFactory;
import com.dsl.logic.printers.IPrinterHandler;
import com.dsl.logic.printers.PrinterCSharpHandler;
import com.dsl.logic.printers.PrinterJavaHandler;
import com.dsl.logic.printers.PrinterPythonHandler;

import gastmappers.exceptions.UnsupportedLanguageException;

public class PrintersFactoryTests {

	//_________________________________________________
    // test_createPrinterHandler_JavaPrinter
    //
    // GIVEN: createPrinterHandler is called
    // WHEN:  Java type is passed
    // THEN:  printer is instance of PrinterJavaHandler
    //_________________________________________________
	@Test
	public void test_createPrinterHandler_JavaPrinter() throws UnsupportedLanguageException {
		//Arrange
		String type = "Java";
		
		//Act
		IPrinterHandler printer =  PrintersFactory.createPrinterHandler(type);
		
		//Assert
		assertTrue(printer instanceof PrinterJavaHandler);
	}
	
	
	//___________________________________________________
    // test_createPrinterHandler_CSharpPrinter
    //
    // GIVEN: createPrinterHandler is called
    // WHEN:  CSharp type is passed
    // THEN:  printer is instance of PrinterCSharpHandler
    //___________________________________________________
	@Test
	public void test_createPrinterHandler_CSharpPrinter() throws UnsupportedLanguageException {
		//Arrange
		String type = "CSharp";
		
		//Act
		IPrinterHandler printer =  PrintersFactory.createPrinterHandler(type);
		
		//Assert
		assertTrue(printer instanceof PrinterCSharpHandler);
	}
	
	
	//___________________________________________________
    // test_createPrinterHandler_PythonPrinter
    //
    // GIVEN: createPrinterHandler is called
    // WHEN:  Python type is passed
    // THEN:  printer is instance of PrinterPythonHandler
    //___________________________________________________
	@Test
	public void test_createPrinterHandler_PythonPrinter() throws UnsupportedLanguageException {
		//Arrange
		String type = "Python";
		
		//Act
		IPrinterHandler printer =  PrintersFactory.createPrinterHandler(type);
		
		//Assert
		assertTrue(printer instanceof PrinterPythonHandler);
	}
	
	
	//___________________________________________________
    // test_createPrinterHandler_UnsupportedLanguageException
    //
    // GIVEN: createPrinterHandler is called
    // WHEN:  C++ type is passed
    // THEN:  Exception of language is thrown
    //___________________________________________________
	@Test
	public void test_createPrinterHandler_UnsupportedLanguageException() throws UnsupportedLanguageException {
		//Arrange
		String type = "C++";
		
		//Act
		Exception exception = assertThrows(UnsupportedLanguageException.class, () -> {
			PrintersFactory.createPrinterHandler(type);
		});
		
		String expectedMessage = "The selected language is unsupported yet.";
		String actualMessage = exception.getMessage();
		
		//Assert
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
