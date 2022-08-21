package com.dsl.services.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IUnitTestService {
	
	void processUnitTest(DSLModel model) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException;
}
