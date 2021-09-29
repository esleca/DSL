package testrun;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import gestors.GestorDSL;
import gestors.IGestorDSL;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;

public class Main {

    private final static IGestorDSL dsl = new GestorDSL();

    public static void main(String[] args)
            throws HeadlessException, IllegalArgumentException, SecurityException, IOException,
            UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException
    {
        // read source code files
        dsl.readConfigurationFile();

        // transform files to GAST
        dsl.beginTransformation();

        // Visit GAST functions
        dsl.processGastFunctions();

        // Create testable units
        dsl.processTestableUnits();

        // Read user test scenarios
        dsl.readTestScenarios();

        // Create functions unit tests
        dsl.processUnitTests();

        // Write unit tests to GAST
        dsl.writeGastUnitTests();
    }

}