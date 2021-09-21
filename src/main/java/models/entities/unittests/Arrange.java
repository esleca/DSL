package models.entities.unittests;

import java.util.ArrayList;

public class Arrange {

    private ArrayList<ArrangeStatement> arrangeStatements;

    public Arrange(ArrayList<ArrangeStatement> arrangeStatements) {
        this.arrangeStatements = arrangeStatements;
    }

    public ArrayList<ArrangeStatement> getArrangeStatements() {
        return arrangeStatements;
    }

    public void setArrangeStatements(ArrayList<ArrangeStatement> arrangeStatements) {
        this.arrangeStatements = arrangeStatements;
    }

}
