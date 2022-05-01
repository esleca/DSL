package com.dsl.models.unittests.asserts.types;

import com.dsl.models.unittests.FunctionArgument;

import java.util.ArrayList;

public abstract class AssertType {

    protected String name;

    public String getName(){
        return this.name;
    }

    public abstract ArrayList<FunctionArgument> getAssertArguments();

}
