package com.dsl.services.persistance;

import java.io.IOException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;

public interface IRepoService {
	
	void saveToDataStore(UnitTestRequest request, DSLModel model) throws IOException;
}
