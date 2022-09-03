package com.dsl.repositories;

import java.io.IOException;
import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.UnitTestRequest;

public interface IDSLRepository {

	void saveToDataStore(UnitTestRequest request, DSLModel model) throws IOException;
}
