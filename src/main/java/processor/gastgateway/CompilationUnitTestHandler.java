package processor.gastgateway;

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

import factories.gastfactories.IGastFactory;
import models.entities.aggregates.Package;
import models.entities.imports.Import;
import models.entities.unittests.FunctionArgument;
import models.entities.unittests.UnitTest;
import models.entities.unittests.acts.Act;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.asserts.Assert;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.valuetypes.ValueType;

import gestors.GestorModel;

import java.util.ArrayList;
import java.util.List;


public class CompilationUnitTestHandler implements ICompilationUnitTestHandler {

    private IGastFactory gastFactory;

    public CompilationUnitTestHandler(IGastFactory gastFactory){
        this.gastFactory = gastFactory;
    }

    @Override
    public ArrayList<CompilationUnit> processCompilationUnitTests(GestorModel model) {
        ArrayList<CompilationUnit> compilationUnitTests = new ArrayList<>();

        CompilationUnit compilationUnit = new CompilationUnit();

        processCompilationUnitPackage(compilationUnit, model);
        processCompilationUnitImports(compilationUnit, model); //TODO: IMPORTS
        processCompilationUnitScope(compilationUnit, model);

        compilationUnitTests.add(compilationUnit);

        return compilationUnitTests;
    }

    private void processCompilationUnitPackage(CompilationUnit compilationUnit, GestorModel model){
        NameSpaceDefinition nameSpaceDefinition = getNameSpaceDefinition(model);
        compilationUnit.setgPackage(nameSpaceDefinition);
    }

    private NameSpaceDefinition getNameSpaceDefinition(GestorModel model){
        NameSpaceDefinition nameSpaceDefinition = new NameSpaceDefinition();
        Name nameObj = new Name();

        Package pkg = model.getaClass().getPackage();
        nameObj.setNameString(pkg.getName());
        nameSpaceDefinition.setNameSpace(nameObj);

        return nameSpaceDefinition;
    }

    private void processCompilationUnitImports(CompilationUnit compilationUnit, GestorModel model){
        ArrayList<ImportDeclaration> importDeclarations = getImportDeclarations(model);
        compilationUnit.setImports(importDeclarations);
    }

    private ArrayList<ImportDeclaration> getImportDeclarations(GestorModel model){
        ArrayList<Import> imports = model.getaClass().getImports();
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

    private void processCompilationUnitScope(CompilationUnit compilationUnit, GestorModel model){
        ProgramScope programScope = getProgramScope(model);
        compilationUnit.setOpensScope(programScope);
    }

    private ProgramScope getProgramScope(GestorModel model){
        ProgramScope programScope = new ProgramScope();

        ArrayList<DefintionObject> definitions = getProgramScopeDefinitionObjects(model);
        programScope.setDeclOrDefn(definitions);

        return programScope;
    }

    private ArrayList<DefintionObject> getProgramScopeDefinitionObjects(GestorModel model){
        ArrayList<DefintionObject> definitions = new ArrayList<>();
        AggregateTypeDefinition aggregateTypeDefinition = new AggregateTypeDefinition();

        ClassType classType = getClassType(model);
        aggregateTypeDefinition.setAggregateType(classType);
        definitions.add(aggregateTypeDefinition);

        return definitions;
    }

    private ClassType getClassType(GestorModel model){
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

    private Name getNameString(GestorModel model){
        Name nameObj = new Name();
        String className = model.getaClass().getName();
        nameObj.setNameString(className + "_Tests");
        return nameObj;
    }

    private String getPackageName(GestorModel model){
        return model.getaClass().getPackage().getName();
    }

    private ArrayList<Modifiers> getModifiers(){
        ArrayList<Modifiers> modifiers = new ArrayList<>();
        modifiers.add(new PublicModifier());
        return modifiers;
    }

    private AggregateScope getAggregateScope(GestorModel model){
        AggregateScope openScope = new AggregateScope();

        ArrayList<DefintionObject> definitionObjects = getAggregateScopeDefinitionObjects(model);
        openScope.setDeclOrDefn(definitionObjects);

        return openScope;
    }

    private ArrayList<DefintionObject> getAggregateScopeDefinitionObjects(GestorModel model){
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
        Name name = new Name();
        String testName = unitTest.getTestScenario().getTestName();
        name.setNameString(testName);
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
        Name identifier = new Name();

        String identifierName = arrangeStatement.getDeclaration().getName();
        identifier.setNameString(identifierName);

        return identifier;
    }

    private NamedTypeReference getVariableDefinitionType(ArrangeStatement arrangeStatement){
        NamedTypeReference definitionType = new NamedTypeReference();
        Name name = new Name();

        name.setNameString(arrangeStatement.getDeclaration().getType());
        definitionType.setTypeName(name);

        return definitionType;
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
        Name identifier = new Name();

        String identifierName = assertExpression.getCalledFunction();
        identifier.setNameString(identifierName);

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
        Name identifier = new Name();

        String identifierName = assertExpression.getAssertType().getName();
        identifier.setNameString(identifierName);

        return identifier;
    }
}
