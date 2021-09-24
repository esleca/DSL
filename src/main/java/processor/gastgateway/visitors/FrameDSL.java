package processor.gastgateway.visitors;

import factories.AggregatesFactory;
import factories.ModifiersFactory;
import factories.ParametersFactory;
import factories.ReturnsFactory;

import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.parameters.ParameterFunction;

import java.util.ArrayList;

public class FrameDSL implements IFrameDSL {

    private String gPackage;
    private Class fileClass;
    private Function currentFunction;
    private ParameterFunction parameter;
    private ArrayList<Function> functions;

    private ModifiersFactory modifiersFactory;
    private ReturnsFactory returnsFactory;
    private ParametersFactory parametersFactory;
    private AggregatesFactory aggregatesFactory;

    public FrameDSL(){

        parameter = new ParameterFunction();
        functions = new ArrayList<>();
        modifiersFactory = new ModifiersFactory();
        returnsFactory = new ReturnsFactory();
        parametersFactory = new ParametersFactory();
        aggregatesFactory = new AggregatesFactory();
    }

    @Override
    public void createFunction(){
        this.currentFunction = aggregatesFactory.createFunction(fileClass, gPackage);
    }

    @Override
    public void createParameter(){
        this.parameter = parametersFactory.createParameterFunction();
    }

    @Override
    public void writeFunction(){
        getFunctions().add(getCurrentFunction());
        this.currentFunction = null;
    }

    @Override
    public void writeFunctionParameter(){
        getCurrentFunction().getParameters().add(getParameter());
        this.parameter = null;
    }

    @Override
    public void writeStaticFunction(){
        getCurrentFunction().setStatic(true);
    }

    @Override
    public void writeFunctionPackage(String name) {
        gPackage = name;
    }

    @Override
    public void writeFunctionClass(String name) {
        fileClass = aggregatesFactory.createClass(name);
    }

    @Override
    public void writeFunctionModifier(String name) {
        getCurrentFunction().setModifier(modifiersFactory.createModifier(name));
    }

    @Override
    public void writeFunctionName(String name) {
        getCurrentFunction().setName(name);
    }

    @Override
    public void writeFunctionReturn(String name) {
        getCurrentFunction().setReturn(returnsFactory.createReturn(name));
    }

    @Override
    public void writeFunctionParameterName(String name) {
        getParameter().setName(name);
    }

    @Override
    public void writeFunctionParameterType(String name) {
        getParameter().setType(name);
    }

    @Override
    public ArrayList<Function> getFunctions(){
        return this.functions;
    }


    private Function getCurrentFunction(){
        return this.currentFunction;
    }

    private ParameterFunction getParameter(){
        return this.parameter;
    }

}
