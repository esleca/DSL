package com.dsl.factories;

import gastmappers.exceptions.UnsupportedLanguageException;

import com.dsl.logic.printers.PrinterBaseHandler;
import com.dsl.logic.printers.PrinterCSharpHandler;
import com.dsl.logic.printers.PrinterJavaHandler;
import com.dsl.logic.printers.PrinterPythonHandler;

import static com.dsl.utils.Constants.*;

public class PrintersFactory {

	public static PrinterBaseHandler createPrinterHandler(String type) throws UnsupportedLanguageException {
		PrinterBaseHandler printerHandler;
		
		switch (type.toUpperCase()){
			case LANGUAGE_JAVA: 
				printerHandler = new PrinterJavaHandler();
				break;
			case LANGUAGE_CSHARP: 
				printerHandler = new PrinterCSharpHandler();
				break;
			case LANGUAGE_PYTHON: 
				printerHandler = new PrinterPythonHandler();
				break;
			default:
				throw new UnsupportedLanguageException();
		}
		
		return printerHandler;
	}
}
