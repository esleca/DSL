package com.dsl.factories;

import com.dsl.models.entities.unittests.ExpectedResult;
import com.dsl.models.entities.unittests.ExpectedResultParameterized;
import com.dsl.models.entities.unittests.ExpectedResultPrimitive;
import com.dsl.models.entities.valuetypes.ValueType;

import java.util.ArrayList;

public class ExpectedResultsFactory {

    public static ExpectedResult createPrimitiveExpectedResult(ValueType valueType){
        return new ExpectedResultPrimitive(valueType);
    }

    public static ExpectedResult createParameterizedExpectedResult(ArrayList<ValueType> argumentTypes){
        return new ExpectedResultParameterized(argumentTypes);
    }

}
