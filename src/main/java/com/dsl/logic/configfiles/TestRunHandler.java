package com.dsl.logic.configfiles;

import gastmappers.exceptions.UnsupportedLanguageException;
import com.dsl.testrun.config.ConfigurationTestRun;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestRunHandler implements ITestRunHandler {

    /**
     *
     * @param configPath
     * @return
     * @throws UnsupportedLanguageException
     */
    @Override
    public ArrayList<ConfigurationTestRun> processConfigFiles(String configPath) throws UnsupportedLanguageException {
        ArrayList<ConfigurationTestRun> results = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(configPath)) {
            JSONArray configurationsArray = (JSONArray) jsonParser.parse(reader);

            for (Object configurationRawObject : configurationsArray) {
                JSONObject configurationObject = (JSONObject) configurationRawObject;
                results.add(getConfigurationTestRun(configurationObject));
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading the configuration file.");
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Receive a json object and read properties to
     * set up the configuration object
     *
     * @param configurationObject
     * @return ConfigurationTestRun object
     * @throws UnsupportedLanguageException
     */
    private ConfigurationTestRun getConfigurationTestRun(JSONObject configurationObject) throws UnsupportedLanguageException {
        String inputDirectory = (String) configurationObject.get("inputDirectory");
        String outputDirectory = (String) configurationObject.get("outputDirectory");
        String outputCodeDirectory = (String) configurationObject.get("outputCodeDirectory");
        String sourceLanguage = (String) configurationObject.get("sourceLanguage");
        ArrayList<String> outputLanguages = (ArrayList<String>) configurationObject.get("outputLanguages");
        boolean validateMap = (boolean) configurationObject.get("validateMap");
        boolean semantic = (boolean) configurationObject.get("semantic");

        return new ConfigurationTestRun(inputDirectory, outputDirectory, outputCodeDirectory, sourceLanguage, outputLanguages, validateMap, semantic);
    }
}
