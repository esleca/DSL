package com.dsl.logic;

import com.dsl.logic.gast.*;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.AggregateTypeDefinition;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.DefintionObject;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.FunctionDefintion;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Modifiers;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PrivateModifier;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ProtectedModifier;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.PublicModifier;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.StaticModifier;
import ASTMCore.ASTMSyntax.Types.AggregateType;
import ASTMCore.ASTMSyntax.Types.ClassType;
import ASTMCore.ASTMSyntax.Types.NamedTypeReference;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class CompilationUnitHandlerTests {
	
	private final String DIRECTORY_NAME = Paths.get("").toAbsolutePath().toString();
	private final String TEST_CLASS_PATH = "\\src\\test\\java\\com\\dsl\\resources\\TestClass.java";
	private final String ERROR_CLASS_PATH = "\\src\\test\\java\\com\\dsl\\resources\\InvalidClass.java";
	
	private static ICompilationUnitHandler sut = new CompilationUnitHandler();
	
	@BeforeAll
	static void init() throws UnsupportedLanguageException {
		sut.setLanguage("JAVA");
	}
	

    //_________________________________________________
    // test_createCompUnits_OneCompUnit
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units 
    // THEN:  Handler identifies one compilation unit
    //_________________________________________________
    @Test
	public void test_createCompUnits_OneCompUnit() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);

    	//Assert
    	assertEquals(1, compUnits.size());
	}
    
    
    //_________________________________________________
    // test_createCompUnits_NoCompUnits
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Invalid class is send to Mapper
    // THEN:  Handler identifies no compilation units
    //  AND:  Error of not found is printed on console
    //_________________________________________________
    @Test
	public void test_createCompUnits_NoCompUnits() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + ERROR_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	//Assert
    	assertNull(compUnit.getgPackage());
	}
    
	
	//_________________________________________________
    // test_createCompUnits_CompUnitsNotNull
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units 
    // THEN:  Caller identifies no null response
    //_________________________________________________
    @Test
	public void test_createCompUnits_CompUnitsNotNull() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);

    	//Assert
    	assertNotNull(compUnits);
	}
    
    
    //_________________________________________________
    // test_createCompUnits_CompUnitNotNull
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units 
    // THEN:  Caller identifies no null response
    //_________________________________________________
    @Test
	public void test_createCompUnits_CompUnitNotNull() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	//Assert
    	assertNotNull(compUnit);
	}
    
    
    //_________________________________________________
    // test_createCompUnits_PackageNotNull
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units 
    // THEN:  Package mapped is not null
    //_________________________________________________
    @Test
	public void test_createCompUnits_PackageNotNull() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	//Assert
    	assertNotNull(compUnit.getgPackage());
	}
    
    
    //_________________________________________________
    // test_createCompUnits_PackageName
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units 
    // THEN:  Package name is mapped correctly
    //_________________________________________________
    @Test
	public void test_createCompUnits_PackageName() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	//Assert
    	assertEquals("com.dsl.resources", compUnit.getgPackage().getNameSpace().getNameString());
	}
    
    
    //_________________________________________________
    // test_createCompUnits_NoImports
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units 
    // THEN:  No imports are mapped
    //_________________________________________________
    @Test
	public void test_createCompUnits_NoImports() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	//Assert
    	assertEquals(0, compUnit.getImports().size());
	}

    
    //_________________________________________________
    // test_createCompUnits_JavaLanguage
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped with Java language 
    // THEN:  Compilation unit language is Java
    //_________________________________________________
    @Test
	public void test_createCompUnits_JavaLanguage() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	//Assert
    	assertEquals("Java", compUnit.getLanguage());
	}
    
  
    //_________________________________________________
    // test_createCompUnits_Definition_NotNull
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Definition Object is not null
    //_________________________________________________
    @Test
	public void test_createCompUnits_Definition_NotNull() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	DefintionObject definition = compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);
    	
    	//Assert
    	assertNotNull(definition);
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_Definition_InstanceOfAggregate
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Definition Object is an aggregate object
    //___________________________________________________________
    @Test
	public void test_createCompUnits_Definition_InstanceOfAggregate() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	DefintionObject definition = compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);
    	
    	//Assert
    	assertTrue(definition instanceof AggregateTypeDefinition);
	}
    

    //___________________________________________________________
    // test_createCompUnits_Aggregate_InstanceOfClassType
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Aggregate is instance of class type
    //___________________________________________________________
    @Test
	public void test_createCompUnits_Aggregate_InstanceOfClassType() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
    	ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggregateTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);
    	
    	AggregateType aggType = aggregateTypeDef.getAggregateType();
    	
    	//Assert
    	assertTrue(aggType instanceof ClassType);
	}

    
    //___________________________________________________
    // test_createCompUnits_ClassType_NotNull
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class type Object is not null
    //___________________________________________________
    @Test
	public void test_createCompUnits_ClassType_NotNull() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();
    	
    	//Assert
    	assertNotNull(classType);    	
	}
    
    
    //______________________________________________________
    // test_createCompUnits_ClassType_OneModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class has one mapped modifier
    //______________________________________________________
    @Test
	public void test_createCompUnits_ClassType_OneModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();
    	
    	List<Modifiers> modifiers = classType.getModifiers();
    	
    	//Assert
    	assertEquals(1, modifiers.size());    	
	}
    

    //____________________________________________________________
    // test_createCompUnits_ClassModifier_InstanceOfPublic
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class has a mapped public modifier
    //___________________________________________________________
    @Test
	public void test_createCompUnits_ClassModifier_InstanceOfPublic() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();
    	
    	Modifiers modifier = classType.getModifiers().get(0);
    	
    	//Assert
    	assertTrue(modifier instanceof PublicModifier);    	
	}
    
  
    //______________________________________________________
    // test_createCompUnits_ClassType_PublicModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class has a mapped public modifier
    //______________________________________________________
    @Test
	public void test_createCompUnits_ClassType_PublicModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();
    	
    	PublicModifier modifier = (PublicModifier) classType.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("public", modifier.getModifier());    	
	}
    
    
    //______________________________________________________
    // test_createCompUnits_ClassType_NoInterface
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class is not an interface
    //______________________________________________________
    @Test
	public void test_createCompUnits_ClassType_NoInterface() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();
    	
    	boolean isInstance = classType.isInterface();
    	
    	//Assert
    	assertFalse(isInstance);    	
	}
    
    
    //______________________________________________________
    // test_createCompUnits_ClassType_ClassName
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class mapped is called TestClass
    //______________________________________________________
    @Test
	public void test_createCompUnits_ClassType_ClassName() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();
    	
    	String className = classType.getNameString().getNameString();
    	
    	//Assert
    	assertEquals("TestClass", className);    	
	}
    
    
    //______________________________________________________
    // test_createCompUnits_ClassType_DefObjs_NotNull
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class definition objects are not null
    //______________________________________________________
    @Test
	public void test_createCompUnits_ClassType_DefObjs_NotNull() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	//Assert
    	assertNotNull(defintionObjects);    	
	}
    
    
    //______________________________________________________
    // test_createCompUnits_ClassType_DefObjs_IterNotNull
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class definitions iteration is not null
    //______________________________________________________
    @Test
	public void test_createCompUnits_ClassType_DefObjs_IterNotNull() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();

    	//Assert
    	for (DefintionObject defintionObject : defintionObjects) {
        	assertNotNull(defintionObject);   
		} 	
	}
    
    
    //______________________________________________________
    // test_createCompUnits_ClassType_DefObjs_Size
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  TestClass is mapped to compilation units
    // THEN:  Class definition objects contain 18 elements
    //______________________________________________________
    @Test
	public void test_createCompUnits_ClassType_DefObjs_Size() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	//Assert
    	assertEquals(18, defintionObjects.size());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_returnStringWithoutParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  First function mapped is returnStringWithoutParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_returnStringWithoutParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(0);

    	//Assert
    	assertEquals("returnStringWithoutParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_returnBoolWithoutParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Second function mapped is returnBoolWithoutParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_returnBoolWithoutParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(1);

    	//Assert
    	assertEquals("returnBoolWithoutParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_returnIntWithoutParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Third function mapped is returnBoolWithoutParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_returnIntWithoutParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(2);

    	//Assert
    	assertEquals("returnIntWithoutParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_returnObjWithoutParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Fourth function mapped is returnObjWithoutParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_returnObjWithoutParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(3);

    	//Assert
    	assertEquals("returnObjWithoutParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_returnStringWithParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Fifth function mapped is returnStringWithParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_returnStringWithParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(4);

    	//Assert
    	assertEquals("returnStringWithParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_returnBoolWithParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Sixth function mapped is returnBoolWithParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_returnBoolWithParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(5);

    	//Assert
    	assertEquals("returnBoolWithParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_returnIntWithParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Seventh function mapped is returnIntWithParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_returnIntWithParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(6);

    	//Assert
    	assertEquals("returnIntWithParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_returnObjWithParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Eighth function mapped is returnObjWithParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_returnObjWithParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(7);

    	//Assert
    	assertEquals("returnObjWithParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_noReturnWithParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Nine function mapped is noReturnWithParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_noReturnWithParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(8);

    	//Assert
    	assertEquals("noReturnWithParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_privateReturnString_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Tenth function mapped is privateReturnString
    //____________________________________________________________
    @Test
	public void test_createCompUnits_privateReturnStringWithoutParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(9);

    	//Assert
    	assertEquals("privateReturnString", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_privateReturnBool_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Eleventh function mapped is privateReturnBool
    //____________________________________________________________
    @Test
	public void test_createCompUnits_privateReturnBool_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(10);

    	//Assert
    	assertEquals("privateReturnBool", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_privateReturnInt_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Twelve function mapped is privateReturnInt
    //____________________________________________________________
    @Test
	public void test_createCompUnits_privateReturnInt_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(11);

    	//Assert
    	assertEquals("privateReturnInt", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_privateReturnObj_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Thirteen function mapped is privateReturnObj
    //____________________________________________________________
    @Test
	public void test_createCompUnits_privateReturnObj_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(12);

    	//Assert
    	assertEquals("privateReturnObj", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_staticReturnIntWithoutParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Function 14 mapped is staticReturnIntWithoutParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithoutParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(13);

    	//Assert
    	assertEquals("staticReturnIntWithoutParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_staticReturnIntWithParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Function 15 mapped is staticReturnIntWithParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(14);

    	//Assert
    	assertEquals("staticReturnIntWithParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_privateStaticReturnIntWithParams_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Function 16 mapped is privateStaticReturnIntWithParams
    //____________________________________________________________
    @Test
	public void test_createCompUnits_privateStaticReturnIntWithParams_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(15);

    	//Assert
    	assertEquals("privateStaticReturnIntWithParams", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_staticProtectedReturnInt_Name
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN: Function 17 mapped is staticProtectedReturnInt
    //____________________________________________________________
    @Test
	public void test_createCompUnits_staticProtectedReturnInt_Name() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(16);

    	//Assert
    	assertEquals("staticProtectedReturnInt", functionDef.getIdentifierName().getNameString());    	
	}
    
    
    
    
    
    //_____________________________________________________________________
    // test_createCompUnits_returnStringWithoutParams_PublicModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  First function modifier is public
    //______________________________________________________________
    @Test
	public void test_createCompUnits_returnStringWithoutParams_PublicModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(0);

    	PublicModifier modifier = (PublicModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("public", modifier.getModifier());    	  	
	}
    

    //_____________________________________________________________________
    // test_createCompUnits_returnBoolWithoutParams_PublicModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Second function modifier is public
    //______________________________________________________________
    @Test
	public void test_createCompUnits_returnBoolWithoutParams_PublicModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(1);

    	PublicModifier modifier = (PublicModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("public", modifier.getModifier());    	  	
	}

    
    //_____________________________________________________________________
    // test_createCompUnits_returnIntWithoutParams_PublicModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Third function modifier is public
    //______________________________________________________________
    @Test
	public void test_createCompUnits_returnIntWithoutParams_PublicModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(2);

    	PublicModifier modifier = (PublicModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("public", modifier.getModifier());    	  	
	}
    

    //_____________________________________________________________________
    // test_createCompUnits_returnStringWithParams_PublicModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Fifth function modifier is public
    //______________________________________________________________
    @Test
	public void test_createCompUnits_returnStringWithParams_PublicModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(4);

    	PublicModifier modifier = (PublicModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("public", modifier.getModifier());    	  	
	}
    
  
    //_____________________________________________________________________
    // test_createCompUnits_privateReturnString_PrivateModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Tenth function modifier is private
    //______________________________________________________________
    @Test
	public void test_createCompUnits_privateReturnString_PrivateModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(9);

    	PrivateModifier modifier = (PrivateModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("private", modifier.getModifier());    	  	
	}
    
  
    //_____________________________________________________________________
    // test_createCompUnits_privateReturnBool_PrivateModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Eleventh function modifier is private
    //______________________________________________________________
    @Test
	public void test_createCompUnits_privateReturnBool_PrivateModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(10);

    	PrivateModifier modifier = (PrivateModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("private", modifier.getModifier());    	  	
	}
    
  
    //_____________________________________________________________________
    // test_createCompUnits_privateReturnInt_PrivateModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Twelve function modifier is private
    //______________________________________________________________
    @Test
	public void test_createCompUnits_privateReturnInt_PrivateModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(11);

    	PrivateModifier modifier = (PrivateModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("private", modifier.getModifier());    	  	
	}
    
  
    //_____________________________________________________________________
    // test_createCompUnits_privateReturnObj_PrivateModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Thirteen function modifier is private
    //______________________________________________________________
    @Test
	public void test_createCompUnits_privateReturnObj_PrivateModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(12);

    	PrivateModifier modifier = (PrivateModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("private", modifier.getModifier());    	  	
	}
    
  
    //_____________________________________________________________________
    // test_createCompUnits_staticReturnIntWithoutParams_PublicModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  First function modifier is public
    //______________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithoutParams_PublicModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(13);

    	PublicModifier modifier = (PublicModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("public", modifier.getModifier());    	  	
	}
    
  
    //_____________________________________________________________________
    // test_createCompUnits_staticReturnIntWithoutParams_StaticModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Second function modifier is static
    //______________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithoutParams_StaticModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(13);

    	StaticModifier modifier = (StaticModifier) functionDef.getModifiers().get(1);
    	
    	//Assert
    	assertEquals("static", modifier.getModifier());    	  	
	}
    
    
    //_____________________________________________________________________
    // test_createCompUnits_staticReturnIntWithParams_PublicModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  First function modifier is public
    //______________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithParams_PublicModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(14);

    	PublicModifier modifier = (PublicModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("public", modifier.getModifier());    	  	
	}
    
    
    //_____________________________________________________________________
    // test_createCompUnits_staticReturnIntWithParams_StaticModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Second function modifier is static
    //______________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithParams_StaticModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(14);

    	StaticModifier modifier = (StaticModifier) functionDef.getModifiers().get(1);
    	
    	//Assert
    	assertEquals("static", modifier.getModifier());    	  	
	}
    
    
    //_____________________________________________________________________
    // test_createCompUnits_privateStaticReturnIntWithParams_StaticModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Function modifier is static
    //______________________________________________________________
    @Test
	public void test_createCompUnits_privateStaticReturnIntWithParams_StaticModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(15);

    	StaticModifier modifier = (StaticModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("static", modifier.getModifier());    	  	
	}
    
    
    //____________________________________________________________
    // test_createCompUnits_staticProtected_StaticModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Function modifier is static
    //____________________________________________________________
    @Test
	public void test_createCompUnits_staticProtected_StaticModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(16);

    	StaticModifier modifier = (StaticModifier) functionDef.getModifiers().get(0);
    	
    	//Assert
    	assertEquals("static", modifier.getModifier());    	  	
	}
    
    
    //______________________________________________________________
    // test_createCompUnits_staticProtected_ProtectedModifier
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Function modifier is static
    //______________________________________________________________
    @Test
	public void test_createCompUnits_staticProtected_ProtectedModifier() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(16);

    	ProtectedModifier modifier = (ProtectedModifier) functionDef.getModifiers().get(1);
    	
    	//Assert
    	assertEquals("protected", modifier.getModifier());    	  	
	}
    
    
    
    
    
    
    
    //______________________________________________________________
    // test_createCompUnits_returnStringWithoutParams_Return
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  First function return is a String
    //_____________________________________________________________
    @Test
	public void test_createCompUnits_returnStringWithoutParams_Return() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(0);

    	NamedTypeReference returnType = (NamedTypeReference) functionDef.getReturnType();
    	
    	//Assert
    	assertEquals("String", returnType.getTypeName().getNameString());    	
	}
    
    
    //______________________________________________________________
    // test_createCompUnits_returnBoolWithoutParams_Return
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Second function return is a boolean
    //_____________________________________________________________
    @Test
	public void test_createCompUnits_returnBoolWithoutParams_Return() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(1);

    	NamedTypeReference returnType = (NamedTypeReference) functionDef.getReturnType();
    	
    	//Assert
    	assertEquals("boolean", returnType.getTypeName().getNameString());    	
	}
    
    
    //______________________________________________________________
    // test_createCompUnits_returnIntWithoutParams_Return
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Third function return is an integer
    //_____________________________________________________________
    @Test
	public void test_createCompUnits_returnIntWithoutParams_Return() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(2);

    	NamedTypeReference returnType = (NamedTypeReference) functionDef.getReturnType();
    	
    	//Assert
    	assertEquals("int", returnType.getTypeName().getNameString());    	
	}
  
    
    //______________________________________________________________
    // test_createCompUnits_returnObjWithoutParams_Return
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Fourth function return is an objResponse object
    //_____________________________________________________________
    @Test
	public void test_createCompUnits_returnObjWithoutParams_Return() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(3);

    	NamedTypeReference returnType = (NamedTypeReference) functionDef.getReturnType();
    	
    	//Assert
    	assertEquals("objResponse", returnType.getTypeName().getNameString());    	
	}

    
    //______________________________________________________________
    // test_createCompUnits_noReturnWithParams_Return
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Nine function return is void
    //_____________________________________________________________
    @Test
	public void test_createCompUnits_noReturnWithParams_VoidReturn() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(8);

    	NamedTypeReference returnType = (NamedTypeReference) functionDef.getReturnType();
    	
    	//Assert
    	assertEquals("void", returnType.getTypeName().getNameString());    	
	}

    
    //______________________________________________________________
    // test_createCompUnits_staticReturnIntWithoutParams_IntReturn
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Thirteen function return is int
    //_____________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithoutParams_IntReturn() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(13);

    	NamedTypeReference returnType = (NamedTypeReference) functionDef.getReturnType();
    	
    	//Assert
    	assertEquals("int", returnType.getTypeName().getNameString());    	
	}
    
    
    
    
    
    //__________________________________________________________________
    // test_createCompUnits_returnStringWithoutParams_Parameters
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  First function parameters are empty
    //__________________________________________________________________
    @Test
	public void test_createCompUnits_returnStringWithoutParams_Parameters() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(0);

    	//Assert
    	assertEquals(0, functionDef.getFormalParameters().size());    	
	}
    
    
    //__________________________________________________________________
    // test_createCompUnits_returnBoolWithoutParams_Parameters
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Second function parameters are empty
    //__________________________________________________________________
    @Test
	public void test_createCompUnits_returnBoolWithoutParams_Parameters() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(1);

    	//Assert
    	assertEquals(0, functionDef.getFormalParameters().size());    	
	}
    
    
    //__________________________________________________________________
    // test_createCompUnits_returnIntWithoutParams_Parameters
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Third function parameters are empty
    //__________________________________________________________________
    @Test
	public void test_createCompUnits_returnIntWithoutParams_Parameters() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(2);

    	//Assert
    	assertEquals(0, functionDef.getFormalParameters().size());    	
	}
    
    
    //__________________________________________________________________
    // test_createCompUnits_returnStringWithParams_Parameters
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Fifth function parameters has one item
    //__________________________________________________________________
    @Test
	public void test_createCompUnits_returnStringWithParams_Parameters() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(4);

    	//Assert
    	assertEquals(1, functionDef.getFormalParameters().size());    	
	}
    
    
    //__________________________________________________________________
    // test_createCompUnits_returnBoolWithParams_Parameters
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Sixth function parameters has one item
    //__________________________________________________________________
    @Test
	public void test_createCompUnits_returnBoolWithParams_Parameters() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(5);

    	//Assert
    	assertEquals(1, functionDef.getFormalParameters().size());    	
	}
    
    
    //________________________________________________________
    // test_createCompUnits_staticReturnInt_Parameters
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Function parameters is empty
    //________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithoutParams_Parameters() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(13);

    	//Assert
    	assertTrue(functionDef.getFormalParameters().isEmpty());    	
	}
    
    
    //________________________________________________________
    // test_createCompUnits_staticReturnIntWithParams_Parameters
    //
    // GIVEN: CompilationUnitHandler is executed
    // WHEN:  Class functions are mapped correctly
    // THEN:  Function parameters has one item
    //________________________________________________________
    @Test
	public void test_createCompUnits_staticReturnIntWithParams_Parameters() throws IOException, UnsupportedLanguageException {
		//Arrange
		String classPath = DIRECTORY_NAME + TEST_CLASS_PATH;
    	
    	//Act
		ArrayList<CompilationUnit> compUnits = sut.createCompilationUnits(classPath);
    	CompilationUnit compUnit = compUnits.get(0);
    	
    	AggregateTypeDefinition aggTypeDef = (AggregateTypeDefinition)compUnit
    			.getOpensScope()
    			.getDeclOrDefn()
    			.get(0);

    	ClassType classType = (ClassType) aggTypeDef.getAggregateType();

    	ArrayList<DefintionObject> defintionObjects = classType.getOpensScope().getDeclOrDefn();
    	
    	FunctionDefintion functionDef = (FunctionDefintion)defintionObjects.get(14);

    	//Assert
    	assertEquals(1, functionDef.getFormalParameters().size());    	
	}
    
}
