package com.dsl.factories;

import com.dsl.models.unittests.ExpectedResult;
import com.dsl.models.unittests.ExpectedResultParameterized;
import com.dsl.models.unittests.ExpectedResultPrimitive;
import com.dsl.models.valuetypes.ValueType;

import java.util.ArrayList;

public class ExpectedResultsFactory {

    public static ExpectedResult createPrimitiveExpectedResult(ValueType valueType){
        return new ExpectedResultPrimitive(valueType);
    }

    public static ExpectedResult createParameterizedExpectedResult(ArrayList<ValueType> argumentTypes){
        return new ExpectedResultParameterized(argumentTypes);
    }

}
