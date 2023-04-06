package com.dsl.logic.annotations;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IClassAnnotationsHandler {

	AnnotationModifier createTestAnnotation(String language) throws UnsupportedLanguageException;
}
