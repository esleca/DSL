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
     * @param filePath
     * @return
     * @throws IOException
     * @throws UnsupportedLanguageException
     */
    @Override
    public ArrayList<CompilationUnit> createCompilationUnits(String filePath) throws IOException, UnsupportedLanguageException {
        ArrayList<CompilationUnit> compilationUnits = new ArrayList<>();

        if (FilenameUtils.getExtension(filePath).equals(Language.getFileExtension(language))) {
            compilationUnits = mapper.getGastCompilationUnit(filePath);
        }

        return compilationUnits;
    }

}
