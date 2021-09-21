package models.entities.aggregates;

import models.entities.modifiers.Modifier;
import models.entities.parameters.ParameterFunction;
import models.entities.returns.Return;
import models.entities.unittests.TestScenario;

import java.util.ArrayList;

public class Function {

    private String gPackage;
    private Class fileClass;
    private Modifier modifier;
    private boolean isStatic;
    private Return returns;
    private String name;
    private ArrayList<ParameterFunction> parameters;
    private ArrayList<TestScenario> testScenarios;


    public Function(Class fileClass, String gPackage){
        this.fileClass = fileClass;
        this.gPackage = gPackage;
        this.parameters = new ArrayList<>();
    }


    public Class getFileClass() {
        return fileClass;
    }

    public void setFileClass(Class fileClass) {
        this.fileClass = fileClass;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
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

    public String getPackage() {
        return gPackage;
    }

    public void setPackage(String gPackage) {
        this.gPackage = gPackage;
    }

    public ArrayList<ParameterFunction> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<ParameterFunction> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<TestScenario> getTestScenarios() {
        return testScenarios;
    }

    public void setTestScenarios(ArrayList<TestScenario> testScenarios) {
        this.testScenarios = testScenarios;
    }

}
