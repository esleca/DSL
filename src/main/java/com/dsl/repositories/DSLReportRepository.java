package com.dsl.repositories;

import static com.dsl.utils.Constants.TESTS_JSONS_PATH;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.factories.UnitTestMetaDataFactory;
import com.dsl.factories.ValueTypeFactory;
import com.dsl.models.database.UnitTestMetaData;
import com.dsl.models.dtos.ClassTestsRequest;
import com.dsl.models.dtos.FunctionTestsRequest;
import com.dsl.models.dtos.PackageTestsRequest;
import com.dsl.models.valuetypes.ValueType;


@Component
public class DSLReportRepository implements IDSLReportRepository {

	@Override
	public List<UnitTestMetaData> getFunctionUnitTests(FunctionTestsRequest request) throws ValueTypeNotFoundException {
		List<UnitTestMetaData> results = null;
		
		try {
			String jsonsPath = TESTS_JSONS_PATH + File.separator + request.getPackageName() + 
								File.separator + request.getClassName(); // + reqFunction.getSuffix() 
			
			results = getUnitTestsMetaData(jsonsPath);
	    } catch (ValueTypeNotFoundException e) {
	    	e.printStackTrace();
	    }
		return results;
	}
	
	@Override
	public List<UnitTestMetaData> getClassUnitTests(ClassTestsRequest request) throws ValueTypeNotFoundException {
		List<UnitTestMetaData> results = null;
		
		try {
			String jsonsPath = TESTS_JSONS_PATH + File.separator + request.getPackageName() +
								File.separator + request.getClassName();
			
			results = getUnitTestsMetaData(jsonsPath);	
		} catch (ValueTypeNotFoundException e) {
	    	e.printStackTrace();
	    }
		return results;
	}

	@Override
	public List<UnitTestMetaData> getPackageUnitTests(PackageTestsRequest request) throws ValueTypeNotFoundException {
		List<UnitTestMetaData> results = null;
		
		try {
			String jsonsPath = TESTS_JSONS_PATH + File.separator + request.getPackageName();
			
			results = getUnitTestsMetaData(jsonsPath);
		} catch (ValueTypeNotFoundException e) {
	    	e.printStackTrace();
	    }
		return results;
	}
	
	
	private List<UnitTestMetaData> getUnitTestsMetaData(String jsonsPath) throws ValueTypeNotFoundException {
		List<UnitTestMetaData> results = new ArrayList<UnitTestMetaData>();

		final File folder = new File(jsonsPath);
		ArrayList<String> folderFiles = listFolderFiles(folder);
		
		for (String utPath : folderFiles) {
			try (FileReader reader = new FileReader(jsonsPath + File.separator + utPath)) 
			{
	            UnitTestMetaData metaData = getTestMetaData(reader);
	            results.add(metaData);
			} catch (IOException | ParseException e) {
	            System.err.println("Error reading the unit test metadata file.");
	            e.printStackTrace();
	        }
		}
		
		return results;
	}
	
	private ArrayList<String> listFolderFiles(final File folder) {
		ArrayList<String> folderFiles = new ArrayList<String>();
		
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	listFolderFiles(fileEntry);
	        } else {
	        	folderFiles.add(fileEntry.getName());
	            System.out.println("JSON File Name: " + fileEntry.getName());
	        }
	    }
	    return folderFiles;
	}
	
	private UnitTestMetaData getTestMetaData(FileReader reader) throws IOException, ParseException, ValueTypeNotFoundException {
		JSONParser jsonParser = new JSONParser();
    	JSONObject configObj = (JSONObject) jsonParser.parse(reader);
    	
    	String classPath = (String) configObj.get("classPath");
    	String outputPath = (String) configObj.get("outputPath");
    	String language = (String) configObj.get("language");
    	String function = (String) configObj.get("function");
        String testName = (String) configObj.get("testName");
        String assertion = (String) configObj.get("assertion");
        JSONArray parameters = (JSONArray) configObj.get("parameters");
//        JSONObject expectedObj = (JSONObject) configObj.get("expected");
//        String value = (String) expectedObj.get("value");
//    	String type = (String) expectedObj.get("type");
//        ValueType expected = ValueTypeFactory.createValueType(type, value);
        
        return UnitTestMetaDataFactory.createUnitTestMetaData(classPath, outputPath, language, function, testName, parameters, null, assertion);
	}
}
