package com.dsl.repositories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import com.dsl.models.dtos.UnitTestRequest;

@Component
public class DSLRepository implements IDSLRepository {

    @Override
    public void saveToDataStore(UnitTestRequest request, String jsonPath) throws IOException {
    	try {
        	JSONObject jsonObject = createJsonObject(request);
        	writeJson(jsonObject, jsonPath);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
    }
    
    @SuppressWarnings("unchecked")
    private JSONObject createJsonObject(UnitTestRequest request) {
    	JSONObject jsonObject = new JSONObject();
    	
        jsonObject.put("classPath", request.getClassPath());
        jsonObject.put("outputPath", request.getOutputPath());
        jsonObject.put("language", request.getLanguage());
        jsonObject.put("function", request.getFunction());
        jsonObject.put("testName", request.getTestName());
        jsonObject.put("assertion", request.getAssert());
        jsonObject.put("parameters", request.getParameters());
        
        var expected = request.getExpected();

        if (expected != null) {
        	JSONObject expectedJsonObj = new JSONObject();

        	expectedJsonObj.put("value", expected.getValue());
        	expectedJsonObj.put("type", expected.getType());
        	
        	jsonObject.put("expected", expectedJsonObj);
        }
        
        return jsonObject;
    }
    
    private void writeJson(JSONObject jsonObject, String jsonPath) throws IOException {
    	File file = new File(jsonPath);
    	file.getParentFile().mkdirs(); 
		file.createNewFile();
		
		FileWriter fw = new FileWriter(file);
		fw.write(jsonObject.toJSONString());
		fw.close();
		
        System.out.println("\nJSON file created: " + jsonObject);
    }
}
