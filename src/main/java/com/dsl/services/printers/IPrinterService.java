package com.dsl.services.printers;

import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IPrinterService {
	void generateCode(UnitTestRequest unitTestRequest, DSLModel model) throws UnsupportedLanguageException;
}
