package com.dsl.logic.configfiles;

import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.testrun.config.ConfigurationTestRun;
import java.util.ArrayList;

public interface ITestRunHandler {

    ArrayList<ConfigurationTestRun> processConfigFiles(String configPath)throws UnsupportedLanguageException;

}
