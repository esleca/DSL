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

	private ArrayList<String> _folderFiles = new ArrayList<String>();
	
	
	@Override
	public List<UnitTestMetaData> getFunctionUnitTests(FunctionTestsRequest request) throws ValueTypeNotFoundException {
		List<UnitTestMetaData> results = new ArrayList<UnitTestMetaData>();;
		
		try {
			String jsonsPath = TESTS_JSONS_PATH + File.separator + request.getPackageName() + 
								File.separator + request.getClassName();

			results = getUnitTestsMetaData(jsonsPath);
			results = filterFunctionMetaData(results, request.getFunctionName());
	    } catch (IOException | ValueTypeNotFoundException e) {
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
		} catch (IOException | ValueTypeNotFoundException e) {
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
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
		return results;
	}
	
	
	private List<UnitTestMetaData> getUnitTestsMetaData(String jsonsPath) throws ValueTypeNotFoundException, IOException {
		List<UnitTestMetaData> results = new ArrayList<UnitTestMetaData>();

		_folderFiles = new ArrayList<String>();
		final File folder = new File(jsonsPath);
		ArrayList<String> folderFiles = listFolderFiles(folder);
		
		for (String utPath : folderFiles) {
			try (FileReader reader = new FileReader(utPath)) {
	            UnitTestMetaData metaData = getTestMetaData(reader);
	            results.add(metaData);
			} catch (IOException | ParseException e) {
	            System.err.println("Error reading the unit test metadata file.");
	            e.printStackTrace();
	        }
		}
		
		return results;
	}
	
	private ArrayList<String> listFolderFiles(final File folder) throws IOException{
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	listFolderFiles(fileEntry);
	        } else {
	        	_folderFiles.add(fileEntry.getPath());
	            System.out.println("Json File found: " + fileEntry.getPath());
	        }
	    }
	    return _folderFiles;
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
        
        ValueType expected = null;
        JSONObject expectedObj = (JSONObject) configObj.get("expected");
        if(expectedObj != null) {
			String type = (String) expectedObj.get("type");
        	Object value = expectedObj.get("value");
            expected = ValueTypeFactory.createValueType(type, value);
        }

        return UnitTestMetaDataFactory.createUnitTestMetaData(classPath, outputPath, language, function, testName, parameters, expected, assertion);
	}
	
	private List<UnitTestMetaData> filterFunctionMetaData(List<UnitTestMetaData> result, String function){
		List<UnitTestMetaData> results = new ArrayList<UnitTestMetaData>();
		
		for (UnitTestMetaData metaData : result) {
			if (metaData.getFunction().startsWith(function)) {
				results.add(metaData);
			}
		}
		return results;
	}
}
