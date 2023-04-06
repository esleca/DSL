package com.dsl.logic.programscopes.modifiers;

import java.util.ArrayList;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AnnotationModifier;
import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.annotations.IClassAnnotationsHandler;
import gastmappers.exceptions.UnsupportedLanguageException;
import org.springframework.stereotype.Component;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;


@Component
public class ClassModifiersHandler implements IClassModifiersHandler {

    private IClassAnnotationsHandler annotationsHandler;
    private DSLModel model;

    public ClassModifiersHandler(IClassAnnotationsHandler annotationsHandler){
        this.annotationsHandler = annotationsHandler;
    }

	@Override
	public ArrayList<Modifiers> processClassModifiers(DSLModel model) throws UnsupportedLanguageException {
        ArrayList<Modifiers> modifiers = new ArrayList<>();
        AnnotationModifier testAnnotation = annotationsHandler.createTestAnnotation(model.getlClass().getLanguage());
        if(testAnnotation != null)
            modifiers.add(testAnnotation);
        modifiers.add(new PublicModifier());
        return modifiers;
    }


}
