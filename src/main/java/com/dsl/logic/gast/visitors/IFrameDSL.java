package com.dsl.logic.gast.visitors;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.exceptions.ReturnNotFoundException;
import com.dsl.models.entities.aggregates.Class;

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

    void writeFunctionReturnInstance(String name) throws ReturnNotFoundException;

    void writeFunctionReturnParameterized(String name) throws ReturnNotFoundException;

    void writeParameterDataTypeName(String name);

    void writeParameterDataTypeArg(ArrayList<String> names);

    void writeFunctionParameter();

    void writeStaticFunction();

    void writeFunctionParameterName(String name);

    void writeFunctionParameterType(String name);

    Class getCompilationUnit();

}
