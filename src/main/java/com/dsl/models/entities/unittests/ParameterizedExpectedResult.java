package com.dsl.models.entities.unittests;

import com.dsl.models.entities.valuetypes.ValueType;

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
