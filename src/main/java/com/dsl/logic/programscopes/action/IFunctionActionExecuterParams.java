package com.dsl.logic.programscopes.action;

import java.util.ArrayList;

import com.dsl.models.unittests.acts.ActExecution;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;

public interface IFunctionActionExecuterParams {
	
	ArrayList<ActualParameter> getActualParameterExpressions(ActExecution actExecution);
}
