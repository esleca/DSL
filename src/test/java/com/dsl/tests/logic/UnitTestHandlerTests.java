package com.dsl.tests.logic;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.logic.unittests.action.IUnitTestActionHandler;
import com.dsl.logic.unittests.arrange.IUnitTestArrangeHandler;
import com.dsl.logic.unittests.asserts.IUnitTestAssertHandler;
import com.dsl.logic.unittests.UnitTestHandler;

import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UnitTestHandlerTests {
	
	@Mock
	private IUnitTestArrangeHandler _arrangeHandler;
	
	@Mock
	private IUnitTestActionHandler _actionHandler;
	    
	@Mock
	private IUnitTestAssertHandler _assertHandler;
	
	@InjectMocks
	private UnitTestHandler sut;
	
	
	//_____________________________________________
    // test_processUnitTest_NotNull
    //
    // GIVEN: UnitTestHandler is executed
    // WHEN:  processUnitTest is called
    // THEN:  UnitTest response is not null
    //_____________________________________________
	@Test
	public void test_processUnitTest_NotNull() throws AssertNotFoundException {
		//Arrange
//		TestScenario testScenario = getTestScenario();
//		
//		Arrange arrange = getArrange();
//		Act act = getInstanceAct();
//		Assert lassert = getAssert();
//		
//		when(_arrangeHandler.processUnitTestArrange(testScenario))
//			.thenReturn(arrange);
//	
//		when(_actionHandler.processUnitTestAct(testScenario))
//			.thenReturn(act);
//		
//		when(_assertHandler.processUnitTestAssert(testScenario))
//			.thenReturn(lassert);
		
		//Act
		//UnitTest unitTest = sut.processUnitTest(testScenario);
		
		//Assert
		//assertNotNull(unitTest);
	}
	
	
}
