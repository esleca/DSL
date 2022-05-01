package com.dsl.models.unittests.arranges;

import java.util.ArrayList;

public class Arrange {

    private ArrayList<ArrangeStatement> arrangeStatements;

    public Arrange(ArrayList<ArrangeStatement> arrangeStatements) {
        this.arrangeStatements = arrangeStatements;
    }

    public ArrayList<ArrangeStatement> getArrangeStatements() {
        return arrangeStatements;
    }

}
