package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
//import encoders.PythonEncoder;

public class PrinterPythonHandler extends PrinterBaseHandler {
	
	@Override
	public void generateCode(CompilationUnit compilationUnit, String outPath) {
		writePythonCode(compilationUnit, outPath);
	}
	
	private void writePythonCode(CompilationUnit compilationUnit, String outPath) {
        //Encoder encoder = new PythonEncoder();
        //compilationUnit.accept(encoder);

        //String outputPath = outPath + "\\GeneratedTests.py";
        
        //writeCode(encoder.getGeneratedCode(), outputPath);
	}
}
