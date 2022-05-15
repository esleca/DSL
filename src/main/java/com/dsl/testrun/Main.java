package com.dsl.testrun;

import com.dsl.fachade.local.GestorDSL;
import com.dsl.fachade.local.IGestorDSL;
import com.dsl.utils.ConsolePrinter;
import com.dsl.utils.IPrinter;

public class Main {

    private static IPrinter printer = new ConsolePrinter();
    private final static IGestorDSL dsl = new GestorDSL(printer);

    public static void main(String[] args) throws Exception {
    	System.out.println("############################ Starting DSL ############################\n\n");
    	
    	//dsl.testgenerateCode();
    	
    	// read source code files
    	System.out.println("------------------- Reading source code files DSL -------------------\n");
        dsl.readConfigurationFile();
    	
        // transform files to GAST
        System.out.println("---------------------- Transforming files to GAST -------------------\n");
        dsl.beginTransformation();

        // Visit GAST functions
        System.out.println("---------------------- Visiting GAST functions ----------------------\n");
        dsl.processGastFunctions();

        // Create testable units
        System.out.println("---------------------- Creating testable units ----------------------\n");
        dsl.processTestableUnits();

        // Read user test scenarios
        System.out.println("--------------------- Reading user test scenarios -------------------\n");
        dsl.readTestScenarios();

        // Create functions unit tests
        System.out.println("------------------- Creating functions unit tests -------------------\n");
        dsl.processUnitTests();

        // Write unit tests to GAST
        System.out.println("---------------------- Writing unit tests to GAST -------------------\n");
        dsl.processCompilationUnitsTests();
        
        // Generate code 
        System.out.println("------------------- Generating source code files  -------------------\n");
        dsl.generateCode();
        
        System.out.println("\n############################ Closing DSL ################################");
    }

}