package com.dsl.fachade.local;

import com.dsl.exceptions.AssertNotFoundException;
import com.dsl.exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;

public interface IGestorDSL {

    void readConfigurationFile() throws UnsupportedLanguageException;

    void beginTransformation() throws IOException, UnsupportedLanguageException;

    void processGastFunctions();

    void processTestableUnits();

    void readTestScenarios() throws ValueTypeNotFoundException, AssertNotFoundException;

    void processUnitTests() throws AssertNotFoundException, ValueTypeNotFoundException, UnsupportedLanguageException;

    void processCompilationUnitsTests() throws UnsupportedLanguageException;
    
    void generateCode() throws UnsupportedLanguageException;
    
    void testgenerateCode() throws UnsupportedLanguageException, IOException;
}
