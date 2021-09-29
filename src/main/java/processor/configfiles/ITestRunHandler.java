package processor.configfiles;

import gastmappers.exceptions.UnsupportedLanguageException;
import testrun.config.ConfigurationTestRun;

import java.util.ArrayList;

public interface ITestRunHandler {

    ArrayList<ConfigurationTestRun> processConfigurationFiles(String configPath)throws UnsupportedLanguageException;

}
