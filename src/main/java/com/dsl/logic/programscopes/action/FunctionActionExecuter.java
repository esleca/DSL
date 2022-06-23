package com.dsl.logic.programscopes.action;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.acts.ActExecution;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.FunctionCallExpression;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;


@Component
public class FunctionActionExecuter implements IFunctionActionExecuter {

	private IFunctionActionExecuterFragments actionExecuterFragments;
	
	public FunctionActionExecuter(IFunctionActionExecuterFragments actionExecuterFragments) {
		this.actionExecuterFragments = actionExecuterFragments;
	}
	
	
	@Override
	public VariableDefinition getActExecutionVariableDefinition(ActExecution actExecution) {
		List<Fragment> fragments = getActExecutionVariableFragments(actExecution);
        NamedTypeReference definitionType = getActExecutionVariableDefinitionType(actExecution);

        VariableDefinition variableDefinition = new VariableDefinition();
        variableDefinition.setFragments(fragments);
        variableDefinition.setDefinitionType(definitionType);

        return variableDefinition;
	}

    private NamedTypeReference getActExecutionVariableDefinitionType(ActExecution actExecution){
        NamedTypeReference definitionType = new NamedTypeReference();
        Name name = new Name(actExecution.getDeclaration().getType());
        definitionType.setTypeName(name);
        
        return definitionType;
    }
	
	private List<Fragment> getActExecutionVariableFragments(ActExecution actExecution){
        List<Fragment> fragments = new ArrayList<>();
        Fragment fragment = new Fragment();

        FunctionCallExpression expression = actionExecuterFragments.getActFragmentExpression(actExecution);
        Name identifier = GastFactory.getName(actExecution.getDeclaration().getName());
        
        fragment.setInitialValue(expression);
        fragment.setIdentifierName(identifier);
        fragments.add(fragment);
        return fragments;
    }
}
