package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
import encoders.JavaEncoder;

public class PrinterJavaHandler extends PrinterBaseHandler {
	
	@Override
	public String generateCode(String className, CompilationUnit compilationUnit, String outPath) {
		return writeJavaCode(className, compilationUnit, outPath);
	}
	
	private String writeJavaCode(String className, CompilationUnit compilationUnit, String outPath) {
        Encoder encoder = new JavaEncoder();
        
        compilationUnit.accept(encoder);
        
        String outputCode = encoder.getGeneratedCode();
        String outputPath = outPath + "\\" + className + "_Tests.java";
        
        writeCode(outputCode, outputPath);
        
        return outputCode;
	}
}
