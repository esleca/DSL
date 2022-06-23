package com.dsl.logic.programscopes.asserts;

import com.dsl.models.unittests.asserts.AssertExpression;

import ASTMCore.ASTMSyntax.Expression.Expression;

public interface IFunctionAssertHandler {

	Expression getAssertExpression(AssertExpression assertExpression);
}
