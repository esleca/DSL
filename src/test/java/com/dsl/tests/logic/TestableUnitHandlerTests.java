package com.dsl.tests.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.logic.testableunits.TestableUnitHandler;

import static com.dsl.factories.AggregatesFactory.*;
import static com.dsl.factories.ModifiersFactory.*;
import static com.dsl.factories.ReturnsFactory.*;

public class TestableUnitHandlerTests {
	
	private TestableUnitHandler _testableUnitHandler = new TestableUnitHandler();
	
	
    //__________________________________________________
    // test_processTestableUnits_countValid
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a String return type
    // THEN:  One testable unit is computed
    //__________________________________________________
    @Test
	public void test_processTestableUnits_countValid() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(1, testableUnits.size());
	}
    
    
    //_____________________________________________________
    // test_processTestableUnits_TwoCountValid
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There are two public function 
	//  AND:  Functions has a String and long return types
    // THEN:  One testable unit is computed
    //_____________________________________________________
    @Test
	public void test_processTestableUnits_TwoCountValid() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));
    	functions.add(function);
    	
    	function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("long"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(2, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_PublicModifier_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a String return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_PublicModifier_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________________
    // test_processTestableUnits_ProtectedModifier_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one protected function 
	//  AND:  Function has a String return type
    // THEN:  Function returned is testable
    //__________________________________________________________
    @Test
	public void test_processTestableUnits_ProtectedModifier_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("protected"));
    	function.setReturn(createPrimitiveReturn("String"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_PrivateModifier_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one private function 
	//  AND:  Function has a String return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_PrivateModifier_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("private"));
    	function.setReturn(createPrimitiveReturn("String"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_VoidReturn_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a void return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_VoidReturn_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("void"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_StringReturn_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a String return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_StringReturn_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_CharReturn_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a char return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_CharReturn_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("char"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_IntReturn_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a int return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_IntReturn_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("int"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_LongReturn_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a long return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_LongReturn_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("long"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_FloatReturn_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a float return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_FloatReturn_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("float"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_DoubleReturn_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a double return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_DoubleReturn_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("double"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_ObjReturn_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  There is one public function 
	//  AND:  Function has a object return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_ObjReturn_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_PublicStatic_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one public modifier
	//  AND:  Function has one static modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_PublicStatic_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.addModifier(createModifier("static"));
    	function.setStatic(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_ProtectedStatic_Testable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one protected modifier
	//  AND:  Function has one static modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_ProtectedStatic_Testable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("protected"));
    	function.addModifier(createModifier("static"));
    	function.setStatic(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_PrivateStatic_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one private modifier
	//  AND:  Function has one static modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_PrivateStatic_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("private"));
    	function.addModifier(createModifier("static"));
    	function.setStatic(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    
    //__________________________________________________
    // test_processTestableUnits_OnlyStatic_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one static modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_OnlyStatic_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("static"));
    	function.setStatic(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_PublicAbstract_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one public modifier
	//  AND:  Function has one abstract modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_PublicAbstract_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.addModifier(createModifier("abstract"));
    	function.setAbstract(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_ProtectedAbstract_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one protected modifier
	//  AND:  Function has one abstract modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_ProtectedAbstract_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("protected"));
    	function.addModifier(createModifier("abstract"));
    	function.setAbstract(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_PublicStaticAbstract_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one Public modifier
	//  AND:  Function has one static modifier
	//  AND:  Function has one abstract modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_PublicStaticAbstract_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("public"));
    	function.addModifier(createModifier("static"));
    	function.addModifier(createModifier("abstract"));
    	function.setStatic(true);
    	function.setAbstract(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_ProtectedStaticAbstract_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one protected modifier
	//  AND:  Function has one static modifier
	//  AND:  Function has one abstract modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_ProtectedStaticAbstract_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("protected"));
    	function.addModifier(createModifier("static"));
    	function.addModifier(createModifier("abstract"));
    	function.setStatic(true);
    	function.setAbstract(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_PrivateStaticAbstract_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one private modifier
	//  AND:  Function has one static modifier
	//  AND:  Function has one abstract modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_PrivateStaticAbstract_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("private"));
    	function.addModifier(createModifier("static"));
    	function.addModifier(createModifier("abstract"));
    	function.setStatic(true);
    	function.setAbstract(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}
    
    
    //__________________________________________________
    // test_processTestableUnits_StaticAbstract_NotTestable
    //
    // GIVEN: TestableUnitHandler is executed
    // WHEN:  processTestableUnits function is called
	//  AND:  Function has one static modifier
	//  AND:  Function has one abstract modifier
	//  AND:  Function has a object return type
    // THEN:  Function returned is not testable
    //__________________________________________________
    @Test
	public void test_processTestableUnits_StaticAbstract_NotTestable() throws ModifierNotFoundException, ReturnNotFoundException {
		//Arrange
    	ArrayList<Function> functions = new ArrayList<Function>();
    	Function function = createFunction(new Class("Java", "ClassName", new Package("com.PackageName")));
    	function.addModifier(createModifier("static"));
    	function.addModifier(createModifier("abstract"));
    	function.setStatic(true);
    	function.setAbstract(true);
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(0, testableUnits.size());
	}

}
