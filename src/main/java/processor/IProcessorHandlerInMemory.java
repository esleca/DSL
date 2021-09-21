package processor;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.exceptions.UnsupportedLanguageException;

import java.io.IOException;
import java.util.ArrayList;

public interface IProcessorHandlerInMemory {

    ArrayList<CompilationUnit> processFilesInDir(boolean writeInDisk)
            throws IOException, IllegalArgumentException, SecurityException, UnsupportedLanguageException;
}
