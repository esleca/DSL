package com.dsl.logic.programscopes;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.UnitTest;
import com.dsl.logic.programscopes.body.IFunctionBodyHandler;
import com.dsl.logic.programscopes.modifiers.IFunctionModifiersHandler;
import com.dsl.logic.programscopes.returns.IFunctionReturnHandler;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.FunctionDefintion;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Statement.Statement;
import ASTMCore.ASTMSyntax.Types.TypeReference;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class FunctionScopeHandler implements IFunctionScopeHandler {

	private IFunctionModifiersHandler modifiersHandler;
	private IFunctionReturnHandler returnHandler;
	private IFunctionBodyHandler bodyHandler;
	
	public FunctionScopeHandler(IFunctionModifiersHandler functionModifiersHandler, IFunctionReturnHandler functionReturnHandler,
			 IFunctionBodyHandler bodyHandler) {
		this.modifiersHandler = functionModifiersHandler;
		this.returnHandler = functionReturnHandler;
		this.bodyHandler = bodyHandler;
	}
	
	
	@Override
	public FunctionDefintion processFunctionDefinition(UnitTest unitTest) throws UnsupportedLanguageException {
		Name name = GastFactory.getName(unitTest.getTestScenario().getTestName());
        ArrayList<Modifiers> modifiers = modifiersHandler.getModifiers(unitTest.getLanguage());
        TypeReference returnType = returnHandler.getReturnType();
        Statement statement = bodyHandler.processFunctionBody(unitTest);

        FunctionDefintion functionDefinition = new FunctionDefintion();
        functionDefinition.setIdentifierName(name);
        functionDefinition.setModifiers(modifiers);
        functionDefinition.setReturnType(returnType);
        functionDefinition.setFormalParameters(new ArrayList<>());
        functionDefinition.setBody(statement);

        return functionDefinition;
	}
}
