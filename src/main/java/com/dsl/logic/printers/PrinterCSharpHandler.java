package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
import encoders.CSharpEncoder;

public class PrinterCSharpHandler extends PrinterBaseHandler {

	@Override
	public String generateCode(CompilationUnit compilationUnit, String outPath) {
		return writeCSharpCode(compilationUnit, outPath);
	}
	
	private String writeCSharpCode(CompilationUnit compilationUnit, String outPath) {
        Encoder encoder = new CSharpEncoder();
        
        compilationUnit.accept(encoder);
        
        String outputCode = encoder.getGeneratedCode();
        String outputPath = outPath + "\\GeneratedTests.cs";
        
        writeCode(outputCode, outputPath);
        
        return outputCode;
	}
}
