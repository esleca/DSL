package com.dsl.logic.annotations;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IAnnotationsHandler {

	AnnotationModifier createTestAnnotation(String language) throws UnsupportedLanguageException;
}
