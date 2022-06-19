package com.dsl.logic.programscopes;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.GastFactory;
import com.dsl.logic.programscopes.modifiers.IClassModifiersHandler;

import ASTMCore.ASTMSemantics.AggregateScope;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.Types.ClassType;
import ASTMCore.ASTMSyntax.Types.ImplementsTo;
import ASTMCore.ASTMSyntax.Types.TypeParameter;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class ClassTypeHandler implements IClassTypeHandler {

	private IClassModifiersHandler classModifiersHandler;
	private IAggregateScopeHandler aggregateScopeHandler;
	
	public ClassTypeHandler(IClassModifiersHandler classModifiersHandler, IAggregateScopeHandler aggregateScopeHandler) {
		this.classModifiersHandler = classModifiersHandler;
		this.aggregateScopeHandler = aggregateScopeHandler;
	}
	
	
	@Override
	public ClassType getClassType(CompilationUnit compilationUnit, DSLModel model) throws UnsupportedLanguageException{
        Name nameObj = GastFactory.getName(model.getlClass().getName() + "_Tests");
        String packageName = model.getlClass().getPackage().getName();
        ArrayList<Modifiers> modifiers = classModifiersHandler.getModifiers();
        AggregateScope aggregateScope = aggregateScopeHandler.getAggregateScope(compilationUnit, model);

        ClassType classType = new ClassType();
        classType.setNameString(nameObj);
        classType.setPackageName(packageName);
        classType.setModifiers(modifiers);
        classType.setOpensScope(aggregateScope);
        classType.setParameters(new ArrayList<TypeParameter>());
        classType.setImplementesTo(new ArrayList<ImplementsTo>());

        return classType;
    }
}
