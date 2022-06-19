package com.dsl.logic.programscopes;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.UnitTest;
import com.dsl.logic.programscopes.body.IFunctionBodyHandler;
import com.dsl.logic.programscopes.modifiers.IFunctionModifiersHandler;
import com.dsl.logic.programscopes.returns.IFunctionReturnHandler;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.FormalParameterDefinition;
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
		ArrayList<Modifiers> modifiers = modifiersHandler.getModifiers(unitTest.getLanguage());
        TypeReference returnType = returnHandler.getReturnType();
        Name name = GastFactory.getName(unitTest.getTestScenario().getTestName());
        ArrayList<FormalParameterDefinition> formalParameters = new ArrayList<>();
        Statement statement = bodyHandler.processFunctionBody(unitTest);

        FunctionDefintion functionDefinition = new FunctionDefintion();
        functionDefinition.setModifiers(modifiers);
        functionDefinition.setReturnType(returnType);
        functionDefinition.setIdentifierName(name);
        functionDefinition.setFormalParameters(formalParameters);
        functionDefinition.setBody(statement);

        return functionDefinition;
	}
}
