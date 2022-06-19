package com.dsl.logic.programscopes;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;

import ASTMCore.ASTMSemantics.ProgramScope;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AggregateTypeDefinition;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.DefintionObject;
import ASTMCore.ASTMSyntax.Types.ClassType;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class ProgramScopeHandler implements IProgramScopeHandler {

	private IClassTypeHandler classTypeHandler;
	
	public ProgramScopeHandler(IClassTypeHandler classTypeHandler) {
		this.classTypeHandler = classTypeHandler;
	}
	
	
	@Override
	public void processCompilationUnitScope(CompilationUnit compilationUnit, DSLModel model) throws UnsupportedLanguageException {
		ProgramScope programScope = new ProgramScope();
        ArrayList<DefintionObject> definitions = getProgramScopeDefinitionObjects(compilationUnit, model);
        programScope.setDeclOrDefn(definitions);
        compilationUnit.setOpensScope(programScope);
	}

    private ArrayList<DefintionObject> getProgramScopeDefinitionObjects(CompilationUnit compilationUnit, DSLModel model) throws UnsupportedLanguageException{
        ArrayList<DefintionObject> definitions = new ArrayList<>();
        AggregateTypeDefinition aggregateTypeDefinition = new AggregateTypeDefinition();

        ClassType classType = classTypeHandler.getClassType(compilationUnit, model);
        aggregateTypeDefinition.setAggregateType(classType);
        definitions.add(aggregateTypeDefinition);

        return definitions;
    }
}
