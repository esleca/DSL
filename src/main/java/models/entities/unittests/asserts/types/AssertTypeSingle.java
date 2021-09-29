package models.entities.unittests.asserts.types;

import models.entities.unittests.asserts.AssertParameter;
import utils.Constants;

import java.util.ArrayList;

public abstract class AssertTypeSingle extends AssertType {

    @Override
    public ArrayList<AssertParameter> getAssertParameters() {
        ArrayList<AssertParameter> assertParameters = new ArrayList<>();
        assertParameters.add(new AssertParameter(Constants.PARAM_RESULT));
        return assertParameters;
    }
}
