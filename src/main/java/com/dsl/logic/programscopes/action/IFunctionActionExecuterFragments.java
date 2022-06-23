package com.dsl.logic.programscopes.action;

import com.dsl.models.unittests.acts.ActExecution;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;

public interface IFunctionActionExecuterFragments {
	
	FunctionCallExpression getActFragmentExpression(ActExecution actExecution);
}
