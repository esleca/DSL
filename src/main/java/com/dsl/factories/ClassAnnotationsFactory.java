package com.dsl.factories;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import gastmappers.exceptions.UnsupportedLanguageException;

import static com.dsl.utils.Constants.*;

public class ClassAnnotationsFactory {

    public static AnnotationModifier createClassAnnotationModifier(String language) throws UnsupportedLanguageException {
        AnnotationModifier modifier = null;

        switch (language.toUpperCase()){
            case LANGUAGE_JAVA:
                //modifier = new AnnotationModifier(JAVA_CLASS_TEST_ANNOTATION);
                break;
            case LANGUAGE_CSHARP:
                modifier = new AnnotationModifier(CSHARP_CLASS_TEST_ANNOTATION);
                break;
            case LANGUAGE_PYTHON:
                modifier = new AnnotationModifier(PYTHON_CLASS_TEST_ANNOTATION);
                break;
            default:
                throw new UnsupportedLanguageException();
        }

        return modifier;
    }
}
