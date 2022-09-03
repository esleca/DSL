package com.dsl;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.IDSLFachade;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.models.language.LanguageCode;
import com.dsl.models.unittests.UnitTest;
import com.dsl.models.valuetypes.StringType;
import com.dsl.models.valuetypes.ValueType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FachadeMain implements CommandLineRunner{

	private IDSLFachade dsl;

    public FachadeMain(IDSLFachade inDsl) {
    	this.dsl = inDsl;
    }
    
    public static void main (String[] args) {
    	SpringApplication.run(FachadeMain.class, args);
    }
    
	@Override
	public void run(String... args) throws Exception {
		UnitTestRequest request = createUnitTestRequest();
		UnitTest ut = dsl.generateUnitTest(request);
		
//		System.out.println("\n-----------------GENERATED CODE-----------------");
		
//		if(ut != null) {
//			for (Iterator<LanguageCode> iterator = ut.getGeneratedCodes().iterator(); iterator.hasNext();) {
//				LanguageCode lc = iterator.next();
//				
//				System.out.println("Code Language: " + lc.getLanguage());
//				System.out.println(lc.getGeneratedCode());
//			}
//		}


		//FunctionTestsRequest functionRequest = createFunctionTestsRequest();
		//List<UnitTest> unitTests = dsl.getFunctionUnitTests(functionRequest);
		
		
		ClassTestsRequest cRequest = createClassTestsRequest();
		List<UnitTest> unitTests = dsl.getClassUnitTests(cRequest);
		
		//int a = unitTests.size();
	}
	
	private static FunctionTestsRequest createFunctionTestsRequest() {
		String packageName = "com.dsl.tests";
		String className = "ClassForTests";
		String functionName = "getMessage";
		
		FunctionTestsRequest functionRequest = new FunctionTestsRequest(packageName, className, functionName);
		
		return functionRequest;
	}
	
	private static ClassTestsRequest createClassTestsRequest() {
		String packageName = "com.dsl.logic";
		String className = "ClasePrueba";
		
		ClassTestsRequest classRequest = new ClassTestsRequest(packageName, className);
		
		return classRequest;
	}

	private static PackageTestsRequest createPackageTestsRequest() {
		String packageName = "com.dsl.tests";
		
		PackageTestsRequest pkgRequest = new PackageTestsRequest(packageName);
		
		return pkgRequest;
	}
	
    private static UnitTestRequest createUnitTestRequest() throws ValueTypeNotFoundException {
    	String classPath = "C:\\TestMapper\\JAVA\\Input\\Clase_Prueba.java";
    	String outputPath = "C:\\TestPrinter\\Output";
    	//String classPath = "C:\\TestMapper\\CSHARP\\Input\\Clase_Prueba.cs";
    	//String outputPath = "C:\\TestPrinter\\CSHARP\\Output";
    	
    	String testScenarioPath = "./src/main/java/com/dsl/testrun/config/testScenarioRun.json";
        String language = "JAVA"; // send JAVA or CSHARP
        
        try (FileReader reader = new FileReader(testScenarioPath)) {
            JSONParser jsonParser = new JSONParser();
        	JSONObject configObj = (JSONObject) jsonParser.parse(reader);
        
        	String function = 			(String) configObj.get("function");
            String testName = 			(String) configObj.get("testName");
            JSONArray parameters = 		(JSONArray) configObj.get("parameters");
            JSONObject expectedObj = 	(JSONObject) configObj.get("expected");
            String value = 				(String) expectedObj.get("value");
        	String type = 				(String) expectedObj.get("type");
            ValueType expected = 		ValueTypeFactory.createValueType(type, value);
            String assertion = 			(String) configObj.get("assertion");
            
            return new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);    
        
        } catch (IOException | ParseException e) {
            System.err.println("Error reading the test scenarios config file.");
            e.printStackTrace();
        }

        return null;
    }
}
