package com.dsl.models.entities.aggregates;

import com.dsl.models.entities.modifiers.Modifier;
import com.dsl.models.entities.parameters.ParameterFunction;
import com.dsl.models.entities.returns.Return;

import java.util.ArrayList;

public class Function {

    private Class fileClass;
    private ArrayList<Modifier> modifiers;
    private boolean isStatic;
    private boolean isAbstract;
    private Return returns;
    private String name;
    private ArrayList<ParameterFunction> parameters;
    private boolean isTestable;

    public Function(Class fileClass){
        this.fileClass = fileClass;
        this.modifiers = new ArrayList<>(); 
        this.parameters = new ArrayList<>();
    }

    public Class getFileClass() {
        return fileClass;
    }

    public ArrayList<Modifier> getModifiers() {
        return modifiers;
    }

    public void addModifier(Modifier modifier) {
        this.modifiers.add(modifier);
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
    	this.isStatic = aStatic;
    }
    
    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean inAbstract) {
    	this.isAbstract = inAbstract;
    }

    public Return getReturn() {
        return returns;
    }

    public void setReturn(Return returns) {
        this.returns = returns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ParameterFunction> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<ParameterFunction> parameters) {
        this.parameters = parameters;
    }

    public boolean isTestable() {
        return isTestable;
    }

    public void setIsTestable(boolean inTestable) {
        this.isTestable = inTestable;
    }

}
