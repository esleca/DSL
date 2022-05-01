package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
import encoders.CSharpEncoder;

import org.springframework.stereotype.Component;

@Component
public class PrinterCSharpHandler extends PrinterBaseHandler implements IPrinterHandler {
	
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
