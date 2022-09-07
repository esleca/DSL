package com.dsl.services.visitor;

import com.dsl.fachade.models.DSLModel;

public interface IVisitorService {
	
	void visitCompilationUnits(DSLModel model);
}
