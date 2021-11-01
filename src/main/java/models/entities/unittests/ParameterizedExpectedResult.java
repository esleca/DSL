package models.entities.unittests;

import models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class ParameterizedExpectedResult extends ExpectedResult {


    private ArrayList<ValueType> argumentTypes;

    public ParameterizedExpectedResult(ArrayList<ValueType> argumentTypes){
        this.argumentTypes = argumentTypes;
    }

    public ArrayList<ValueType> getArgumentTypes() {
        return argumentTypes;
    }

}
