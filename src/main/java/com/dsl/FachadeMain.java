package com.dsl;

import java.io.FileReader;
import java.io.IOException;

import com.dsl.fachade.IDSLCrudFachade;
import com.dsl.models.dtos.UnitTestRequest;
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
            //ValueType expected = getExpected();
            ValueType expected = (ValueType) configObj.get("expected");
            String assertion = (String) configObj.get("assertion");
            
            return new UnitTestRequest(classPath, outputPath, language, function, testName, parameters, expected, assertion);    
        } catch (IOException | ParseException e) {
            System.err.println("Error reading the test scenarios config file.");
            e.printStackTrace();
        }

        return null;
    }
}
