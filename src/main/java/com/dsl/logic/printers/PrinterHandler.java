package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.factories.PrintersFactory;

import org.springframework.stereotype.Component;


@Component
public class PrinterHandler implements IPrinterHandler {

	@Override
	public void generateCode(CompilationUnit compilationUnit, String outLanguage, String outPath) throws UnsupportedLanguageException {
		PrinterBaseHandler handler = PrintersFactory.createPrinterHandler(outLanguage);
		handler.generateCode(compilationUnit, outPath);
	}
}
