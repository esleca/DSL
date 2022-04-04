package testrun;

import exceptions.AssertNotFoundException;
import exceptions.ValueTypeNotFoundException;
import fachade.DSLFachade;
import fachade.IDSLFachade;
import gastmappers.exceptions.UnsupportedLanguageException;
import models.dtos.TestScenarioRequest;
import models.dtos.UnitTestRequest;
import utils.ConsolePrinter;
import utils.IPrinter;

import java.io.IOException;


public class FachadeMain {

    private static IPrinter printer = new ConsolePrinter();
    private final static IDSLFachade dsl = new DSLFachade(printer);

    public static void main(String[] args) throws IOException, UnsupportedLanguageException,
            ValueTypeNotFoundException, AssertNotFoundException {

        String path = "C:\\TestMapper\\JAVA\\Input\\Clase_Prueba.java";
        String language = "JAVA";
        String function = "function";
        TestScenarioRequest testScenario = new TestScenarioRequest();
        UnitTestRequest unitTestRequest = new UnitTestRequest(path, language, testScenario);

        dsl.createUnitTest(unitTestRequest);
    }

}
