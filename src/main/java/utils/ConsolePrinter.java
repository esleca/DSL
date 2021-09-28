package utils;

import models.entities.aggregates.Function;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.UnitTest;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.unittests.asserts.AssertParameter;
import models.entities.unittests.asserts.types.AssertType;
import models.entities.unittests.asserts.types.AssertTypePair;

import java.util.ArrayList;

public class ConsolePrinter implements IPrinter {

    public void printMenu(){
        System.out.println("\n\n----------------------- DSL TESTER -----------------------\n");

        System.out.println("1) Leer codigo fuente del disco");
        System.out.println("2) Ingresar escenarios de prueba");
        System.out.println("");

        System.out.println("----------------------- DSL TESTER -----------------------");
    }

    public void printUnitTest(UnitTest ut){
        printTestHeader(ut);
        printArrange(ut);
        printAct(ut);
        printAssert(ut);
    }

    private void printTestHeader(UnitTest ut){
        Function function = ut.getTestScenario().getTestableUnit().getFunction();
        String testName = ut.getTestScenario().getTestName();

        System.out.println("Function: " + function.getName());

        System.out.println("Test Name: " + testName);
    }

    private void printArrange(UnitTest ut){
        System.out.println("\n//Arrange");

        ArrayList<ArrangeStatement> arrangeStatements = ut.getArrange().getArrangeStatements();

        for (ArrangeStatement as : arrangeStatements){
            System.out.println(as.getDeclaration().getType() + " " +
                    as.getDeclaration().getName() + " = " +
                    as.getDefinition().getValueType().getValue() + ";");
        }
    }

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

        AssertType assertType = ut.getAssert().getAssertExpressions().get(0).getAssertType();
        if (isAssertTypePair(assertType)){
            System.out.println(fReturn + " expected = " + ut.getTestScenario().getExpectedResult().getValueType().getValue() + ";");
        }
    }

    private boolean isAssertTypePair(AssertType assertType){
        if (assertType instanceof AssertTypePair){
            return true;
        }
        return false;
    }

    private void printAssert(UnitTest ut){
        System.out.println("\n//Assert");

        ArrayList<AssertExpression> expressions = ut.getAssert().getAssertExpressions();

        for (AssertExpression ae : expressions){
            String assertParams = getAssertParameters(expressions);

            System.out.println(ae.getCalledFunction() + "." +
                    ae.getAssertType().getName() + "(" + assertParams + ");");
        }

        System.out.println("\n######################################");
    }

    private String getFunctionParameters(ArrayList<ArrangeStatement> arrangeStatements){
        String resultStr = "";

        for (ArrangeStatement as : arrangeStatements){
            resultStr += as.getDeclaration().getName() + ", ";
        }

        resultStr = cutFinalCommas(resultStr);

        return resultStr;
    }

    private String getAssertParameters(ArrayList<AssertExpression> expressions){
        String resultStr = "";

        for (AssertExpression ae : expressions){
            ArrayList<AssertParameter> assertParameters = ae.getAssertParameters();
            for (AssertParameter ap : assertParameters){
                resultStr += ap.getValue() + ", ";
            }
        }

        resultStr = cutFinalCommas(resultStr);

        return resultStr;
    }

    private String cutFinalCommas(String resultStr){
        if (resultStr != ""){
            resultStr = resultStr.substring(0, resultStr.length()-2);
        }
        return resultStr;
    }

}
