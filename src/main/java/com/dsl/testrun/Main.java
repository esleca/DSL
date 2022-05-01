package com.dsl.testrun;

import com.dsl.fachade.local.GestorDSL;
import com.dsl.fachade.local.IGestorDSL;
import com.dsl.utils.ConsolePrinter;
import com.dsl.utils.IPrinter;

public class Main {

    private static IPrinter printer = new ConsolePrinter();
    private final static IGestorDSL dsl = new GestorDSL(printer);

    public static void main(String[] args) throws Exception {
    	System.out.println("Starting DSL...");
    	
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
        
        // Generate code 
        dsl.generateCode();
        
        System.out.println("Closing DSL...");
    }

}