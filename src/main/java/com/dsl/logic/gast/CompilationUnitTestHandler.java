package com.dsl.logic.gast;

import ASTMCore.ASTMSemantics.AggregateScope;
import ASTMCore.ASTMSemantics.ProgramScope;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.*;
import ASTMCore.ASTMSyntax.Expression.*;
import ASTMCore.ASTMSyntax.Statement.BlockStatement;
import ASTMCore.ASTMSyntax.Statement.DeclarationOrDefinitionStatement;
import ASTMCore.ASTMSyntax.Statement.ExpressionStatement;
import ASTMCore.ASTMSyntax.Statement.Statement;
import ASTMCore.ASTMSyntax.Types.ClassType;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;
import ASTMCore.ASTMSyntax.Types.TypeReference;

import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.gastfactories.GastFactory;
import com.dsl.models.entities.aggregates.Package;
import com.dsl.models.entities.imports.Import;
import com.dsl.models.entities.unittests.FunctionArgument;
import com.dsl.models.entities.unittests.UnitTest;
import com.dsl.models.entities.unittests.acts.*;
import com.dsl.models.entities.unittests.arranges.Arrange;
import com.dsl.models.entities.unittests.arranges.ArrangeStatement;
import com.dsl.models.entities.unittests.asserts.Assert;
import com.dsl.models.entities.unittests.asserts.AssertExpression;
import com.dsl.models.entities.valuetypes.ValueType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CompilationUnitTestHandler implements ICompilationUnitTestHandler {

    @Override
    public ArrayList<CompilationUnit> processCompilationUnitTests(DSLModel model) {
        ArrayList<CompilationUnit> compilationUnitTests = new ArrayList<>();

        CompilationUnit compilationUnit = GastFactory.getCompilationUnit();

        processCompilationUnitPackage(compilationUnit, model);
        processCompilationUnitImports(compilationUnit, model); //TODO: IMPORTS
        processCompilationUnitScope(compilationUnit, model);

        compilationUnitTests.add(compilationUnit);

        return compilationUnitTests;
    }

    private void processCompilationUnitPackage(CompilationUnit compilationUnit, DSLModel model){
        NameSpaceDefinition nameSpaceDefinition = getNameSpaceDefinition(model);
        compilationUnit.setgPackage(nameSpaceDefinition);
    }

    private NameSpaceDefinition getNameSpaceDefinition(DSLModel model){
        NameSpaceDefinition nameSpaceDefinition = GastFactory.getNameSpaceDefinition();
        Name nameObj = GastFactory.getName();

        Package pkg = model.getlClass().getPackage();
        nameObj.setNameString(pkg.getName());
        nameSpaceDefinition.setNameSpace(nameObj);

        return nameSpaceDefinition;
    }

    private void processCompilationUnitImports(CompilationUnit compilationUnit, DSLModel model){
        ArrayList<ImportDeclaration> importDeclarations = getImportDeclarations(model);
        compilationUnit.setImports(importDeclarations);
    }

    private ArrayList<ImportDeclaration> getImportDeclarations(DSLModel model){
        ArrayList<Import> imports = model.getlClass().getImports();
        ArrayList<ImportDeclaration> importDeclarations = new ArrayList<>();
        for (Import i : imports) {
            ImportDeclaration importDeclaration = new ImportDeclaration();
            Name nameObj = new Name();

            nameObj.setNameString(i.getLibrary());
            importDeclaration.setIdentifierName(nameObj);

            importDeclarations.add(importDeclaration);
        }
        return importDeclarations;
    }

    private void processCompilationUnitScope(CompilationUnit compilationUnit, DSLModel model){
        ProgramScope programScope = getProgramScope(model);
        compilationUnit.setOpensScope(programScope);
    }

    private ProgramScope getProgramScope(DSLModel model){
        ProgramScope programScope = new ProgramScope();

        ArrayList<DefintionObject> definitions = getProgramScopeDefinitionObjects(model);
        programScope.setDeclOrDefn(definitions);

        return programScope;
    }

    private ArrayList<DefintionObject> getProgramScopeDefinitionObjects(DSLModel model){
        ArrayList<DefintionObject> definitions = new ArrayList<>();
        AggregateTypeDefinition aggregateTypeDefinition = new AggregateTypeDefinition();

        ClassType classType = getClassType(model);
        aggregateTypeDefinition.setAggregateType(classType);
        definitions.add(aggregateTypeDefinition);

        return definitions;
    }

    private ClassType getClassType(DSLModel model){
        Name nameObj = getNameString(model);
        String packageName = getPackageName(model);
        ArrayList<Modifiers> modifiers = getModifiers();
        AggregateScope aggregateScope = getAggregateScope(model);

        ClassType classType = new ClassType();
        classType.setNameString(nameObj);
        classType.setPackageName(packageName);
        classType.setModifiers(modifiers);
        classType.setOpensScope(aggregateScope);

        return classType;
    }

    private Name getNameString(DSLModel model){
        Name nameObj = getName(model.getlClass().getName() + "_Tests");
        return nameObj;
    }

    private String getPackageName(DSLModel model){
        return model.getlClass().getPackage().getName();
    }

    private ArrayList<Modifiers> getModifiers(){
        ArrayList<Modifiers> modifiers = new ArrayList<>();
        modifiers.add(new PublicModifier());
        return modifiers;
    }

    private AggregateScope getAggregateScope(DSLModel model){
        AggregateScope openScope = new AggregateScope();

        ArrayList<DefintionObject> definitionObjects = getAggregateScopeDefinitionObjects(model);
        openScope.setDeclOrDefn(definitionObjects);

        return openScope;
    }

    private ArrayList<DefintionObject> getAggregateScopeDefinitionObjects(DSLModel model){
        ArrayList<DefintionObject> definitions = new ArrayList<>();
        ArrayList<UnitTest> unitTests = model.getUnitTests();

        for (UnitTest ut : unitTests) {
            FunctionDefintion functionDefinition = getFunctionDefinition(ut);
            definitions.add(functionDefinition);
        }

        return definitions;
    }

    private FunctionDefintion getFunctionDefinition(UnitTest unitTest){
        ArrayList<Modifiers> modifiers = getModifiers();
        TypeReference returnType = getReturnType();
        Name name = getFunctionName(unitTest);
        ArrayList<FormalParameterDefinition> formalParameters = getFormalParameterDefinitions();
        Statement statement = getFunctionBody(unitTest);

        FunctionDefintion functionDefinition = new FunctionDefintion();
        functionDefinition.setModifiers(modifiers);
        functionDefinition.setReturnType(returnType);
        functionDefinition.setIdentifierName(name);
        functionDefinition.setFormalParameters(formalParameters);
        functionDefinition.setBody(statement);

        return functionDefinition;
    }

    private TypeReference getReturnType(){
        NamedTypeReference returnType = new NamedTypeReference();
        Name name = new Name();

        name.setNameString("void");
        returnType.setTypeName(name);

        return returnType;
    }

    private Name getFunctionName(UnitTest unitTest){
        Name name = getName(unitTest.getTestScenario().getTestName());
        return name;
    }

    private ArrayList<FormalParameterDefinition> getFormalParameterDefinitions(){
        return new ArrayList<>();
    }

    private Statement getFunctionBody(UnitTest unitTest){
        BlockStatement blockStatement = new BlockStatement();

        ArrayList<Statement> subStatements = getBlockSubStatements(unitTest);
        blockStatement.setSubStatements(subStatements);

        return blockStatement;
    }

    private ArrayList<Statement> getBlockSubStatements(UnitTest unitTest){
        ArrayList<Statement> subStatements = new ArrayList<>();

        Arrange arrange = unitTest.getArrange();

        for (ArrangeStatement as : arrange.getArrangeStatements()) {
            DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
            VariableDefinition variableDefinition = getArrangeVariableDefinition(as);
            decOrDefStatement.setDeclOrDefn(variableDefinition);
            subStatements.add(decOrDefStatement);
        }

        Act act = unitTest.getAct();

        if (act instanceof InstanceAct){
            InstanceAct action = (InstanceAct) act;
            ActNewType actNewType = action.getActNewType();
            ActExecution actExecution = action.getActExecution();

            DeclarationOrDefinitionStatement decOrDefStatementNew = getDeclOrDefStatementNewType(actNewType);
            DeclarationOrDefinitionStatement decOrDefStatement = getDeclOrDefStatementExec(actExecution);

            subStatements.add(decOrDefStatementNew);
            subStatements.add(decOrDefStatement);
        }else if (act instanceof StaticAct){
            StaticAct action = (StaticAct) act;
            ActExecution actExecution = action.getActExecution();
            DeclarationOrDefinitionStatement decOrDefStatement = getDeclOrDefStatementExec(actExecution);
            subStatements.add(decOrDefStatement);
        }

        Assert anAssert = unitTest.getAssert();

        for (AssertExpression ae : anAssert.getAssertExpressions()) {
            ExpressionStatement expressionStatement = new ExpressionStatement();
            Expression expression = getAssertExpression(ae);
            expressionStatement.setExpression(expression);
            subStatements.add(expressionStatement);
        }

        return  subStatements;
    }

    private VariableDefinition getArrangeVariableDefinition(ArrangeStatement arrangeStatement){
        List<Fragment> fragments = getVariableFragments(arrangeStatement);
        NamedTypeReference definitionType = getVariableDefinitionType(arrangeStatement);

        VariableDefinition variableDefinition = new VariableDefinition();
        variableDefinition.setFragments(fragments);
        variableDefinition.setDefinitionType(definitionType);

        return variableDefinition;
    }

    private List<Fragment> getVariableFragments(ArrangeStatement arrangeStatement){
        List<Fragment> fragments = new ArrayList<>();
        Fragment fragment = new Fragment();

        Literal expression = getFragmentExpression(arrangeStatement);
        fragment.setInitialValue(expression);

        Name identifier = getFragmentIdentifierName(arrangeStatement);
        fragment.setIdentifierName(identifier);

        fragments.add(fragment);

        return fragments;
    }

    private Literal getFragmentExpression(ArrangeStatement arrangeStatement){
        ValueType value = arrangeStatement.getDefinition().getValueType();

        Literal expression = new Literal();
        expression.setValue(value.getValue().toString());

        return expression;
    }

    private Name getFragmentIdentifierName(ArrangeStatement arrangeStatement){
        Name identifier = getName(arrangeStatement.getDeclaration().getName());
        return identifier;
    }

    private NamedTypeReference getVariableDefinitionType(ArrangeStatement arrangeStatement){
        NamedTypeReference definitionType = new NamedTypeReference();
        Name name = new Name();

        name.setNameString(arrangeStatement.getDeclaration().getType());
        definitionType.setTypeName(name);

        return definitionType;
    }


    private DeclarationOrDefinitionStatement getDeclOrDefStatementExec(ActExecution actExecution){
        DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
        VariableDefinition variableDefinitionExec = getActExecutionVariableDefinition(actExecution);
        decOrDefStatement.setDeclOrDefn(variableDefinitionExec);
        return decOrDefStatement;
    }

    private DeclarationOrDefinitionStatement getDeclOrDefStatementNewType(ActNewType actNewType){
        DeclarationOrDefinitionStatement decOrDefStatement = new DeclarationOrDefinitionStatement();
        VariableDefinition variableDefinitionExec = getActNewTypeVariableDefinition(actNewType);
        decOrDefStatement.setDeclOrDefn(variableDefinitionExec);
        return decOrDefStatement;
    }

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
        fragment.setInitialValue(expression);

        Name identifier = getActNewTypeFragmentIdentifierName(actNewType);
        fragment.setIdentifierName(identifier);

        fragments.add(fragment);

        return fragments;
    }

    private NewExpression getActNewTypeFragmentExpression(ActNewType actNewType){
        NewExpression newExpression = new NewExpression();
        NamedTypeReference namedTypeReference = new NamedTypeReference();
        Name name = new Name();
        name.setNameString(actNewType.getType());
        namedTypeReference.setTypeName(name);
        newExpression.setNewType(namedTypeReference);
        return newExpression;
    }

    private Name getActNewTypeFragmentIdentifierName(ActNewType actNewType){
        Name identifier = getName(actNewType.getName());
        return identifier;
    }

    private NamedTypeReference getActNewTypeVariableDefinitionType(ActNewType actNewType){
        NamedTypeReference definitionType = new NamedTypeReference();
        Name name = new Name();

        name.setNameString(actNewType.getType());
        definitionType.setTypeName(name);

        return definitionType;
    }

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
        fragment.setInitialValue(expression);

        Name identifier = getActFragmentIdentifierName(actExecution);
        fragment.setIdentifierName(identifier);

        fragments.add(fragment);

        return fragments;
    }

    private FunctionCallExpression getActFragmentExpression(ActExecution actExecution){
        IdentifierReference identifierReference = getCalledFunctionIdentifierReference(actExecution);
        ArrayList<ActualParameter> parameterExpressions = getActualParameterExpressions(actExecution);
        Name functionName = getFunctionNameIdentifierName(actExecution);

        FunctionCallExpression expression = new FunctionCallExpression();
        expression.setCalledFunction(identifierReference);
        expression.setActualParams(parameterExpressions);
        expression.setFunctionName(functionName);

        return expression;
    }

    private Name getActFragmentIdentifierName(ActExecution actExecution){
        Name identifier = getName(actExecution.getDeclaration().getName());
        return identifier;
    }

    private NamedTypeReference getActExecutionVariableDefinitionType(ActExecution actExecution){
        NamedTypeReference definitionType = new NamedTypeReference();
        Name name = new Name();

        name.setNameString(actExecution.getDeclaration().getType());
        definitionType.setTypeName(name);

        return definitionType;
    }

    private IdentifierReference getCalledFunctionIdentifierReference(ActExecution actExecution){
        IdentifierReference identifierReference = new IdentifierReference();
        Name calledFunction = getIdentifierReferenceIdentifierName(actExecution);
        identifierReference.setIdentifierName(calledFunction);

        return identifierReference;
    }

    private Name getIdentifierReferenceIdentifierName(ActExecution actExecution){
        Name identifier = getName(actExecution.getCalledFunction());
        return identifier;
    }

    private ArrayList<ActualParameter> getActualParameterExpressions(ActExecution actExecution){
        ArrayList<ActualParameter> actualParameters = new ArrayList<>();
        ArrayList<FunctionArgument> functionArguments = actExecution.getFunctionArguments();

        for (FunctionArgument fa : functionArguments){
            ActualParameterExpression actualParameter = new ActualParameterExpression();
            IdentifierReference identifierReference = new IdentifierReference();
            Name name = new Name();
            name.setNameString(fa.getValue());
            identifierReference.setIdentifierName(name);
            actualParameter.setValue(identifierReference);
            actualParameters.add(actualParameter);
        }

        return actualParameters;
    }

    private Name getFunctionNameIdentifierName(ActExecution actExecution){
        Name identifier = getName(actExecution.getFunctionName());
        return identifier;
    }


    private Expression getAssertExpression(AssertExpression assertExpression){
        IdentifierReference identifierReference = getCalledFunctionIdentifierReference(assertExpression);
        ArrayList<ActualParameter> parameterExpressions = getActualParameterExpressions(assertExpression);
        Name functionName = getFunctionNameIdentifierName(assertExpression);

        FunctionCallExpression expression = new FunctionCallExpression();
        expression.setCalledFunction(identifierReference);
        expression.setActualParams(parameterExpressions);
        expression.setFunctionName(functionName);

        return expression;
    }

    private IdentifierReference getCalledFunctionIdentifierReference(AssertExpression assertExpression){
        IdentifierReference identifierReference = new IdentifierReference();
        Name calledFunction = getIdentifierReferenceIdentifierName(assertExpression);
        identifierReference.setIdentifierName(calledFunction);

        return identifierReference;
    }

    private Name getIdentifierReferenceIdentifierName(AssertExpression assertExpression){
        Name identifier = getName(assertExpression.getCalledFunction());
        return identifier;
    }

    private ArrayList<ActualParameter> getActualParameterExpressions(AssertExpression assertExpression){
        ArrayList<ActualParameter> actualParameters = new ArrayList<>();
        ArrayList<FunctionArgument> functionArguments = assertExpression.getFunctionArguments();

        for (FunctionArgument fa : functionArguments){
            ActualParameterExpression actualParameter = new ActualParameterExpression();
            Literal literal = new Literal();
            literal.setValue(fa.getValue());
            actualParameter.setValue(literal);
            actualParameters.add(actualParameter);
        }

        return actualParameters;
    }

    private Name getFunctionNameIdentifierName(AssertExpression assertExpression){
        Name identifier = getName(assertExpression.getAssertType().getName());
        return identifier;
    }


    private Name getName(String name){
        Name identifier = new Name();
        identifier.setNameString(name);
        return identifier;
    }
}
