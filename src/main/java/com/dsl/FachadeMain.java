package com.dsl;

import com.dsl.fachade.IDSLCrudFachade;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.testrun.config.ConfigurationTestRun;

import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FachadeMain implements CommandLineRunner{

	private IDSLCrudFachade dsl;

    public FachadeMain(IDSLCrudFachade inDsl) {
    	this.dsl = inDsl;
    }
    
    public static void main (String[] args) {
    	SpringApplication.run(FachadeMain.class, args);
    }
    
	@Override
	public void run(String... args) throws Exception {
		UnitTestRequest request = createUnitTestRequest();
		dsl.createUnitTest(request);
	}

    private static UnitTestRequest createUnitTestRequest() {
        String classPath = "C:\\TestMapper\\JAVA\\Input\\Clase_Prueba.java";
        String outputPath = "C:\\TestPrinter\\JAVA\\Output";
        String testScenarioPath = "./src/main/java/com/dsl/testrun/config/testScenarioRun.json";
        String language = "JAVA";
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader(testScenarioPath)) {
        	JSONObject configObj = (JSONObject) jsonParser.parse(reader);
            String function = (String) configObj.get("function");
            String testName = (String) configObj.get("testName");
            JSONArray parameters = (JSONArray) configObj.get("parameters");
            //JSONArray parameters = getParameters();
            JSONObject expected = getExpected();
            String assertion = (String) configObj.get("assert");
            
            return new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);    
        } catch (IOException | ParseException e) {
            System.err.println("Error reading the test scenarios config file.");
            e.printStackTrace();
        }

        return null;
    }

    private static JSONArray getParameters() {
        JSONArray parameters = new JSONArray();
        parameters.add(getParameter());
        return parameters;
    }

    private static JSONObject getParameter() {
        JSONObject parameter = new JSONObject();
        parameter.put("name", "nombre");
        parameter.put("type", "String");
        parameter.put("value", "Esteban");
        return parameter;
    }
    
    private static JSONObject getExpected() {
        JSONObject expected = new JSONObject();
        expected.put("type", "int");
        expected.put("value", "14");
        return expected;
    }
}
