package com.dsl.models.unittests.acts;

import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.FunctionArgument;

import java.util.ArrayList;

public class ActExecution {

    protected Declaration declaration;
    private String calledFunction;
    private String functionName;
    private ArrayList<FunctionArgument> functionArguments;

    public ActExecution(Declaration declaration, String calledFunction, String functionName, ArrayList<FunctionArgument> functionArguments){
        this.declaration = declaration;
        this.calledFunction = calledFunction;
        this.functionName = functionName;
        this.functionArguments = functionArguments;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public String getCalledFunction() {
        return calledFunction;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<FunctionArgument> getFunctionArguments() {
        return functionArguments;
    }

}
