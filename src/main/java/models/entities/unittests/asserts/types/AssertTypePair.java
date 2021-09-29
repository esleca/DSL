package models.entities.unittests.asserts.types;

import models.entities.unittests.FunctionArgument;
import utils.Constants;

import java.util.ArrayList;

public abstract class AssertTypePair extends AssertType{

    @Override
    public ArrayList<FunctionArgument> getAssertArguments() {
        ArrayList<FunctionArgument> assertParameters = new ArrayList<>();
        assertParameters.add(new FunctionArgument(Constants.ARGUMENT_EXPECTED));
        assertParameters.add(new FunctionArgument(Constants.ARGUMENT_RESULT));
        return assertParameters;
    }

}
