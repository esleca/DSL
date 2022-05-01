package com.dsl.models.unittests.asserts;

import com.dsl.models.unittests.FunctionArgument;
import com.dsl.models.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class AssertExpression {

    private String calledFunction;
    private AssertType assertType;
    private ArrayList<FunctionArgument> functionArguments;

    public AssertExpression(String calledFunction, AssertType assertType, ArrayList<FunctionArgument> functionArguments) {
        this.calledFunction = calledFunction;
        this.assertType = assertType;
        this.functionArguments = functionArguments;
    }

    public String getCalledFunction() {
        return calledFunction;
    }

    public AssertType getAssertType() {
        return assertType;
    }

    public void setAssertType(AssertType assertType) {
        this.assertType = assertType;
    }

    public ArrayList<FunctionArgument> getFunctionArguments() {
        return functionArguments;
    }

}
