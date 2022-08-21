package com.dsl.services.printers;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.LanguageFactory;
import com.dsl.logic.printers.IPrinterHandler;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.language.LanguageCode;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class PrinterService implements IPrinterService {

	private IPrinterHandler _printerHandler;
	
	public PrinterService(IPrinterHandler printerHandler) {
		this._printerHandler = printerHandler;
	}
	
	
	@Override
	public void generateCode(UnitTestRequest unitTestRequest, DSLModel model) throws UnsupportedLanguageException {
		ArrayList<String> outputLanguages = model.getOutputLanguages();
    	
    	for(String language : outputLanguages) {
    		String className = model.getlClass().getName();
        	CompilationUnit compilationUnit = model.getCompilationUnitsTests(language).get(0);
    		String code = _printerHandler.generateCode(className, compilationUnit, language, unitTestRequest.getOutputPath());
    		
    		LanguageCode langCode = LanguageFactory.createLanguageCode(language, code);
    		model.getUnitTest().addGeneratedCode(langCode);
    	}
	}
}
