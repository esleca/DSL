package com.dsl.logic.programscopes;

import com.dsl.models.unittests.asserts.AssertExpression;

import ASTMCore.ASTMSyntax.Expression.Expression;

public interface IFunctionAssertHandler {

	Expression getAssertExpression(AssertExpression assertExpression);
}
