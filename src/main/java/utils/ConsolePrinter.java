package utils;

import models.entities.aggregates.Function;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.UnitTest;

import java.util.ArrayList;

public class ConsolePrinter implements IPrinter {

    /**
     * Print a menu to run DSL from console
     */
    public void printMenu(){
        System.out.println("\n\n----------------------- DSL TESTER -----------------------\n");

        System.out.println("1) Leer codigo fuente del disco");
        System.out.println("2) Ingresar escenarios de prueba");
        System.out.println("");

        System.out.println("----------------------- DSL TESTER -----------------------");
    }


    /**
     * Public function called from gestor in order to print unit test
     * Implementation from the IPrinter interface
     *
     * @param ut
     */
    public void printUnitTest(UnitTest ut){
        printTestHeader(ut);
        printArrange(ut);
        printAct(ut);
        printAssert(ut);
    }


    /**
     *
     * @param ut
     */
    private void printTestHeader(UnitTest ut){
        Function function = ut.getTestScenario().getTestableUnit().getFunction();
        String testName = ut.getTestScenario().getTestName();

        System.out.println("Function: " + function.getName());

        System.out.println("Test Name: " + testName);
    }


    /**
     * Print the Arrange section of the unit test
     *
     * @param ut
     */
    private void printArrange(UnitTest ut){
        System.out.println("\n//Arrange");

        ArrayList<ArrangeStatement> arrangeStatements = ut.getArrange().getArrangeStatements();

        for (ArrangeStatement as : arrangeStatements){
            System.out.println(as.getDeclaration().getType() + " " +
                    as.getDeclaration().getName() + " = " +
                    as.getDefinition().getValueType().getValue() + ";");
        }
    }


    /**
     * Print the Act section of the unit test
     *
     * @param ut
     */
    private void printAct(UnitTest ut){
        Function function = ut.getTestScenario().getTestableUnit().getFunction();
        String fClass = function.getFileClass().getName();
        String fReturn = function.getReturn().getName();
        ArrayList<ArrangeStatement> arrangeStatements = ut.getArrange().getArrangeStatements();
        String sutParams = getFunctionParameters(arrangeStatements);

        System.out.println("\n//Act");

        if (function.isStatic()){
            System.out.println(fReturn + " result = " + fClass+ "." + function.getName() + "(" + sutParams + ");");
        } else {
            System.out.println(fClass + " sut = new " + fClass + "();");
            System.out.println(fReturn + " result = sut." + function.getName() + "(" + sutParams + ");");
        }

        System.out.println(fReturn + " expected = " + ut.getTestScenario().getExpectedResult().getValueType().getValue() + ";");
    }


    /**
     * Print the Assert section of the unit test
     *
     * @param ut
     */
    private void printAssert(UnitTest ut){
        System.out.println("\n//Assert");

        System.out.println("Assert.AreEqual(expected, result);");

        System.out.println("\n######################################");
    }


    /**
     * Get a string with the parametes and commas
     *
     * @param arrangeStatements
     * @return a string with the parameters and commas
     * Example (param1, param2, param3)
     */
    private String getFunctionParameters(ArrayList<ArrangeStatement> arrangeStatements){
        String resultStr = "";

        for (ArrangeStatement as : arrangeStatements){
            resultStr += as.getDeclaration().getName() + ", ";
        }

        if (resultStr != ""){
            resultStr = resultStr.substring(0, resultStr.length()-2);
        }

        return resultStr;
    }
}
