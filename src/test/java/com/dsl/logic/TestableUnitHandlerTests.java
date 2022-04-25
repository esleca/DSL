package com.dsl.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.models.entities.aggregates.Class;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.aggregates.Package;
import com.dsl.logic.unittests.TestableUnitHandler;

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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
    	function.setReturn(createPrimitiveReturn("String"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertEquals(1, testableUnits.size());
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("protected"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("private"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
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
    	Function function = createFunction(new Class("ClassName", new Package("com.PackageName")));
    	function.setModifier(createModifier("public"));
    	function.setReturn(createInstanceReturn("objResponse"));
    	functions.add(function);
    	
    	//Act
    	ArrayList<Function> testableUnits = _testableUnitHandler.processTestableUnits(functions);
    	
    	//Assert
    	assertTrue(testableUnits.get(0).isTestable());
	}

}
