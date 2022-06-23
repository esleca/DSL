package com.dsl.tests.logic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.dsl.logic.printers.PrinterBaseHandler;
import com.dsl.logic.printers.PrinterJavaHandler;

import ASTMCore.ASTMSemantics.ProgramScope;
import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.NameSpaceDefinition;


public class PrinterJavaHandlerTests {

	PrinterBaseHandler handler = new PrinterJavaHandler();
	
	
	//___________________________________________
    // test_generateCode_notNull
    //
    // GIVEN: Java language is used
    // WHEN:  generateCode is called
    // THEN:  Result is not null
    //___________________________________________
	@Test
	public void test_generateCode_notNull() {
		// Arrange
		CompilationUnit compilationUnit = new CompilationUnit();
		
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("package.name"));
		
		compilationUnit.setgPackage(namespace);
		compilationUnit.setImports(new ArrayList<ImportDeclaration>());
		compilationUnit.setOpensScope(new ProgramScope());
		
		// Act
		String result = handler.generateCode(compilationUnit, "path");
		
		// Assert
		assertNotNull(result);
	}
	
	
	//___________________________________________
    // test_generateCode_package
    //
    // GIVEN: Java language is used
    // WHEN:  generateCode is called
    // THEN:  Package is not null
    //___________________________________________
	@Test
	public void test_generateCode_package() {
		// Arrange
		CompilationUnit compilationUnit = new CompilationUnit();
		
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("package.name"));
		
		compilationUnit.setgPackage(namespace);
		compilationUnit.setImports(new ArrayList<ImportDeclaration>());
		compilationUnit.setOpensScope(new ProgramScope());
		
		// Act
		String result = handler.generateCode(compilationUnit, "path");
		
		// Assert
		assertTrue(result.contains("package"));
	}
	
	
	//___________________________________________
    // test_generateCode_language
    //
    // GIVEN: Java language is used
    // WHEN:  generateCode is called
    // THEN:  language is not null
    //___________________________________________
	@Test
	public void test_generateCode_language() {
		// Arrange
		CompilationUnit compilationUnit = new CompilationUnit();
		
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("package.name"));
		
		compilationUnit.setgPackage(namespace);
		compilationUnit.setImports(new ArrayList<ImportDeclaration>());
		compilationUnit.setOpensScope(new ProgramScope());
		
		// Act
		String result = handler.generateCode(compilationUnit, "path");
		
		// Assert
		assertTrue(result.contains("Output language: Java"));
	}
	
}
