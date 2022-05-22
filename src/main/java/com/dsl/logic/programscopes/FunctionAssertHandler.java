package com.dsl.logic.programscopes;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.asserts.AssertExpression;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;
import ASTMCore.ASTMSyntax.Expression.ActualParameterExpression;
import ASTMCore.ASTMSyntax.Expression.Expression;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;
import ASTMCore.ASTMSyntax.Expression.IdentifierReference;


@Component
public class FunctionAssertHandler implements IFunctionAssertHandler {
	
	@Override
	public Expression getAssertExpression(AssertExpression assertExpression) {
		IdentifierReference identifierReference = getCalledFunctionIdentifierReference(assertExpression);
        ArrayList<ActualParameter> parameterExpressions = getActualParameterExpressions(assertExpression);
        Name functionName = GastFactory.getName(assertExpression.getAssertType().getName());

        FunctionCallExpression expression = new FunctionCallExpression();
        expression.setCalledFunction(identifierReference);
        expression.setActualParams(parameterExpressions);
        expression.setFunctionName(functionName);

        return expression;
	}
	
    
    private IdentifierReference getCalledFunctionIdentifierReference(AssertExpression assertExpression){
        if(assertExpression.getCalledFunction() == null) {
        	return null;
        }
    	
    	IdentifierReference identifierReference = new IdentifierReference();
        Name calledFunction = GastFactory.getName(assertExpression.getCalledFunction());
        identifierReference.setIdentifierName(calledFunction);

        return identifierReference;
    }

    private ArrayList<ActualParameter> getActualParameterExpressions(AssertExpression assertExpression){
        ArrayList<ActualParameter> actualParameters = new ArrayList<>();
        ArrayList<FunctionArgument> functionArguments = assertExpression.getFunctionArguments();

        for (FunctionArgument fa : functionArguments){
            ActualParameterExpression actualParameter = getActualParameterExpression(fa);
            actualParameters.add(actualParameter);
        }

        return actualParameters;
    }

    private ActualParameterExpression getActualParameterExpression(FunctionArgument inFunctionArgument) {
    	ActualParameterExpression actualParameter = new ActualParameterExpression();
        IdentifierReference identifierReference = new IdentifierReference();
        Name name = GastFactory.getName(inFunctionArgument.getValue());
        identifierReference.setIdentifierName(name);
        actualParameter.setValue(identifierReference);
        return actualParameter;
    }
}
