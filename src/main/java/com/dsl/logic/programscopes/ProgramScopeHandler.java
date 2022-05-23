package com.dsl.logic.programscopes;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.GastFactory;
import com.dsl.models.unittests.UnitTest;

import ASTMCore.ASTMSemantics.AggregateScope;
import ASTMCore.ASTMSemantics.ProgramScope;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AggregateTypeDefinition;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.DefintionObject;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.FunctionDefintion;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;
import ASTMCore.ASTMSyntax.Types.ClassType;
import ASTMCore.ASTMSyntax.Types.ImplementsTo;
import ASTMCore.ASTMSyntax.Types.TypeParameter;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class ProgramScopeHandler implements IProgramScopeHandler {

	private String language;
	private IFunctionScopeHandler functionScopeHandler;
	
	public ProgramScopeHandler(IFunctionScopeHandler functionScopeHandler) {
		this.functionScopeHandler = functionScopeHandler;
	}
	
	
	@Override
	public void processCompilationUnitScope(CompilationUnit compilationUnit, DSLModel model) throws UnsupportedLanguageException {
		language = compilationUnit.getLanguage();
	
		ProgramScope programScope = getProgramScope(model);
        compilationUnit.setOpensScope(programScope);
	}
	
	
	private ProgramScope getProgramScope(DSLModel model) throws UnsupportedLanguageException{
        ProgramScope programScope = new ProgramScope();
        ArrayList<DefintionObject> definitions = getProgramScopeDefinitionObjects(model);
        programScope.setDeclOrDefn(definitions);

        return programScope;
    }

    private ArrayList<DefintionObject> getProgramScopeDefinitionObjects(DSLModel model) throws UnsupportedLanguageException{
        ArrayList<DefintionObject> definitions = new ArrayList<>();
        AggregateTypeDefinition aggregateTypeDefinition = new AggregateTypeDefinition();

        ClassType classType = getClassType(model);
        aggregateTypeDefinition.setAggregateType(classType);
        definitions.add(aggregateTypeDefinition);

        return definitions;
    }

    private ClassType getClassType(DSLModel model) throws UnsupportedLanguageException{
        Name nameObj = GastFactory.getName(model.getlClass().getName() + "_Tests");
        String packageName = model.getlClass().getPackage().getName();
        ArrayList<Modifiers> modifiers = getModifiers();
        AggregateScope aggregateScope = getAggregateScope(model);

        ClassType classType = new ClassType();
        classType.setNameString(nameObj);
        classType.setPackageName(packageName);
        classType.setModifiers(modifiers);
        classType.setOpensScope(aggregateScope);
        classType.setParameters(new ArrayList<TypeParameter>());
        classType.setImplementesTo(new ArrayList<ImplementsTo>());

        return classType;
    }

    private ArrayList<Modifiers> getModifiers(){
        ArrayList<Modifiers> modifiers = new ArrayList<>();
        modifiers.add(new PublicModifier());
        return modifiers;
    }

    private AggregateScope getAggregateScope(DSLModel model) throws UnsupportedLanguageException{
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
