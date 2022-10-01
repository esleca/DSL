package com.dsl.mappers;

import com.dsl.models.aggregates.Function;
import com.dsl.models.dtos.ClassFunctionsResponse;
import com.dsl.models.parameters.ParameterFunction;

import java.util.ArrayList;

public class ClassFunctionsMapper {

    public static ClassFunctionsResponse convertClassFunction(Function function) {
        String name = function.getName();
        String returns = function.getReturn().getName();
        ArrayList<ParameterFunction> parameters = function.getParameters();

        return new ClassFunctionsResponse(name, returns, parameters);
    }
}
