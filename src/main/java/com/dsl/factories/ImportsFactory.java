package com.dsl.factories;

import static com.dsl.utils.Constants.*;
import com.dsl.logic.imports.ImportsBaseHandler;
import com.dsl.logic.imports.ImportsJavaHandler;
import com.dsl.logic.imports.ImportsCSharpHandler;
import com.dsl.logic.imports.ImportsPythonHandler;
import com.dsl.models.imports.Import;

import gastmappers.exceptions.UnsupportedLanguageException;

public class ImportsFactory {

    public static ImportsBaseHandler createImportHandler(String type) throws UnsupportedLanguageException {
    	ImportsBaseHandler importsHandler;
    	
    	switch (type.toUpperCase()){
	    	case LANGUAGE_JAVA: 
	    		importsHandler = new ImportsJavaHandler();
	    		break;
	    	case LANGUAGE_CSHARP:
	    		importsHandler = new ImportsCSharpHandler();
	    		break;
	    	case LANGUAGE_PYTHON:
	    		importsHandler = new ImportsPythonHandler();
	    		break;
	    	default:
				throw new UnsupportedLanguageException();
    	}
    	
    	return importsHandler;
    }
    
	public static Import createImport(String name) {
		return new Import(name);
	}
}
