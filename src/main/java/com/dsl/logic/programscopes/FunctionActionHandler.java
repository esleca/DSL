package com.dsl.logic.programscopes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.acts.ActExecution;
import com.dsl.models.unittests.acts.ActNewType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.ActualParameter;
import ASTMCore.ASTMSyntax.Expression.ActualParameterExpression;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;
import ASTMCore.ASTMSyntax.Expression.IdentifierReference;
import ASTMCore.ASTMSyntax.Expression.NewExpression;
import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;


@Component
public class FunctionActionHandler implements IFunctionActionHandler {

	@Override
	public DeclarationOrDefinitionStatement getDeclOrDefStatementExec(ActExecution actExecution) {
		DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
        VariableDefinition variableDefinitionExec = getActExecutionVariableDefinition(actExecution);
        decOrDefStatement.setDeclOrDefn(variableDefinitionExec);
        return decOrDefStatement;
	}

	@Override
	public DeclarationOrDefinitionStatement getDeclOrDefStatementNewType(ActNewType actNewType) {
		DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
        VariableDefinition variableDefinitionExec = getActNewTypeVariableDefinition(actNewType);
        decOrDefStatement.setDeclOrDefn(variableDefinitionExec);
        return decOrDefStatement;
	}
	

	// Act Execution
	
	private VariableDefinition getActExecutionVariableDefinition(ActExecution actExecution){
        List<Fragment> fragments = getActExecutionVariableFragments(actExecution);
        NamedTypeReference definitionType = getActExecutionVariableDefinitionType(actExecution);

        VariableDefinition variableDefinition = new VariableDefinition();
        variableDefinition.setFragments(fragments);
        variableDefinition.setDefinitionType(definitionType);

        return variableDefinition;
    }
	
    private List<Fragment> getActExecutionVariableFragments(ActExecution actExecution){
        List<Fragment> fragments = new ArrayList<>();
        Fragment fragment = new Fragment();

        FunctionCallExpression expression = getActFragmentExpression(actExecution);
        Name identifier = GastFactory.getName(actExecution.getDeclaration().getName());
        
        fragment.setInitialValue(expression);
        fragment.setIdentifierName(identifier);
        fragments.add(fragment);
        return fragments;
    }
    
    private FunctionCallExpression getActFragmentExpression(ActExecution actExecution){
        IdentifierReference identifierReference = getCalledFunctionIdentifierReference(actExecution);
        ArrayList<ActualParameter> parameterExpressions = getActualParameterExpressions(actExecution);
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

    private ArrayList<ActualParameter> getActualParameterExpressions(ActExecution actExecution){
        ArrayList<ActualParameter> actualParameters = new ArrayList<>();
        ArrayList<FunctionArgument> functionArguments = actExecution.getFunctionArguments();

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
    
    private NamedTypeReference getActExecutionVariableDefinitionType(ActExecution actExecution){
        NamedTypeReference definitionType = new NamedTypeReference();
        Name name = new Name(actExecution.getDeclaration().getType());
        definitionType.setTypeName(name);
        
        return definitionType;
    }
    
    
    // New Type
    
	private VariableDefinition getActNewTypeVariableDefinition(ActNewType actNewType){
        List<Fragment> fragments = getActNewTypeVariableFragments(actNewType);
        NamedTypeReference definitionType = getActNewTypeVariableDefinitionType(actNewType);

        VariableDefinition variableDefinition = new VariableDefinition();
        variableDefinition.setFragments(fragments);
        variableDefinition.setDefinitionType(definitionType);

        return variableDefinition;
    }
	
	private List<Fragment> getActNewTypeVariableFragments(ActNewType actNewType){
        List<Fragment> fragments = new ArrayList<>();
        Fragment fragment = new Fragment();

        NewExpression expression = getActNewTypeFragmentExpression(actNewType);
        Name identifier = GastFactory.getName(actNewType.getName());
        
        fragment.setInitialValue(expression);
        fragment.setIdentifierName(identifier);
        fragments.add(fragment);
        return fragments;
    }

    private NewExpression getActNewTypeFragmentExpression(ActNewType actNewType){
        NewExpression newExpression = new NewExpression();
        NamedTypeReference namedTypeReference = new NamedTypeReference();
        Name name = new Name(actNewType.getType());
        namedTypeReference.setTypeName(name);
        newExpression.setNewType(namedTypeReference);
        return newExpression;
    }
    
    private NamedTypeReference getActNewTypeVariableDefinitionType(ActNewType actNewType){
        NamedTypeReference definitionType = new NamedTypeReference();
        Name name = new Name(actNewType.getType());
        definitionType.setTypeName(name);

        return definitionType;
    }
    
}
