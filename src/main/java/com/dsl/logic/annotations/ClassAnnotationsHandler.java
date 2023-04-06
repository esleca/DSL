package com.dsl.logic.annotations;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import com.dsl.factories.ClassAnnotationsFactory;
import gastmappers.exceptions.UnsupportedLanguageException;
import org.springframework.stereotype.Component;

@Component
public class ClassAnnotationsHandler implements IClassAnnotationsHandler{
    @Override
    public AnnotationModifier createTestAnnotation(String language) throws UnsupportedLanguageException {
        return ClassAnnotationsFactory.createClassAnnotationModifier(language);
    }
}
