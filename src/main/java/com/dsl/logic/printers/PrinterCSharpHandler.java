package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
import encoders.CSharpEncoder;

public class PrinterCSharpHandler extends PrinterBaseHandler {

	@Override
	public void generateCode(CompilationUnit compilationUnit, String outPath) {
		writeCSharpCode(compilationUnit, outPath);
	}
	
	private void writeCSharpCode(CompilationUnit compilationUnit, String outPath) {
        Encoder encoder = new CSharpEncoder();
        
        compilationUnit.accept(encoder);
        
        String outputPath = outPath + "\\GeneratedTests.cs";
        
        writeCode(encoder.getGeneratedCode(), outputPath);
	}
}
