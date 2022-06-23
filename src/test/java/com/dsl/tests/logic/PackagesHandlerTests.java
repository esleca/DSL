package com.dsl.tests.logic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.packages.IPackagesHandler;
import com.dsl.logic.packages.PackagesHandler;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Package;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.NameSpaceDefinition;


public class PackagesHandlerTests {

	private IPackagesHandler handler = new PackagesHandler();
	
	
	//__________________________________________________________
    // test_processCompilationUnitPackage_notNull
    //
    // GIVEN: processCompilationUnitPackage is called
    // WHEN:  java language is used
    // THEN:  package is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitPackage_notNull() {
		// Arrange
		CompilationUnit compilationUnit = new CompilationUnit();
		
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		Package localPackage = new Package("Package.Name");
		Class localClass = new Class("java", "sourceClassUnderTest", localPackage);
		
		DSLModel model = new DSLModel();
		model.setClass(localClass);
		
		// Act
		handler.processCompilationUnitPackage(compilationUnit, model);
		NameSpaceDefinition result = compilationUnit.getgPackage();
		
		// Assert
		assertNotNull(result);
	}
	

	//__________________________________________________________
    // test_processCompilationUnitPackage_Java_Tests
    //
    // GIVEN: processCompilationUnitPackage is called
    // WHEN:  java language is used
    // THEN:  package contains tests text
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitPackage_Java_Tests() {
		// Arrange
		CompilationUnit compilationUnit = new CompilationUnit();
		
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		Package localPackage = new Package("Package.Name");
		Class localClass = new Class("java", "sourceClassUnderTest", localPackage);
		
		DSLModel model = new DSLModel();
		model.setClass(localClass);
		
		// Act
		handler.processCompilationUnitPackage(compilationUnit, model);
		NameSpaceDefinition result = compilationUnit.getgPackage();
		
		// Assert
		assertTrue(result.getNameSpace().getNameString().toLowerCase().contains("tests"));
	}
	

	//__________________________________________________________
    // test_processCompilationUnitPackage_CSharp_Tests
    //
    // GIVEN: processCompilationUnitPackage is called
    // WHEN:  csharp language is used
    // THEN:  package contains tests text
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitPackage_CSharp_Tests() {
		// Arrange
		CompilationUnit compilationUnit = new CompilationUnit();
		
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		Package localPackage = new Package("Package.Name");
		Class localClass = new Class("csharp", "SourceClassUnderTest", localPackage);
		
		DSLModel model = new DSLModel();
		model.setClass(localClass);
		
		// Act
		handler.processCompilationUnitPackage(compilationUnit, model);
		NameSpaceDefinition result = compilationUnit.getgPackage();
		
		// Assert
		assertTrue(result.getNameSpace().getNameString().toLowerCase().contains("tests"));
	}
	
	
}
