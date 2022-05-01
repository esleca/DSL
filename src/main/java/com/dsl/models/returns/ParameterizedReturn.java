package com.dsl.models.returns;

public class ParameterizedReturn extends Return {

    private final ParameterDataType dataType;

    public ParameterizedReturn(ParameterDataType dataType){
        this.name = "Parameterized";
        this.dataType = dataType;
    }

    public ParameterDataType getParameterDataType(){
        return this.dataType;
    }

}
