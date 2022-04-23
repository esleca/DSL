package com.dsl.factories;

import com.dsl.models.entities.unittests.ExpectedResult;
import com.dsl.models.entities.unittests.ParameterizedExpectedResult;
import com.dsl.models.entities.unittests.PrimitiveExpectedResult;
import com.dsl.models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class ExpectedResultsFactory {

    public static ExpectedResult createPrimitiveExpectedResult(ValueType valueType){
        return new PrimitiveExpectedResult(valueType);
    }

    public static ExpectedResult createParameterizedExpectedResult(ArrayList<ValueType> argumentTypes){
        return new ParameterizedExpectedResult(argumentTypes);
    }

}
