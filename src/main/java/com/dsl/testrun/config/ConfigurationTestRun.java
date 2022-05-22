package com.dsl.testrun.config;

import java.util.ArrayList;

public class ConfigurationTestRun {

    private final String inputDirectory;
    private final String outputDirectory;
    private final String outputCodeDirectory;
    private final String sourceLanguage;
    private final ArrayList<String> outputLanguages;

    public boolean isSemantic() {
        return semantic;
    }

    private final boolean semantic;
    private final boolean validateMap;

    public ConfigurationTestRun(String inputDirectory, String outputDirectory, String outputCodeDirectory, String sourceLanguage, ArrayList<String> outputLanguages, boolean validate, boolean semantic) {
        this.inputDirectory = inputDirectory;
        this.outputDirectory = outputDirectory;
        this.outputCodeDirectory = outputCodeDirectory;
        this.sourceLanguage = sourceLanguage;
        this.outputLanguages = outputLanguages;
        this.validateMap = validate;
        this.semantic = semantic;
    }

    public String getInputDirectory() {
        return inputDirectory;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }
    
    public String getOutputCodeDirectory() {
    	return outputCodeDirectory;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }
    
    public ArrayList<String> getOutputLanguages(){
    	return outputLanguages;
    }

    public boolean isValidateMap() {
        return validateMap;
    }
}
