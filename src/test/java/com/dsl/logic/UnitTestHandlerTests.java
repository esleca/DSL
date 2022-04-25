package com.dsl.logic;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.logic.unittests.IUnitTestActionHandler;
import com.dsl.logic.unittests.IUnitTestArrangeHandler;
import com.dsl.logic.unittests.IUnitTestAssertHandler;
import com.dsl.logic.unittests.UnitTestHandler;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.UnitTest;
import com.dsl.models.entities.unittests.acts.Act;
import com.dsl.models.entities.unittests.arranges.Arrange;
import com.dsl.models.entities.unittests.asserts.Assert;

import static com.dsl.resources.DataTestHelper.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

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
