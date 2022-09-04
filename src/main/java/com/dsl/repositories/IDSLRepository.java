package com.dsl.repositories;

import java.io.IOException;
import com.dsl.models.dtos.UnitTestRequest;

public interface IDSLRepository {

	void saveToDataStore(UnitTestRequest request, String jsonPath) throws IOException;
}
