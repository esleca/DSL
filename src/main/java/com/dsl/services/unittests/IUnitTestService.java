package com.dsl.services.unittests;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.unittests.UnitTest;

import gastmappers.exceptions.UnsupportedLanguageException;

public interface IUnitTestService {
	
	UnitTest processUnitTest(DSLModel model, String language) throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException;
}
