package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;

public interface IPrinterHandler {
	
	void generateCode(CompilationUnit compilationUnit, String outPath);
}
