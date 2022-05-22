package com.dsl.logic.programscopes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.dsl.factories.GastFactory;
import com.dsl.factories.LiteralsFactory;
import com.dsl.models.unittests.arranges.ArrangeStatement;
import com.dsl.models.valuetypes.ValueType;

import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Fragment;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.VariableDefinition;
import ASTMCore.ASTMSyntax.Expression.Literal;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;


@Component
public class FunctionArrangeHandler implements IFunctionArrangeHandler {

	@Override
	public VariableDefinition getArrangeVariableDefinition(ArrangeStatement arrangeStatement) {
		List<Fragment> fragments = getVariableFragments(arrangeStatement);
        NamedTypeReference definitionType = getVariableDefinitionType(arrangeStatement);

        VariableDefinition variableDefinition = new VariableDefinition();
        variableDefinition.setFragments(fragments);
        variableDefinition.setDefinitionType(definitionType);

        return variableDefinition;
	}
	
	
	private List<Fragment> getVariableFragments(ArrangeStatement arrangeStatement){
    	List<Fragment> fragments = new ArrayList<>();
        
        Literal expression = getFragmentExpression(arrangeStatement);
        Name identifier = GastFactory.getName(arrangeStatement.getDeclaration().getName());
        
        Fragment fragment = new Fragment();
        fragment.setInitialValue(expression);
        fragment.setIdentifierName(identifier);
        fragments.add(fragment);
        
        return fragments;
    }
    
	private Literal getFragmentExpression(ArrangeStatement arrangeStatement){
    	ValueType value = arrangeStatement.getDefinition().getValueType();
    	String valueType = arrangeStatement.getDeclaration().getType();

        Literal expression = LiteralsFactory.createLiteralExpression(valueType);
        expression.setValue(value.getValue().toString());

        return expression;
    }

    private NamedTypeReference getVariableDefinitionType(ArrangeStatement arrangeStatement){
        NamedTypeReference definitionType = new NamedTypeReference();
        Name name = new Name(arrangeStatement.getDeclaration().getType());
        definitionType.setTypeName(name);

        return definitionType;
    }
    
}
