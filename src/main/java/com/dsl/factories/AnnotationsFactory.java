package com.dsl.factories;

import static com.dsl.utils.Constants.LANGUAGE_CSHARP;
import static com.dsl.utils.Constants.LANGUAGE_JAVA;
import static com.dsl.utils.Constants.LANGUAGE_PYTHON;
import static com.dsl.utils.Constants.JAVA_TEST_ANNOTATION;
import static com.dsl.utils.Constants.CSHARP_TEST_ANNOTATION;
import static com.dsl.utils.Constants.PYTHON_TEST_ANNOTATION;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import gastmappers.exceptions.UnsupportedLanguageException;

public class AnnotationsFactory {

	public static AnnotationModifier createAnnotationModifier(String language) throws UnsupportedLanguageException {
		AnnotationModifier modifier;
		
		switch (language.toUpperCase()){
	    	case LANGUAGE_JAVA: 
	    		modifier = new AnnotationModifier(JAVA_TEST_ANNOTATION);
	    		break;
	    	case LANGUAGE_CSHARP:
	    		modifier = new AnnotationModifier(CSHARP_TEST_ANNOTATION);
	    		break;
	    	case LANGUAGE_PYTHON:
	    		modifier = new AnnotationModifier(PYTHON_TEST_ANNOTATION);
	    		break;
	    	default:
				throw new UnsupportedLanguageException();
		}
		
		return modifier;
	}
}
