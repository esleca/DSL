package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
import encoders.JavaEncoder;

public class PrinterJavaHandler extends PrinterBaseHandler {
	
	@Override
	public String generateCode(CompilationUnit compilationUnit, String outPath) {
		return writeJavaCode(compilationUnit, outPath);
	}
	
	private String writeJavaCode(CompilationUnit compilationUnit, String outPath) {
        Encoder encoder = new JavaEncoder();
        
        compilationUnit.accept(encoder);
        
        String outputCode = encoder.getGeneratedCode();
        String outputPath = outPath + "\\GeneratedTests.java";
        
        writeCode(outputCode, outputPath);
        
        return outputCode;
	}
}
