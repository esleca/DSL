package com.dsl.models.unittests.asserts;

import java.util.ArrayList;

public class Assert {

    private ArrayList<AssertExpression> assertExpressions;

    public Assert(ArrayList<AssertExpression> assertExpressions) {
        this.assertExpressions = assertExpressions;
    }

    public ArrayList<AssertExpression> getAssertExpressions() {
        return assertExpressions;
    }

}
