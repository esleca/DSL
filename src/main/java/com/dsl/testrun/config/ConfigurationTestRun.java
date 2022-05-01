package com.dsl.testrun.config;

import gastmappers.Language;

public class ConfigurationTestRun {

    private final String inputDirectory;
    private final String outputDirectory;
    private final String outputCodeDirectory;
    private final Language sourceLanguage;

    public boolean isSemantic() {
        return semantic;
    }

    private final boolean semantic;
    private final boolean validateMap;

    public ConfigurationTestRun(String inputDirectory, String outputDirectory, String outputCodeDirectory, Language sourceLanguage, boolean validate, boolean semantic) {
        this.inputDirectory = inputDirectory;
        this.outputDirectory = outputDirectory;
        this.outputCodeDirectory = outputCodeDirectory;
        this.sourceLanguage = sourceLanguage;
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

    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    public boolean isValidateMap() {
        return validateMap;
    }
}
