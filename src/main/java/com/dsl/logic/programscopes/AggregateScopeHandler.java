package com.dsl.logic.programscopes;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.models.unittests.UnitTest;

import ASTMCore.ASTMSemantics.AggregateScope;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.DefintionObject;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.FunctionDefintion;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class AggregateScopeHandler implements IAggregateScopeHandler {

	private String language;
	private IFunctionScopeHandler functionScopeHandler;
	
	public AggregateScopeHandler(IFunctionScopeHandler functionScopeHandler) {
		this.functionScopeHandler = functionScopeHandler;
	}
	
	
	@Override
	public AggregateScope processAggregateScope(CompilationUnit compilationUnit, DSLModel model) throws UnsupportedLanguageException{
		language = compilationUnit.getLanguage();
		
		AggregateScope openScope = new AggregateScope();
        ArrayList<DefintionObject> definitionObjects = getAggregateScopeDefinitionObjects(model);
        openScope.setDeclOrDefn(definitionObjects);
        return openScope;
    }

    private ArrayList<DefintionObject> getAggregateScopeDefinitionObjects(DSLModel model) throws UnsupportedLanguageException{
        ArrayList<DefintionObject> definitions = new ArrayList<>();
        ArrayList<UnitTest> unitTests = model.getUnitTests(language);

        for (UnitTest ut : unitTests) {
            FunctionDefintion functionDefinition = functionScopeHandler.processFunctionDefinition(ut);
            definitions.add(functionDefinition);
        }

        return definitions;
    }
}
