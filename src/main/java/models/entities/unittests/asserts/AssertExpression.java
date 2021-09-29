package models.entities.unittests.asserts;

import models.entities.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class AssertExpression {

    private String calledFunction;
    private AssertType assertType;
    private ArrayList<AssertParameter> assertParameters;

    public AssertExpression(String calledFunction, AssertType assertType, ArrayList<AssertParameter> assertParameters) {
        this.calledFunction = calledFunction;
        this.assertType = assertType;
        this.assertParameters = assertParameters;
    }

    public String getCalledFunction() {
        return calledFunction;
    }

    public void setCalledFunction(String calledFunction) {
        this.calledFunction = calledFunction;
    }

    public AssertType getAssertType() {
        return assertType;
    }

    public void setAssertType(AssertType assertType) {
        this.assertType = assertType;
    }

    public ArrayList<AssertParameter> getAssertParameters() {
        return assertParameters;
    }

    public void setAssertParameters(ArrayList<AssertParameter> assertParameters) {
        this.assertParameters = assertParameters;
    }

}
