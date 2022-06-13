package com.dsl.factories;

import com.dsl.logic.unittests.action.UnitTestActionBaseHandler;
import com.dsl.logic.unittests.action.UnitTestActionInstanceHandler;
import com.dsl.logic.unittests.action.UnitTestActionStaticHandler;

public class UnitTestActionFactory {
	
	public static UnitTestActionBaseHandler createActionHandler(boolean isStatic) {
		UnitTestActionBaseHandler handler;
		
		if(isStatic) {
			handler = new UnitTestActionStaticHandler();
		} else {
			handler = new UnitTestActionInstanceHandler();
		}
		
		return handler;
	}
}
