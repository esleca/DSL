package utils;

import models.entities.aggregates.Function;
import models.entities.unittests.*;
import models.entities.unittests.acts.*;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.asserts.AssertExpression;
import java.util.ArrayList;

public class ConsolePrinter implements IPrinter {

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
            Declaration declaration = as.getDeclaration();

            System.out.println(declaration.getType() + " " + declaration.getName() + " = " +
                    as.getDefinition().getValueType().getValue() + ";");
        }

        Function function = ut.getTestScenario().getTestableUnit().getFunction();
        String fReturn = function.getReturn().getName();
        ExpectedResult expectedResult = ut.getTestScenario().getExpectedResult();

        // TODO: This print should be done just when assert type expects a second param
        // TODO: AssertTypeSingle and AssertTypePair classes can be used to determine this
        
        System.out.println(fReturn + " expected = " + expectedResult.getValueType().getValue() + ";");
    }

    private void printAct(UnitTest ut){
        Function function = ut.getTestScenario().getTestableUnit().getFunction();

        System.out.println("\n//Act");

        ActExecution actExecution = ut.getAct().getActExecution();

        Declaration declaration = actExecution.getDeclaration();

        ArrayList<ArrangeStatement> arrangeStatements = ut.getArrange().getArrangeStatements();

        String sutParams = getFunctionArgs(arrangeStatements);

        if (function.isStatic()){

            System.out.println(declaration.getType() + " " + declaration.getName() +" = " +
                    actExecution.getCalledFunction() + "." + actExecution.getFunctionName() + "(" + sutParams + ");");
        } else{

            IInstanceActioner instanceActioner = (IInstanceActioner) ut.getAct();
            ActNewType actNewType = instanceActioner.getActNewType();

            System.out.println(actNewType.getType() + " " + actNewType.getName() + " = new " +
                    actNewType.getType() + "();");

            System.out.println(declaration.getType() + " " + declaration.getName() +" = " +
                    actExecution.getCalledFunction() + "." + actExecution.getFunctionName() + "(" + sutParams + ");");
        }
    }

    private void printAssert(UnitTest ut){
        System.out.println("\n//Assert");

        ArrayList<AssertExpression> expressions = ut.getAssert().getAssertExpressions();

        for (AssertExpression ae : expressions){
            String assertParams = getAssertArgs(expressions);

            System.out.println(ae.getCalledFunction() + "." + ae.getAssertType().getName() + "(" + assertParams + ");");
        }

        System.out.println("\n######################################");
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
