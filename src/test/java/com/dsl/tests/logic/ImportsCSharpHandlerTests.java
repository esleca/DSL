package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.dsl.logic.imports.ImportsBaseHandler;
import com.dsl.logic.imports.ImportsCSharpHandler;

import ASTMCore.ASTMSource.CompilationUnit;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.ImportDeclaration;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.Name;
import ASTMCore.ASTMSyntax.DeclarationAndDefinition.NameSpaceDefinition;


public class ImportsCSharpHandlerTests {
	
	
	private ImportsBaseHandler csharpHandler = new ImportsCSharpHandler();
	


	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_NotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_NotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		List<ImportDeclaration> imports = compilationUnit.getImports();
		
		// Assert
		assertNotNull(imports);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_NotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response has 7 imports
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_Size() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		List<ImportDeclaration> imports = compilationUnit.getImports();
		
		// Assert
		assertTrue(imports.size() == 7);
	}
	
	
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_FirstNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response first import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_FirstNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(0);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_SecondNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Second import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_SecondNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(1);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_ThirdNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Third import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_ThirdNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(2);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_FourthNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Fourth import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_FourthNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(3);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_FifthNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Fifth import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_FifthNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(4);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_SixNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Six import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_SixNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(5);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_SeventhNotNull
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Seventh import is not null
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_SeventhNotNull() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(6);
		
		// Assert
		assertNotNull(imp);
	}
	
	
	
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_First_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response first import is System
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_First_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(0);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("System", result);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_Second_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Second import is System.Collections.Generic
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_Second_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(1);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("System.Collections.Generic", result);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_Third_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response third import is System.Linq
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_Third_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(2);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("System.Linq", result);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_Fourth_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Fourth import is System.Text
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_Fourth_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(3);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("System.Text", result);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_Fifth_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Fifth import is System.Threading.Tasks
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_Fifth_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(4);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("System.Threading.Tasks", result);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_Six_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Six import is Microsoft.VisualStudio...
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_Six_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(5);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("Microsoft.VisualStudio.TestTools.UnitTesting", result);
	}
	
	
	//__________________________________________________________
    // test_processCompilationUnitImports_CSharp_Seventh_Name
    //
    // GIVEN: processCompilationUnitImports function is executed
	// AND:   language is CSharp
    // WHEN:  final class imports are mapped
    // THEN:  Response Seventh import is Package.name
    //__________________________________________________________
	@Test
	public void test_processCompilationUnitImports_CSharp_Seventh_Name() {
		// Arrange 
		CompilationUnit compilationUnit = new CompilationUnit();
		NameSpaceDefinition namespace = new NameSpaceDefinition();
		namespace.setNameSpace(new Name("Package.name"));
		compilationUnit.setgPackage(namespace);
		
		// Act
		csharpHandler.processCompilationUnitImports(compilationUnit);
		ImportDeclaration imp = compilationUnit.getImports().get(6);
		String result = imp.getIdentifierName().getNameString();
		
		// Assert
		assertEquals("Package.name", result);
	}
	
	
	
}
