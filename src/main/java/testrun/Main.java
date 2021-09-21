/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrun;

import gastmappers.exceptions.UnsupportedLanguageException;
import gestors.GestorDSL;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;

public class Main {

    private final static GestorDSL gestor = new GestorDSL();

    public static void main(String[] args) throws HeadlessException, IllegalArgumentException, SecurityException, IOException, UnsupportedLanguageException, ParseException {
        // read source code files
        gestor.readConfigurationFile();

        // transform files to GAST
        gestor.beginTransformation();

        // Visit GAST functions
        gestor.processGastFunctions();

        // Create testable units
        gestor.processTestableUnits();

        // Read user test scenarios
        gestor.readTestScenarios();

        // Create functions unit tests
        gestor.processUnitTests();

        // Write unit tests to GAST
        gestor.writeGastUnitTests();
    }

}