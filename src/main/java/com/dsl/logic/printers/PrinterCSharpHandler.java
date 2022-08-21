package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
import encoders.CSharpEncoder;

public class PrinterCSharpHandler extends PrinterBaseHandler {

	@Override
	public String generateCode(String className, CompilationUnit compilationUnit, String outPath) {
		return writeCSharpCode(className, compilationUnit, outPath);
	}
	
	private String writeCSharpCode(String className, CompilationUnit compilationUnit, String outPath) {
        Encoder encoder = new CSharpEncoder();
        
        compilationUnit.accept(encoder);
        
        String outputCode = encoder.getGeneratedCode();
        String outputPath = outPath + "\\" + className + "_Tests.cs";
        
        writeCode(outputCode, outputPath);
        
        return outputCode;
	}
}
