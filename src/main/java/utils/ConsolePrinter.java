package utils;

import models.entities.aggregates.Function;
import models.entities.unittests.*;
import models.entities.unittests.acts.*;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.unittests.asserts.types.AssertType;
import models.entities.unittests.asserts.types.AssertTypePair;

import java.util.ArrayList;

public class ConsolePrinter implements IPrinter {

    public void printUnitTest(UnitTest ut){
        printTestHeader(ut);
        printArrange(ut);
        printAct(ut);
        printAssert(ut);
        printTestEnd();
    }

    private void printTestHeader(UnitTest ut){
        Function function = ut.getTestScenario().getTestableUnit().getFunction();
        String testName = ut.getTestScenario().getTestName();

        System.out.println("\n//FUNCTION: " + function.getName());

        System.out.println("[TestMethod]");

        System.out.println("public void " + testName + "(){");
    }

    private void printTestEnd(){
        System.out.println("}");

        System.out.println("\n############################################");
    }

    private void printArrange(UnitTest ut){
        System.out.println("\t//Arrange");

        ArrayList<ArrangeStatement> arrangeStatements = ut.getArrange().getArrangeStatements();

        for (ArrangeStatement as : arrangeStatements){
            Declaration declaration = as.getDeclaration();

            System.out.println("\t" + declaration.getType() + " " + declaration.getName() + " = " +
                    as.getDefinition().getValueType().getValue() + ";");
        }

        AssertType assertType = ut.getAssert().getAssertExpressions().get(0).getAssertType();
        if (isAssertTypePair(assertType)){
            Function function = ut.getTestScenario().getTestableUnit().getFunction();

            String fReturn = function.getReturn().getName();

            ExpectedResult expectedResult = ut.getTestScenario().getExpectedResult();

            System.out.println("\t" + fReturn + " expected = " + expectedResult.getValueType().getValue() + ";");
        }
    }

    private boolean isAssertTypePair(AssertType assertType){
        if (assertType instanceof AssertTypePair){
            return true;
        }
        return false;
    }

    private void printAct(UnitTest ut){
        Function function = ut.getTestScenario().getTestableUnit().getFunction();

        System.out.println("\n\t//Act");

        ActExecution actExecution = ut.getAct().getActExecution();

        Declaration declaration = actExecution.getDeclaration();

        ArrayList<ArrangeStatement> arrangeStatements = ut.getArrange().getArrangeStatements();

        String sutParams = getFunctionArgs(arrangeStatements);

        if (function.isStatic()){

            System.out.println("\t" + declaration.getType() + " " + declaration.getName() +" = " +
                    actExecution.getCalledFunction() + "." + actExecution.getFunctionName() + "(" + sutParams + ");");
        } else{

            IInstanceActioner instanceActioner = (IInstanceActioner) ut.getAct();
            ActNewType actNewType = instanceActioner.getActNewType();

            System.out.println("\t" + actNewType.getType() + " " + actNewType.getName() + " = new " +
                    actNewType.getType() + "();");

            System.out.println("\t" + declaration.getType() + " " + declaration.getName() +" = " +
                    actExecution.getCalledFunction() + "." + actExecution.getFunctionName() + "(" + sutParams + ");");
        }
    }

    private void printAssert(UnitTest ut){
        System.out.println("\n\t//Assert");

        ArrayList<AssertExpression> expressions = ut.getAssert().getAssertExpressions();

        for (AssertExpression ae : expressions){
            String assertParams = getAssertArgs(expressions);

            System.out.println("\t" + ae.getCalledFunction() + "." + ae.getAssertType().getName() + "(" + assertParams + ");");
        }
    }

    private String getFunctionArgs(ArrayList<ArrangeStatement> arrangeStatements){
        String resultStr = "";

        for (ArrangeStatement as : arrangeStatements){
            resultStr += as.getDeclaration().getName() + ", ";
        }

        resultStr = cutFinalCommas(resultStr);

        return resultStr;
    }

    private String getAssertArgs(ArrayList<AssertExpression> expressions){
        String resultStr = "";

        for (AssertExpression ae : expressions){
            ArrayList<FunctionArgument> functionArguments = ae.getFunctionArguments();
            for (FunctionArgument ap : functionArguments){
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
