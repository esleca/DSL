package com.dsl.logic.printers;

import ASTMCore.ASTMSource.CompilationUnit;
import encoders.Encoder;
//import encoders.PythonEncoder;

public class PrinterPythonHandler extends PrinterBaseHandler {
	
	@Override
	public String generateCode(String className, CompilationUnit compilationUnit, String outPath) {
		return writePythonCode(className, compilationUnit, outPath);
	}
	
	private String writePythonCode(String className, CompilationUnit compilationUnit, String outPath) {
        //Encoder encoder = new PythonEncoder();
        //compilationUnit.accept(encoder);

        //String outputPath = outPath + "\\GeneratedTests.py";
        
        //writeCode(encoder.getGeneratedCode(), outputPath);
		return null;
	}
}
