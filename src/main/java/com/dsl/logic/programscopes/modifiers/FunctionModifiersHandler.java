package com.dsl.logic.programscopes.modifiers;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.logic.annotations.IAnnotationsHandler;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class FunctionModifiersHandler implements IFunctionModifiersHandler {

	private IAnnotationsHandler annotationsHandler;
	
	public FunctionModifiersHandler(IAnnotationsHandler annotationsHandler) {
		this.annotationsHandler = annotationsHandler;
	}
	
	
	@Override
	public ArrayList<Modifiers> getModifiers(String language) throws UnsupportedLanguageException{
        ArrayList<Modifiers> modifiers = new ArrayList<>();
        
        AnnotationModifier testAnnotation = annotationsHandler.createTestAnnotation(language);
        
        modifiers.add(testAnnotation);
        modifiers.add(new PublicModifier());
        
        return modifiers;
    }
}
