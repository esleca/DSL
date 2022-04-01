package models.entities.unittests.asserts.types;

import models.entities.unittests.FunctionArgument;
import java.util.ArrayList;

import static utils.Constants.*;

public abstract class AssertTypePair extends AssertType{

    @Override
    public ArrayList<FunctionArgument> getAssertArguments() {
        ArrayList<FunctionArgument> assertParameters = new ArrayList<>();
        assertParameters.add(new FunctionArgument(ARGUMENT_EXPECTED));
        assertParameters.add(new FunctionArgument(ARGUMENT_RESULT));
        return assertParameters;
    }

}
