package com.dsl.logic.programscopes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.acts.ActNewType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.NewExpression;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;


@Component
public class FunctionActionInstantiator implements IFunctionActionInstantiator {

	@Override
	public VariableDefinition getActNewTypeVariableDefinition(ActNewType actNewType) {
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
        NamedTypeReference namedTypeReference = new NamedTypeReference();
        Name name = new Name(actNewType.getType());
        namedTypeReference.setTypeName(name);
        
        NewExpression newExpression = new NewExpression();
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
