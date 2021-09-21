package models.entities.aggregates;

import java.util.ArrayList;

public class Class {

    private String packageName;
    private String name;
    private boolean isStatic;
    private ArrayList<Function> functions;

    public Class(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
