package processor.gastgateway;

import ASTMCore.ASTMSource.CompilationUnit;
import gastmappers.Language;
import gastmappers.Mapper;
import gastmappers.MapperFactory;
import gastmappers.exceptions.UnsupportedLanguageException;
import org.apache.commons.io.FilenameUtils;
import java.io.IOException;
import java.util.ArrayList;

public class CompilationUnitHandler implements ICompilationUnitHandler {

    private final Language language;
    private final Mapper mapper;

    public CompilationUnitHandler(String language) throws UnsupportedLanguageException {
        MapperFactory factory = new MapperFactory();
        Language sourceLanguage = Language.getLanguageFromString(language);

        this.language = sourceLanguage;
        this.mapper = factory.createMapper(sourceLanguage);
    }

    /**
     * Create the compilation unit structure based
     * on the input path
     *
     * @param classPath
     * @return
     * @throws IOException
     * @throws UnsupportedLanguageException
     */
    @Override
    public ArrayList<CompilationUnit> createCompilationUnits(String classPath) throws IOException, UnsupportedLanguageException {
        ArrayList<CompilationUnit> compilationUnits = new ArrayList<>();

        if (FilenameUtils.getExtension(classPath).equals(Language.getFileExtension(language))) {
            compilationUnits = mapper.getGastCompilationUnit(classPath);
        }

        return compilationUnits;
    }

}
