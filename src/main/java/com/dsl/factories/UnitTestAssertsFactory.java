package com.dsl.factories;

import com.dsl.logic.unittests.asserts.UnitTestAssertBaseHandler;
import com.dsl.logic.unittests.asserts.UnitTestAssertJavaHandler;
import com.dsl.logic.unittests.asserts.UnitTestAssertPythonHandler;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.logic.unittests.asserts.UnitTestAssertCSharpHandler;

import static com.dsl.utils.Constants.*;

public class UnitTestAssertsFactory {

    public static UnitTestAssertBaseHandler createAssertHandler(String language) throws UnsupportedLanguageException {
    	UnitTestAssertBaseHandler response;

        switch (language.toUpperCase()){
            case LANGUAGE_JAVA:
                response = new UnitTestAssertJavaHandler();
                break;
            case LANGUAGE_CSHARP:
                response = new UnitTestAssertCSharpHandler();
                break;
            case LANGUAGE_PYTHON:
                response = new UnitTestAssertPythonHandler();
                break;
            default:
                throw new UnsupportedLanguageException();
        }

        return response;
    }
}
