package testrun;

import exceptions.*;
import fachade.*;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.dtos.UnitTestRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;


public class FachadeMain {

    private final static IDSLFachade dsl = new DSLFachade();

    public static void main(String[] args) throws IOException, UnsupportedLanguageException, ValueTypeNotFoundException, AssertNotFoundException {
        UnitTestRequest request = createUnitTestRequest();
        dsl.createUnitTest(request);
    }

    private static UnitTestRequest createUnitTestRequest() {
        String classPath = "C:\\TestMapper\\JAVA\\Input\\Clase_Prueba.java";
        String language = "JAVA";
        String function = "saludar";
        String testName = "test_saludar_valid";
        JSONArray parameters = getParameters();
        String expected = "Hola Esteban";
        String assertion = "areEqual";
        return new UnitTestRequest(classPath, language, function, testName, parameters, expected, assertion);
    }

    private static JSONArray getParameters() {
        JSONArray parameters = new JSONArray();
        parameters.add(getParameter());
        return parameters;
    }

    private static JSONObject getParameter() {
        JSONObject parameter = new JSONObject();
        parameter.put("name", "nombre");
        parameter.put("type", "String");
        parameter.put("value", "Esteban");
        return parameter;
    }
}
