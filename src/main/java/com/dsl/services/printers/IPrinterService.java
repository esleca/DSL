package com.dsl.services.printers;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import gastmappers.exceptions.UnsupportedLanguageException;

public interface IPrinterService {
	
	void generateCode(DSLModel model, String language, String outPath) throws UnsupportedLanguageException, ValueTypeNotFoundException;
}
