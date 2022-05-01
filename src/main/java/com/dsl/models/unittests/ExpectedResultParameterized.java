package com.dsl.models.unittests;

import com.dsl.models.valuetypes.ValueType;

import java.util.ArrayList;

public class ExpectedResultParameterized extends ExpectedResult {

    private ArrayList<ValueType> argumentTypes;

    public ExpectedResultParameterized(ArrayList<ValueType> argumentTypes){
        this.argumentTypes = argumentTypes;
    }

    public ArrayList<ValueType> getArgumentTypes() {
        return argumentTypes;
    }

}
