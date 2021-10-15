package models.entities.aggregates;

import java.util.ArrayList;

public class Package {

    private String name;
    private ArrayList<Class> classes;

    public Package(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

}
