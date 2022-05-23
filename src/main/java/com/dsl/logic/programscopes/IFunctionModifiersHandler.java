package com.dsl.logic.programscopes;

import java.util.ArrayList;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IFunctionModifiersHandler {

	ArrayList<Modifiers> getModifiers(String language) throws UnsupportedLanguageException;
}
