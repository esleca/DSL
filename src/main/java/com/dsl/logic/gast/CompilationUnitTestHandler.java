package com.dsl.logic.gast;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

import com.dsl.fachade.models.DSLModel;
import com.dsl.factories.GastFactory;
import com.dsl.logic.imports.IImportsHandler;
import com.dsl.logic.packages.IPackagesHandler;
import com.dsl.logic.programscopes.IProgramScopeHandler;

import java.util.ArrayList;
import org.springframework.stereotype.Component;


@Component
public class CompilationUnitTestHandler implements ICompilationUnitTestHandler {

	private IPackagesHandler packagesHandler;
	private IImportsHandler importsHandler;
	private IProgramScopeHandler programScopeHandler; 
	
	public CompilationUnitTestHandler(IPackagesHandler packagesHandler, IImportsHandler importsHandler, IProgramScopeHandler programScopeHandler) {
		this.packagesHandler = packagesHandler;
		this.importsHandler = importsHandler;
		this.programScopeHandler = programScopeHandler;
	}
	
	
    @Override
    public ArrayList<CompilationUnit> processCompilationUnitTests(DSLModel model, String language) throws UnsupportedLanguageException {
        ArrayList<CompilationUnit> compilationUnitTests = new ArrayList<>();
        CompilationUnit compilationUnit = GastFactory.createCompilationUnit(language);

        packagesHandler.processCompilationUnitPackage(compilationUnit, model);
        importsHandler.processCompilationUnitImports(compilationUnit, language);
        programScopeHandler.processCompilationUnitScope(compilationUnit, model);

        compilationUnitTests.add(compilationUnit);
        return compilationUnitTests;
    }
}
