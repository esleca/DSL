package com.dsl.services.compunits;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.gast.ICompilationUnitTestHandler;
import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class CompUnitsTestService implements ICompUnitsTestService {
	
	private ICompilationUnitTestHandler _compUnitTestHandler;
	
	public CompUnitsTestService(ICompilationUnitTestHandler handler) {
		this._compUnitTestHandler = handler;
	}
	
	@Override
	public void processCompilationUnitsTests(DSLModel model) throws UnsupportedLanguageException {
		ArrayList<String> outputLanguages = model.getOutputLanguages();
    	
    	for(String language : outputLanguages) {
			ArrayList<CompilationUnit> compilationUnitTests = _compUnitTestHandler.processCompilationUnitTests(model, language);
			model.addCompilationUnitsTests(compilationUnitTests);
    	}
	}
}
