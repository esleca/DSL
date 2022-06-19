package com.dsl.logic.programscopes.action;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.acts.ActExecution;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;
import ASTMCore.ASTMSyntax.Expression.IdentifierReference;


@Component
public class FunctionActionExecuterFragments implements IFunctionActionExecuterFragments {

	private IFunctionActionExecuterParams actionExecuterParams;
	
	public FunctionActionExecuterFragments(IFunctionActionExecuterParams inActionExecuterParams){
		this.actionExecuterParams = inActionExecuterParams;
	}
	
	
	@Override
	public FunctionCallExpression getActFragmentExpression(ActExecution actExecution){
        IdentifierReference identifierReference = getCalledFunctionIdentifierReference(actExecution);
        ArrayList<ActualParameter> parameterExpressions = actionExecuterParams.getActualParameterExpressions(actExecution);
        Name functionName = GastFactory.getName(actExecution.getFunctionName());

        FunctionCallExpression expression = new FunctionCallExpression();
        expression.setCalledFunction(identifierReference);
        expression.setActualParams(parameterExpressions);
        expression.setFunctionName(functionName);

        return expression;
    }
	
    private IdentifierReference getCalledFunctionIdentifierReference(ActExecution actExecution){
        IdentifierReference identifierReference = new IdentifierReference();
        Name calledFunction = GastFactory.getName(actExecution.getCalledFunction());
        identifierReference.setIdentifierName(calledFunction);

        return identifierReference;
    }
}
