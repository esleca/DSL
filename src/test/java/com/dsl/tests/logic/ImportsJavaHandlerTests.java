package com.dsl.tests.logic;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import com.dsl.logic.imports.ImportsBaseHandler;
import com.dsl.logic.imports.ImportsJavaHandler;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.NameSpaceDefinition;


public class ImportsJavaHandlerTests {

	
	private ImportsBaseHandler javaHandler = new ImportsJavaHandler();
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_Java_NotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is Java
    // WHEN:  final class imports are mapped
    // THEN:  Response is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_Java_NotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		javaHandler.processCompilationUnitImports(compilationUnit);
		List<ImportDeclaration> imports = compilationUnit.getImports();
		
		// Assert
		assertNotNull(imports);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_Java_NotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is Java
    // WHEN:  final class imports are mapped
    // THEN:  Response has 3 imports
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_Java_Size() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		javaHandler.processCompilationUnitImports(compilationUnit);
		List<ImportDeclaration> imports = compilationUnit.getImports();
		
		// Assert
		assertTrue(imports.size() == 3);
	}
	
	
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_Java_FirstNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is Java
    // WHEN:  final class imports are mapped
    // THEN:  Response first import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_Java_FirstNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		javaHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(0);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_Java_SecondNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is Java
    // WHEN:  final class imports are mapped
    // THEN:  Response Second import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_Java_SecondNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		javaHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(1);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_Java_ThirdNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is Java
    // WHEN:  final class imports are mapped
    // THEN:  Response Third import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_Java_ThirdNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		javaHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(2);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_Java_First_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is Java
    // WHEN:  final class imports are mapped
    // THEN:  Response first import org.junit.jupiter.api.Test
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_Java_First_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		javaHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(0);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("org.junit.jupiter.api.Test", result);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_Java_Second_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is Java
    // WHEN:  final class imports are mapped
    // THEN:  Response Second import is org.junit.Assert.*
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_Java_Second_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		javaHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(1);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("org.junit.Assert.*", result);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_Java_Third_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is Java
    // WHEN:  final class imports are mapped
    // THEN:  Response Third import is Package.name
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_Java_Third_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		javaHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(2);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("Package.name", result);
	}
	
	
	
}
