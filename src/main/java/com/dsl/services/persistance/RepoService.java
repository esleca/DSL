package com.dsl.services.persistance;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Component;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;
import com.dsl.repositories.IDSLRepository;

@Component
public class RepoService implements IRepoService {

	private IDSLRepository repository;
	
	public RepoService(IDSLRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void saveToDataStore(UnitTestRequest request, DSLModel model) throws IOException {
		String jsonPath = createJsonPath(request, model);
		repository.saveToDataStore(request, jsonPath);
	}
    
    private String createJsonPath(UnitTestRequest request, DSLModel model) {
    	var dslClass = model.getlClass();
    	String pkgName = dslClass.getPackage().getName();
    	String className = dslClass.getName();
    	
    	return "C:" + File.separator + "TestDSL" + File.separator + pkgName + File.separator + 
    			className + File.separator + request.getTestName() + ".json";
    }
}
