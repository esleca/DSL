package processor;

import gastmappers.exceptions.UnsupportedLanguageException;
import testrun.config.ConfigurationTestRun;

import java.util.ArrayList;

public interface IProcessorHandlerRunner {

    ArrayList<ConfigurationTestRun> processConfigurationFiles(String configPath)throws UnsupportedLanguageException;

}
