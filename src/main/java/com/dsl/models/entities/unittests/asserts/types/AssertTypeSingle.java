package com.dsl.models.entities.unittests.asserts.types;

import com.dsl.models.entities.unittests.FunctionArgument;
import com.dsl.utils.Constants;

import java.util.ArrayList;

public abstract class AssertTypeSingle extends AssertType {

    @Override
    public ArrayList<FunctionArgument> getAssertArguments() {
        ArrayList<FunctionArgument> assertParameters = new ArrayList<>();
        assertParameters.add(new FunctionArgument(Constants.ARGUMENT_RESULT));
        return assertParameters;
    }
}
