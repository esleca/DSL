package com.dsl.models.returns;

import java.util.ArrayList;

public class ParameterDataType {

    private String name;
    private ArrayList<String> argumentTypes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getArgumentTypes() {
        return argumentTypes;
    }

    public void setArgumentType(ArrayList<String> argumentTypes) {
        this.argumentTypes = argumentTypes;
    }

}
