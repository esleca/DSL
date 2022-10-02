package com.dsl;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.dsl.models.dtos.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.fachade.IDSLFachade;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.models.valuetypes.ValueType;


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
//		UnitTestRequest request = createUnitTestRequest();
//		UnitTestResponse response = dsl.generateUnitTest(request);
//		printUnitTest(response);

		ClassFunctionsRequest classFunctionsRequest = createClassFunctionsRequest();
		List<ClassFunctionsResponse> classFunctions = dsl.getClassFunctions(classFunctionsRequest);

//		PackageTestsRequest req = createPackageTestsRequest();
//		List<UnitTestResponse> unitTestsResponse = dsl.getPackageUnitTests(req);
//		for (UnitTestResponse unitTest : unitTestsResponse) {
//			printUnitTest(unitTest);
//		}

//		ClassTestsRequest cRequest = createClassTestsRequest();
//		List<UnitTestResponse> unitTestsResponse = dsl.getClassUnitTests(cRequest);
//		for (UnitTestResponse unitTest : unitTestsResponse) {
//			printUnitTest(unitTest);
//		}

//		FunctionTestsRequest functionRequest = createFunctionTestsRequest();
//		List<UnitTestResponse> unitTestsResponse = dsl.getFunctionUnitTests(functionRequest);
//		for (UnitTestResponse unitTest : unitTestsResponse) {
//			printUnitTest(unitTest);
//		}

	}
	
	private static FunctionTestsRequest createFunctionTestsRequest() {
		String packageName = "com.dsl.logic";
		String className = "ClasePrueba";
		String functionName = "getPais";
		
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
		String packageName = "com.dsl.logic";
		
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
    
    private static ClassFunctionsRequest createClassFunctionsRequest() {
		String classPath = "C:\\TestMapper\\JAVA\\Input\\Clase_Prueba.java";
		String language = "JAVA"; // send JAVA or CSHARP

		ClassFunctionsRequest classRequest = new ClassFunctionsRequest(classPath, language);

		return classRequest;
    }

	private static void printUnitTest(UnitTestResponse unitTest){
		System.out.println("\nLanguage: " + unitTest.getLanguage() + "\n" +
				"Package: " + unitTest.getPackageName() + "\n" +
				"Class: " + unitTest.getClassName() + "\n" +
				"Function: " + unitTest.getFunctionName() + "\n" +
				"Test Name: " + unitTest.getTestName() + "\n" +
				"Assertion: " + unitTest.getAssertion());
	}
}
