package com.dsl.repositories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;


@Component
public class DSLRepository implements IDSLRepository {

    @Override
    public void saveToDataStore(UnitTestRequest request, DSLModel model) throws IOException {
    	try {
        	JSONObject jsonObject = createJsonObject(request);
        	writeJson(request, jsonObject, model);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
    }
    
    @SuppressWarnings("unchecked")
    private JSONObject createJsonObject(UnitTestRequest request) {
    	JSONObject jsonObject = new JSONObject();
    	
        jsonObject.put("classPath", request.getClassPath());
        jsonObject.put("language", request.getLanguage());
        jsonObject.put("outputPath", request.getOutputPath());
        jsonObject.put("function", request.getFunction());
        jsonObject.put("testName", request.getTestName());
        jsonObject.put("parameters", request.getParameters());
        //jsonObject.put("expected", request.getExpected());
        jsonObject.put("assertion", request.getAssert());
        
        return jsonObject;
    }
    
    private void writeJson(UnitTestRequest request, JSONObject jsonObject, DSLModel model) throws IOException {
    	String pathName = createJsonPath(request, model);
    	
    	File file = new File(pathName);
    	file.getParentFile().mkdirs(); 
		file.createNewFile();
		
		FileWriter fw = new FileWriter(file);
		fw.write(jsonObject.toJSONString());
		fw.close();
		
        System.out.println("JSON file created: " + jsonObject);
    }
    
    private String createJsonPath(UnitTestRequest request, DSLModel model) {
    	var dslClass = model.getlClass();
    	String pkgName = dslClass.getPackage().getName();
    	String className = dslClass.getName();
    	
    	return "C:" + File.separator + "TestDSL" + File.separator + pkgName + File.separator + 
    			className + File.separator + request.getTestName() + ".json";
    }
}
