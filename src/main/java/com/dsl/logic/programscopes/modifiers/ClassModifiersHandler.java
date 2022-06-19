package com.dsl.logic.programscopes.modifiers;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;


@Component
public class ClassModifiersHandler implements IClassModifiersHandler {

	@Override
	public ArrayList<Modifiers> getModifiers(){
        ArrayList<Modifiers> modifiers = new ArrayList<>();
        modifiers.add(new PublicModifier());
        return modifiers;
    }
}
