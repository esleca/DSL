package com.dsl.logic.annotations;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import com.dsl.factories.ClassAnnotationsFactory;
import gastmappers.exceptions.UnsupportedLanguageException;

public class ClassAnnotationsHandler implements IAnnotationsHandler{
    @Override
    public AnnotationModifier createTestAnnotation(String language) throws UnsupportedLanguageException {
        return ClassAnnotationsFactory.createClassAnnotationModifier(language);
    }
}
