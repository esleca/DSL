package models.entities.unittests.asserts.types;

import models.entities.unittests.FunctionArgument;

import java.util.ArrayList;

public abstract class AssertType {

    protected String name;

    public String getName(){
        return this.name;
    }

    public abstract ArrayList<FunctionArgument> getAssertArguments();

}
