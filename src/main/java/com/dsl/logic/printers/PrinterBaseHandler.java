package com.dsl.logic.printers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PrinterBaseHandler {
	
	protected void writeCode(String code, String outputPath) {
        File outputFile = new File(outputPath);

        if (outputFile.getParentFile() != null) {
            if (!outputFile.getParentFile().exists()) {
                boolean isDirsCreated = outputFile.getParentFile().mkdirs();
                if (!isDirsCreated) {
                    System.out.println("Directory \"" + outputFile.getParentFile() + "\" could not be created.");
                }
            }
        }

        try {
            boolean isFileCreated = outputFile.createNewFile();
            if (!isFileCreated) {
                System.out.println("Trying to create again file \"" + outputPath + "\", The file will be overwritten.");
            }

            OutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(code.getBytes());
            outputStream.close();
        } catch (IOException e) {
            System.err.println("Error creating the output file \"" + outputPath + "\".");
            e.printStackTrace();
        }
    }
	
}
