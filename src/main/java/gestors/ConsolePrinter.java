package gestors;

import models.entities.aggregates.Function;
import models.entities.unittests.ArrangeStatement;
import models.entities.unittests.UnitTest;

import java.util.ArrayList;

public class ConsolePrinter {

    public void printMenu(){
        System.out.println("\n\n----------------------- DSL TESTER -----------------------\n");

        System.out.println("1) Leer codigo fuente del disco");
        System.out.println("2) Ingresar escenarios de prueba");
        System.out.println("");

        System.out.println("----------------------- DSL TESTER -----------------------");
    }

    public void printUnitTest(UnitTest ut){

        Function function = ut.getTestScenario().getTestableUnit().getFunction();
        String fClass = function.getFileClass().getName();
        String fReturn = function.getReturn().getName();
        ArrayList<ArrangeStatement> arrangeStatements = ut.getArrange().getArrangeStatements();
        String sutParams = getFunctionParameters(arrangeStatements);

        System.out.println("Function: " + function.getName());

        System.out.println("\n//Arrange");


        for (ArrangeStatement as : arrangeStatements){

            System.out.println(as.getDeclaration().getType() + " " +
                                as.getDeclaration().getName() + " = " +
                                as.getDefinition().getValueType().getValue() + ";");
        }

        System.out.println("\n//Act");

        if (function.isStatic()){

            System.out.println(fReturn + " result = " + fClass+ "." + function.getName() + "(" + sutParams + ");");

        } else {

            System.out.println(fClass + " sut = new " + fClass + "();");
            System.out.println(fReturn + " result = sut." + function.getName() + "(" + sutParams + ");");

        }

        System.out.println(fReturn + " expected = " + ut.getTestScenario().getExpectedResult().getValueType().getValue() + ";");


        System.out.println("\n//Assert");

        System.out.println("Assert.AreEqual(expected, result);");

        System.out.println("\n######################################");
    }


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
