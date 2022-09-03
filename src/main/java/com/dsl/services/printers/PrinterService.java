package com.dsl.services.printers;

import org.springframework.stereotype.Component;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.printers.IPrinterHandler;
import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class PrinterService implements IPrinterService {

	private IPrinterHandler _printerHandler;
	
	public PrinterService(IPrinterHandler printerHandler) {
		this._printerHandler = printerHandler;
	}
	
	@Override
	public void generateCode(DSLModel model, String language, String outPath) throws UnsupportedLanguageException, ValueTypeNotFoundException {
		String className = model.getlClass().getName();
		
    	CompilationUnit compilationUnit = model.getCompilationUnitsTests(language).get(0);
    	
		_printerHandler.generateCode(className, compilationUnit, language, outPath);
	}
}
