package processor.gastgateway.visitors;

import exceptions.ModifierNotFoundException;
import exceptions.ReturnNotFoundException;
import factories.*;

import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.aggregates.Package;
import models.entities.imports.Import;
import models.entities.parameters.ParameterFunction;
import models.entities.returns.ParameterDataType;
import models.entities.returns.Return;

import java.util.ArrayList;

public class FrameDSL implements IFrameDSL {

    private Package gPackage;
    private ArrayList<Import> imports;
    private Class fileClass;
    private Function currentFunction;
    private ParameterFunction parameter;
    private ArrayList<Function> functions;
    private ParameterDataType parameterDataType;

    private final IModifiersFactory modifiersFactory;
    private final IReturnsFactory returnsFactory;
    private final IParametersFactory parametersFactory;
    private final IAggregatesFactory aggregatesFactory;
    private final IImportsFactory importsFactory;

    public FrameDSL(IModifiersFactory iModifiersFactory, IReturnsFactory iReturnsFactory, IParametersFactory iParametersFactory,
                    IAggregatesFactory iAggregatesFactory, IImportsFactory iImportsFactory){
        imports = new ArrayList<>();
        parameter = new ParameterFunction();
        functions = new ArrayList<>();
        modifiersFactory = iModifiersFactory;
        returnsFactory = iReturnsFactory;
        parametersFactory = iParametersFactory;
        aggregatesFactory = iAggregatesFactory;
        importsFactory = iImportsFactory;
    }

    @Override
    public void createFunction(){
        this.currentFunction = aggregatesFactory.createFunction(fileClass);
    }

    @Override
    public void createParameter(){
        this.parameter = parametersFactory.createParameterFunction();
    }

    @Override
    public void createParameterDataType(){
        this.parameterDataType = returnsFactory.createParameterDataType();
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
    public void writeClassPackage(String name) {
        gPackage = aggregatesFactory.createPackage(name);
    }

    @Override
    public void writeClassImport(String name){
        imports.add(importsFactory.createImport(name));
    }

    @Override
    public void writeFunctionClass(String name) {
        fileClass = aggregatesFactory.createClass(name, gPackage);
    }

    @Override
    public void writeFunctionModifier(String name) throws ModifierNotFoundException {
        getCurrentFunction().setModifier(modifiersFactory.createModifier(name));
    }

    @Override
    public void writeFunctionName(String name) {
        getCurrentFunction().setName(name);
    }

    @Override
    public void writeFunctionReturnPrimitive(String name) throws ReturnNotFoundException {
        Return returns = returnsFactory.createPrimitiveReturn(name);
        getCurrentFunction().setReturn(returns);
    }

    @Override
    public void writeFunctionReturnParameterized(String name) throws ReturnNotFoundException {
        ParameterDataType dataType = getParameterDataType();
        Return returns = returnsFactory.createParameterizedReturn(name, dataType);
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
