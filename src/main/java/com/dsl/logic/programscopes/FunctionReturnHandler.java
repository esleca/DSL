package com.dsl.logic.programscopes;

import static com.dsl.utils.Constants.RETURN_VOID;

import org.springframework.stereotype.Component;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;
import ASTMCore.ASTMSyntax.Types.TypeReference;


@Component
public class FunctionReturnHandler implements IFunctionReturnHandler {

	@Override
	public TypeReference getReturnType() {
		NamedTypeReference returnType = new NamedTypeReference();
        Name name = new Name(RETURN_VOID);
        returnType.setTypeName(name);

        return returnType;
	}

}
