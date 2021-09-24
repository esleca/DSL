package gestors;

import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;

public interface IGestorDSL {

    void readConfigurationFile() throws UnsupportedLanguageException;

    void beginTransformation() throws IOException, UnsupportedLanguageException;

    void processGastFunctions();

    void processTestableUnits();

    void readTestScenarios();

    void processUnitTests();

    void writeGastUnitTests();
}
