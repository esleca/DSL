package com.dsl.services.persistance;

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
		repository.saveToDataStore(request, model);
	}
}
