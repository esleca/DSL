package com.dsl.logic.programscopes.modifiers;

import java.util.ArrayList;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import com.dsl.fachade.models.DSLModel;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IClassModifiersHandler {

	ArrayList<Modifiers> processClassModifiers(DSLModel model) throws UnsupportedLanguageException;
}
