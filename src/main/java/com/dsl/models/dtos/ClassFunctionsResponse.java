package com.dsl.models.dtos;

import com.dsl.models.parameters.ParameterFunction;
import java.util.ArrayList;

public class ClassFunctionsResponse {
    private String name;
    private String returns;
    private ArrayList<ParameterFunction> parameters;

    public ClassFunctionsResponse(String name, String returns, ArrayList<ParameterFunction> parameters){
        this.name = name;
        this.returns = returns;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public String getReturn() {
        return returns;
    }

    public ArrayList<ParameterFunction> getParameters() {
        return parameters;
    }
}
