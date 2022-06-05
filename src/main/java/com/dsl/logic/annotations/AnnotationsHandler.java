package com.dsl.logic.annotations;

import org.springframework.stereotype.Component;

import com.dsl.factories.AnnotationsFactory;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import gastmappers.exceptions.UnsupportedLanguageException;

@Component
public class AnnotationsHandler implements IAnnotationsHandler {

	@Override
	public AnnotationModifier createTestAnnotation(String language) throws UnsupportedLanguageException {
		return AnnotationsFactory.createAnnotationModifier(language);
	}
}
