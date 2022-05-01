package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
import encoders.JavaEncoder;

import org.springframework.stereotype.Component;

@Component
public class PrinterJavaHandler extends PrinterBaseHandler implements IPrinterHandler {
	
	@Override
	public void generateCode(CompilationUnit compilationUnit, String outPath) {
		writeJavaCode(compilationUnit, outPath);
	}
	
	private void writeJavaCode(CompilationUnit compilationUnit, String outPath) {
        Encoder encoder = new JavaEncoder();
        
        compilationUnit.accept(encoder);
        
        String outputPath = outPath + "\\GeneratedTests.java";
        
        writeCode(encoder.getGeneratedCode(), outputPath);
	}
}
