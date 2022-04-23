package com.dsl;

import com.dsl.fachade.IDSLFachade;
import com.dsl.models.dtos.UnitTestRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
		dsl.createUnitTest(request);
	}

    private static UnitTestRequest createUnitTestRequest() {
        String classPath = "C:\\TestMapper\\JAVA\\Input\\Clase_Prueba.java";
        String language = "JAVA";
        String function = "saludar";
        String testName = "test_saludar_valid";
        JSONArray parameters = getParameters();
        String expected = "Hola Esteban";
        String assertion = "areEqual";
        return new UnitTestRequest(classPath, language, function, testName, parameters, expected, assertion);
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
}
