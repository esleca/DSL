package com.dsl.models.unittests.asserts.types;

import com.dsl.factories.UnitTestFactory;
import com.dsl.models.unittests.FunctionArgument;

import java.util.ArrayList;

import static com.dsl.utils.Constants.*;

public abstract class AssertTypePair extends AssertType{

    @Override
    public ArrayList<FunctionArgument> getAssertArguments() {
        ArrayList<FunctionArgument> assertParameters = new ArrayList<>();
        
        assertParameters.add(UnitTestFactory.createFunctionArgument(ARGUMENT_EXPECTED));
        assertParameters.add(UnitTestFactory.createFunctionArgument(ARGUMENT_RESULT));
        
        return assertParameters;
    }

}
