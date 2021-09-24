package processor.gastgateway.visitors;

import models.entities.aggregates.Function;

import java.util.ArrayList;

public interface IFrameDSL {

    void createFunction();
    void createParameter();

    void writeFunction();

    void writeFunctionPackage(String name);
    void writeFunctionClass(String name);
    void writeFunctionModifier(String name);
    void writeFunctionName(String name);
    void writeFunctionReturn(String name);

    void writeFunctionParameter();

    void writeStaticFunction();

    void writeFunctionParameterName(String name);
    void writeFunctionParameterType(String name);

    ArrayList<Function> getFunctions();

}
