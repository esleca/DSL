package processor.gastgateway;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;
import java.util.ArrayList;

public interface ICompilationUnitHandler {

    ArrayList<CompilationUnit> createCompilationUnits(String classPath) throws IOException, UnsupportedLanguageException;
}
