package com.dsl.services.compunits;

import com.dsl.fachade.models.DSLModel;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface ICompUnitsTestService {
	
	void processCompilationUnitsTests(DSLModel model) throws UnsupportedLanguageException;
}
