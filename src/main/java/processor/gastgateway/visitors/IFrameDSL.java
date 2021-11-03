package processor.gastgateway.visitors;

import exceptions.ModifierNotFoundException;
import exceptions.ReturnNotFoundException;
import models.entities.aggregates.Class;
import models.entities.returns.ParameterDataType;

import java.util.ArrayList;

public interface IFrameDSL {

    void createFunction();

    void createParameter();

    void createParameterDataType();

    void writeFunction();

    void writeClassPackage(String name);

    void writeClassImport(String name);

    void writeFunctionClass(String name);

    void writeFunctionModifier(String name) throws ModifierNotFoundException;

    void writeFunctionName(String name);

    void writeFunctionReturnPrimitive(String name) throws ReturnNotFoundException;

    void writeFunctionReturnParameterized(String name) throws ReturnNotFoundException;

    void writeParameterDataTypeName(String name);

    void writeParameterDataTypeArg(ArrayList<String> names);

    void writeFunctionParameter();

    void writeStaticFunction();

    void writeFunctionParameterName(String name);

    void writeFunctionParameterType(String name);

    Class getCompilationUnit();

}
