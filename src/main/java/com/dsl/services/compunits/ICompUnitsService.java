package com.dsl.services.compunits;

import java.io.IOException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.ClassFunctionsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface ICompUnitsService {
	
	void createCompilationUnits(UnitTestRequest unitTestRequest, DSLModel model) throws IOException, UnsupportedLanguageException;
	
	void createCompilationUnits(ClassFunctionsRequest classRequest, DSLModel model) throws IOException, UnsupportedLanguageException;
}
