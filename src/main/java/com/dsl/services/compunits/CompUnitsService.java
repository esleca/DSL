package com.dsl.services.compunits;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.dsl.fachade.models.DSLModel;
import com.dsl.logic.gast.ICompilationUnitHandler;
import com.dsl.models.dtos.UnitTestRequest;
import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;


@Component
public class CompUnitsService implements ICompUnitsService {
	
	private ICompilationUnitHandler _compUnitHandler;
	
	public CompUnitsService(ICompilationUnitHandler compUnitHandler) {
		this._compUnitHandler = compUnitHandler;
	}
	
	
	@Override
	public void createCompilationUnits(UnitTestRequest unitTestRequest, DSLModel model) throws IOException, UnsupportedLanguageException {	
		_compUnitHandler.setLanguage(unitTestRequest.getLanguage());
        ArrayList<CompilationUnit> compUnits = _compUnitHandler.createCompilationUnits(unitTestRequest.getClassPath());
        model.setCompilationUnits(compUnits);
	}
}
