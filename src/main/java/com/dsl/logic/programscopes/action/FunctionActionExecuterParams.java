package com.dsl.logic.programscopes.action;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.acts.ActExecution;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;
import ASTMCore.ASTMSyntax.Expression.ActualParameterExpression;
import ASTMCore.ASTMSyntax.Expression.IdentifierReference;


@Component
public class FunctionActionExecuterParams implements IFunctionActionExecuterParams {

	@Override
	public ArrayList<ActualParameter> getActualParameterExpressions(ActExecution actExecution){
        ArrayList<ActualParameter> actualParameters = new ArrayList<>();

        for (FunctionArgument fa : actExecution.getFunctionArguments()){
            ActualParameterExpression actualParameter = getActualParameterExpression(fa);
            actualParameters.add(actualParameter);
        }

        return actualParameters;
    }

    private ActualParameterExpression getActualParameterExpression(FunctionArgument inFunctionArgument) {
    	Name name = GastFactory.getName(inFunctionArgument.getValue());
        
    	IdentifierReference identifierReference = new IdentifierReference();
        identifierReference.setIdentifierName(name);

        ActualParameterExpression actualParameter = new ActualParameterExpression();
        actualParameter.setValue(identifierReference);
        return actualParameter;
    }
}
