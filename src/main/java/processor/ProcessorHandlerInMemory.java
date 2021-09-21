package processor;

import ASTMCore.ASTMSource.CompilationUnit;
import com.google.gson.Gson;
import gastmappers.Language;
import gastmappers.Mapper;
import gastmappers.exceptions.UnsupportedLanguageException;
import org.apache.commons.io.FilenameUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static gastmappers.misc.Misc.writeInFile;


public class ProcessorHandlerInMemory implements IProcessorHandlerInMemory {

    private final String inputPath;
    private final String translationFilePath;
    private final String differencesFilePath;
    private final ArrayList<String> parsedFileList;
    private final Language language;
    private final Mapper mapper;
    private final boolean validate;


    /**
     * Builder method with all of the instance variables.
     *
     * @param inputPath  Input directory to take the files to transform.
     * @param outputPath Output directory to store the JSON representation of the GAST.
     * @param language   The language to be mapped.
     * @param mapper     The corresponding mapper for the language.
     * @param validate   True if is necessary to validate the map process (run the Validator).
     * @throws IOException Error manipulating a file.
     */
    public ProcessorHandlerInMemory(String inputPath, String outputPath, Language language, Mapper mapper, boolean validate, boolean semantic)
            throws IOException {
        this.inputPath = inputPath;
        this.translationFilePath = outputPath + "\\result.json";
        this.differencesFilePath = outputPath + "\\summaryDifferences.txt";
        this.language = language;
        this.mapper = mapper;
        this.validate = validate;
        this.parsedFileList = new ArrayList<>();
    }


    /**
     * This method handles the transformation process, based on a inputPath, it obtains all the files to be mapped
     * (according to the Language), then, it reads the source code in every file and starts the map process using a
     * MapperFactory to obtain the corresponding Mapper, the Mapper return the GAST representation of the source code.
     * The GAST representation is turned into a JSON representation to be stored in a file.
     *
     * @throws IOException              Error manipulating a file.
     * @throws IllegalArgumentException If a method is invoked with distinct arguments from the ones it receives.
     * @throws SecurityException        If there is an attempt to access a protected value.
     * @see Language
     * @see gastmappers.MapperFactory
     * @see Mapper
     */
    public ArrayList<CompilationUnit> processFilesInDir(boolean writeInDisk)
            throws IOException, IllegalArgumentException, SecurityException, UnsupportedLanguageException {

        ArrayList<CompilationUnit> compilationUnits = new ArrayList<>();
        File dirs = new File(this.inputPath);
        File root = new File(dirs.getCanonicalPath() + File.separator);
        File[] files = root.listFiles();

        if (files != null) {
            for (File f : files) {

                String filePath = f.getAbsolutePath();
                if (f.isFile()) {
                    if (FilenameUtils.getExtension(filePath).equals(Language.getFileExtension(this.language))) {

                        compilationUnits = mapper.getGastCompilationUnit(filePath);

                        for (CompilationUnit compilationUnit : compilationUnits) {

                            Gson gson = new Gson();
                            String jsonRepresentation = gson.toJson(compilationUnit);
                            jsonRepresentation = jsonRepresentation.replaceAll("null", "");
                            parsedFileList.add(jsonRepresentation);
                        }

                    }
                } else if (f.isDirectory()) {
                    processFilesInDir(writeInDisk);
                }
            }
        }

        if (writeInDisk){
            WriteTranslation();
        }

        return compilationUnits;
    }


    /**
     * This method takes the JSON representations of the obtained GAST during the process and converts these
     * representations into a String, to be written in a file.
     *
     * @throws IOException       Error manipulating a file.
     * @throws HeadlessException Errors on graphic ambient.
     */
    protected void WriteTranslation() throws IOException, HeadlessException {
        String translation = parsedFileList.toString();
        writeInFile(translation, this.translationFilePath, false);
    }

}
