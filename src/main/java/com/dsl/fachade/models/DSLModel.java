package com.dsl.fachade.models;

import ASTMCore.ASTMSource.CompilationUnit;
import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.unittests.TestScenario;
import com.dsl.models.unittests.UnitTest;
import com.dsl.testrun.config.ConfigurationTestRun;

import java.util.ArrayList;

public class DSLModel {

    private final boolean writeToDisk;
    private final String configurationPath;
    private final String testScenariosPath;
    private final String testScenarioPath;
    
    private Class lClass;
    private ArrayList<CompilationUnit> compilationUnits;
    private ArrayList<ArrayList<CompilationUnit>> compilationUnitsTests;
    private ArrayList<Function> compilationUnitFunctions;
    private ArrayList<Function> testableUnits;
    private TestScenario testScenario;
    private ArrayList<TestScenario> testScenarios;
    private UnitTest unitTest;    
    private ArrayList<ArrayList<UnitTest>> unitTests;
    private ArrayList<ConfigurationTestRun> configurationsRunFiles;
    private ArrayList<String> outLanguages;
    
    public DSLModel(){
    	writeToDisk = true;
    	
        compilationUnits = new ArrayList<>();
        compilationUnitsTests = new ArrayList<>();
        compilationUnitFunctions = new ArrayList<>();
        testableUnits = new ArrayList<>();
        testScenarios = new ArrayList<>();
        unitTests = new ArrayList<>();
        configurationsRunFiles = new ArrayList<>();
        
        configurationPath = "./src/main/java/com/dsl/testrun/config/configurationTestRun.json";
        testScenariosPath = "./src/main/java/com/dsl/testrun/config/testScenariosRun.json";
        testScenarioPath = "./src/main/java/com/dsl/testrun/config/testScenarioRun.json";
        
        //TODO: read languages from configuration file
        outLanguages = new ArrayList<String>(){
        	{
            	add("JAVA");
            	add("CSHARP");
        	}
        };
    }


    public boolean isWriteToDisk() {
        return writeToDisk;
    }

    public String getConfigurationPath() {
        return configurationPath;
    }

    public String getTestScenariosPath() {
        return testScenariosPath;
    }
    
    public String getTestScenarioPath() {
        return testScenarioPath;
    }
    
    public Class getlClass() {
        return lClass;
    }

    public void setClass(Class inClass) {
        this.lClass = inClass;
    }

    public ArrayList<CompilationUnit> getCompilationUnits() {
        return compilationUnits;
    }

    public void setCompilationUnits(ArrayList<CompilationUnit> compilationUnits) {
        this.compilationUnits = compilationUnits;
    }

    public ArrayList<CompilationUnit> getCompilationUnitsTests(String language) {
    	ArrayList<CompilationUnit> result = new ArrayList<CompilationUnit>();
    	
    	for(ArrayList<CompilationUnit> compUnits : compilationUnitsTests) {
 
    		for(CompilationUnit cu : compUnits) {
    			
    			if (cu.getLanguage().toUpperCase().equals( language.toUpperCase() )) {
        			result = compUnits;
        			break;
        		}	
    		}
    	}
    	
        return result;
    }

    public void addCompilationUnitsTests(ArrayList<CompilationUnit> compilationUnitsTests) {
        this.compilationUnitsTests.add(compilationUnitsTests);
    }

    public ArrayList<Function> getCompilationUnitFunctions() {
        return compilationUnitFunctions;
    }

    public void setCompilationUnitFunctions(ArrayList<Function> compilationUnitFunctions) {
        this.compilationUnitFunctions = compilationUnitFunctions;
    }

    public ArrayList<Function> getTestableUnits() {
        return testableUnits;
    }

    public void setTestableUnits(ArrayList<Function> testableUnits) {
        this.testableUnits = testableUnits;
    }

    public TestScenario getTestScenario() {
        return testScenario;
    }

    public void setTestScenario(TestScenario testScenario) {
        this.testScenario = testScenario;
    }

    public ArrayList<TestScenario> getTestScenarios() {
        return testScenarios;
    }

    public void setTestScenarios(ArrayList<TestScenario> testScenarios) {
        this.testScenarios = testScenarios;
    }

    public UnitTest getUnitTest() {
        return unitTest;
    }

    public void setUnitTest(UnitTest unitTest) {
        this.unitTest = unitTest;
    }

    public ArrayList<UnitTest> getUnitTests(String language) {
    	ArrayList<UnitTest> result = new ArrayList<UnitTest>();
    	
    	for(ArrayList<UnitTest> langUnitTests : unitTests) {
    		
    		for(UnitTest ut : langUnitTests) {
    		
        		if (ut.getLanguage().toUpperCase().equals( language.toUpperCase() )) {
        			result = langUnitTests;
        			break;
        		}	
    		}
    	}
    	
        return result;
    }
    
    public void addUnitTests(ArrayList<UnitTest> unitTests) {
        this.unitTests.add(unitTests);
    }

    public ArrayList<ConfigurationTestRun> getConfigurationsRunFiles() {
        return configurationsRunFiles;
    }

    public void setConfigurationsRunFiles(ArrayList<ConfigurationTestRun> configurationsRunFiles){
        this.configurationsRunFiles = configurationsRunFiles;
    }

	public ArrayList<String> getOutputLanguages() {
		return outLanguages;
	}

}
