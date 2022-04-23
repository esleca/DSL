package com.dsl.models.entities.aggregates;

import com.dsl.models.entities.imports.Import;
import java.util.ArrayList;

public class Class {

    private Package gpackage;
    private ArrayList<Import> imports;
    private String name;
    private ArrayList<Function> functions;

    public Class(String name, Package aPackage) {
        this.name = name;
        this.gpackage = aPackage;
        this.imports = new ArrayList<>();
        this.functions = new ArrayList<>();
    }

    public Package getPackage() {
        return gpackage;
    }

    public void setPackage(Package apackage) {
        this.gpackage = apackage;
    }

    public ArrayList<Import> getImports(){
        return this.imports;
    }

    public void setImports(ArrayList<Import> imports){
        this.imports = imports;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(ArrayList<Function> functions){
        this.functions = functions;
    }

}
