package com.dsl.tests.factories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import com.dsl.factories.UnitTestActionFactory;
import com.dsl.logic.unittests.action.UnitTestActionBaseHandler;
import com.dsl.logic.unittests.action.UnitTestActionInstanceHandler;
import com.dsl.logic.unittests.action.UnitTestActionStaticHandler;


public class UnitTestActionFactoryTests {

	
	//_________________________________________________
    // test_createActionHandler_NotStaticNotNull
    //
    // GIVEN: function processed is not static
    // WHEN:  createActionHandler function is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_createActionHandler_NotStaticNotNull() {
		//Arrange
		boolean isStatic = false;
		
		//Act
		UnitTestActionBaseHandler result = UnitTestActionFactory.createActionHandler(isStatic);
		
		//Assert
		assertNotNull(result);
	}
	

	//_________________________________________________
    // test_createActionHandler_StaticNotNull
    //
    // GIVEN: function processed is static
    // WHEN:  createActionHandler function is called
    // THEN:  result is not null
    //_________________________________________________
	@Test
	public void test_createActionHandler_StaticNotNull() {
		//Arrange
		boolean isStatic = true;
		
		//Act
		UnitTestActionBaseHandler result = UnitTestActionFactory.createActionHandler(isStatic);
		
		//Assert
		assertNotNull(result);
	}
	

	//_________________________________________________
    // test_createActionHandler_InstanceHandler
    //
    // GIVEN: function processed is not static
    // WHEN:  createActionHandler function is called
    // THEN:  result is of type instance handler
    //_________________________________________________
	@Test
	public void test_createActionHandler_InstanceHandler() {
		//Arrange
		boolean isStatic = false;
		
		//Act
		UnitTestActionBaseHandler result = UnitTestActionFactory.createActionHandler(isStatic);
		
		//Assert
		assertTrue(result instanceof UnitTestActionInstanceHandler);
	}
	

	//_________________________________________________
    // test_createActionHandler_StaticHandler
    //
    // GIVEN: function processed is static
    // WHEN:  createActionHandler function is called
    // THEN:  result is of type static handler
    //_________________________________________________
	@Test
	public void test_createActionHandler_StaticHandler() {
		//Arrange
		boolean isStatic = true;
		
		//Act
		UnitTestActionBaseHandler result = UnitTestActionFactory.createActionHandler(isStatic);
		
		//Assert
		assertTrue(result instanceof UnitTestActionStaticHandler);
	}
	
}
