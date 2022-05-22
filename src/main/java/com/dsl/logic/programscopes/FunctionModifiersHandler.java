package com.dsl.logic.programscopes;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;


@Component
public class FunctionModifiersHandler implements IFunctionModifiersHandler {

	@Override
	public ArrayList<Modifiers> getModifiers(){
        ArrayList<Modifiers> modifiers = new ArrayList<>();
        //modifiers.add(new AnnotationModifier("Override"));
        modifiers.add(new PublicModifier());
        return modifiers;
    }

}
