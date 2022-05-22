package com.dsl.models.aggregates;

import com.dsl.models.imports.Import;
import java.util.ArrayList;

public class Class {

	private String language;
    private Package gpackage;
    private ArrayList<Import> imports;
    private String name;
    private ArrayList<Function> functions;

    public Class(String language, String name, Package aPackage) {
        this.language = language;
    	this.name = name;
        this.gpackage = aPackage;
        this.imports = new ArrayList<>();
        this.functions = new ArrayList<>();
    }
    
    public String getLanguage(){
        return this.language;
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
