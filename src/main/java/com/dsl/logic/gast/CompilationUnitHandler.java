package com.dsl.logic.gast;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.Language;
import gastmappers.Mapper;
import gastmappers.MapperFactory;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;


@Component
public class CompilationUnitHandler implements ICompilationUnitHandler {

    private Language language;
    private Mapper mapper;

    
    @Override
    public void setLanguage(String language) throws UnsupportedLanguageException {
        MapperFactory factory = new MapperFactory();
        Language sourceLanguage = Language.getLanguageFromString(language);

        this.language = sourceLanguage;
        this.mapper = factory.createMapper(sourceLanguage);
    }

    
    @Override
    public ArrayList<CompilationUnit> createCompilationUnits(String classPath) throws IOException, UnsupportedLanguageException {
    	ArrayList<CompilationUnit> compilationUnits = new ArrayList<>();
    	if (FilenameUtils.getExtension(classPath).equals(Language.getFileExtension(language))) {
        	compilationUnits = mapper.getGastCompilationUnit(classPath);
        }
        return compilationUnits;
    }
}
