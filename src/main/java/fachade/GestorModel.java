package fachade;

import testrun.config.ConfigurationTestRun;
import java.util.ArrayList;

public class GestorModel extends DSLModel {

    private final boolean writeToDisk;
    private final String configurationPath;
    private final String testScenariosPath;

    private ArrayList<ConfigurationTestRun> configurationsRunFiles;

    public GestorModel(){
        super();

        writeToDisk = true;
        configurationsRunFiles = new ArrayList<>();
        configurationPath = "./src/main/java/testrun/config/configurationTestRun.json";
        testScenariosPath = "./src/main/java/testrun/config/testScenariosRun.json";
    }

    public boolean isWriteToDisk() {
        return writeToDisk;
    }

    public String getConfigurationPath() {
        return configurationPath;
    }

    public String getTestScenariosPath() {
        return testScenariosPath;
    }

    public ArrayList<ConfigurationTestRun> getConfigurationsRunFiles() {
        return configurationsRunFiles;
    }

    public void setConfigurationsRunFiles(ArrayList<ConfigurationTestRun> configurationsRunFiles){
        this.configurationsRunFiles = configurationsRunFiles;
    }

}
