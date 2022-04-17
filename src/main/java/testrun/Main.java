package testrun;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import gastmappers.exceptions.UnsupportedLanguageException;
import fachade.local.GestorDSL;
import fachade.local.IGestorDSL;
import utils.ConsolePrinter;
import utils.IPrinter;

import java.awt.*;
import java.io.IOException;

public class Main {

    private static IPrinter printer = new ConsolePrinter();
    private final static IGestorDSL dsl = new GestorDSL(printer);

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
        dsl.processCompilationUnitsTests();
    }

}