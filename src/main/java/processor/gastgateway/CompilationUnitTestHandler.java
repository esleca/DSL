package processor.gastgateway;

import ASTMCore.ASTMSemantics.AggregateScope;
import ASTMCore.ASTMSemantics.ProgramScope;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.*;
import ASTMCore.ASTMSyntax.Statement.BlockStatement;
import ASTMCore.ASTMSyntax.Statement.Statement;
import ASTMCore.ASTMSyntax.Types.ClassType;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;
import ASTMCore.ASTMSyntax.Types.TypeReference;
import gestors.GestorModel;
import models.entities.aggregates.Package;
import models.entities.imports.Import;
import models.entities.unittests.UnitTest;
import models.entities.unittests.acts.Act;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.asserts.Assert;

import java.util.ArrayList;

public class CompilationUnitTestHandler implements ICompilationUnitTestHandler {

    public CompilationUnitTestHandler(){
    }

    @Override
    public ArrayList<CompilationUnit> processCompilationUnitTests(GestorModel model) {
        ArrayList<CompilationUnit> compilationUnitTests = new ArrayList<>();

        CompilationUnit compilationUnit = new CompilationUnit();

        processCompilationUnitPackage(compilationUnit, model);
        processCompilationUnitImports(compilationUnit, model);
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
        ClassType classType = new ClassType();

        Name nameObj = getNameString(model);
        classType.setNameString(nameObj);

        String packageName = getPackageName(model);
        classType.setPackageName(packageName);

        ArrayList<Modifiers> modifiers = getModifiers();
        classType.setModifiers(modifiers);

        AggregateScope aggregateScope = getAggregateScope(model);
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
        FunctionDefintion functionDefinition = new FunctionDefintion();

        ArrayList<Modifiers> modifiers = getModifiers();
        functionDefinition.setModifiers(modifiers);

        TypeReference returnType = getReturnType();
        functionDefinition.setReturnType(returnType);

        Name name = getFunctionName(unitTest);
        functionDefinition.setIdentifierName(name);

        ArrayList<FormalParameterDefinition> formalParameters = getFormalParameterDefinitions();
        functionDefinition.setFormalParameters(formalParameters);

        Statement statement = getFunctionBody(unitTest);
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
        Act act = unitTest.getAct();
        Assert anAssert = unitTest.getAssert();

        

        return  subStatements;
    }

}
