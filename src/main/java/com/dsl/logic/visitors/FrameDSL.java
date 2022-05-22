package com.dsl.logic.visitors;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.factories.*;

import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;
import com.dsl.models.imports.Import;
import com.dsl.models.parameters.ParameterFunction;
import com.dsl.models.returns.ParameterDataType;
import com.dsl.models.returns.Return;

import java.util.ArrayList;

public class FrameDSL implements IFrameDSL {

	private String language;
    private Package gPackage;
    private ArrayList<Import> imports;
    private Class fileClass;
    private Function currentFunction;
    private ParameterFunction parameter;
    private ArrayList<Function> functions;
    private ParameterDataType parameterDataType;

    public FrameDSL(){
        imports = new ArrayList<>();
        parameter = new ParameterFunction();
        functions = new ArrayList<>();
    }

    @Override
    public void createFunction(){
        this.currentFunction = AggregatesFactory.createFunction(fileClass);
    }

    @Override
    public void createParameter(){
        this.parameter = ParametersFactory.createParameterFunction();
    }

    @Override
    public void createParameterDataType(){
        this.parameterDataType = ReturnsFactory.createParameterDataType();
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
    public void writeAbstractFunction(){
        getCurrentFunction().setAbstract(true);
    }

    @Override
    public void writeClassLanguage(String name){
    	this.language = name;
    }
    
    @Override
    public void writeClassPackage(String name) {
        this.gPackage = AggregatesFactory.createPackage(name);
    }

    @Override
    public void writeClassImport(String name){
        imports.add(ImportsFactory.createImport(name));
    }

    @Override
    public void writeFunctionClass(String name) {
        fileClass = AggregatesFactory.createClass(language, name, gPackage);
    }

    @Override
    public void writeFunctionModifier(String name) throws ModifierNotFoundException {
        getCurrentFunction().addModifier(ModifiersFactory.createModifier(name));
    }

    @Override
    public void writeFunctionName(String name) {
        getCurrentFunction().setName(name);
    }

    @Override
    public void writeFunctionReturnPrimitive(String name) throws ReturnNotFoundException {
        Return returns = ReturnsFactory.createPrimitiveReturn(name);
        getCurrentFunction().setReturn(returns);
    }
    
    @Override
    public void writeFunctionReturnInstance(String name) throws ReturnNotFoundException {
        Return returns = ReturnsFactory.createInstanceReturn(name);
        getCurrentFunction().setReturn(returns);
    }

    @Override
    public void writeFunctionReturnParameterized(String name) throws ReturnNotFoundException {
        ParameterDataType dataType = getParameterDataType();
        Return returns = ReturnsFactory.createParameterizedReturn(name, dataType);
        getCurrentFunction().setReturn(returns);
    }

    @Override
    public void writeParameterDataTypeName(String name){
        getParameterDataType().setName(name);
    }

    @Override
    public void writeParameterDataTypeArg(ArrayList<String> names){
        getParameterDataType().setArgumentType(names);
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
    public Class getCompilationUnit() {
        getFileClass().setPackage(getPackage());
        getFileClass().setImports(getImports());
        getFileClass().setFunctions(getFunctions());
        return getFileClass();
    }


    private Class getFileClass(){
        return this.fileClass;
    }

    private ArrayList<Function> getFunctions(){
        return this.functions;
    }

    private Function getCurrentFunction(){
        return this.currentFunction;
    }

    private ParameterFunction getParameter(){
        return this.parameter;
    }

    private Package getPackage(){
        return this.gPackage;
    }

    private ArrayList<Import> getImports(){
        return this.imports;
    }

    private ParameterDataType getParameterDataType(){
        return this.parameterDataType;
    }


}
