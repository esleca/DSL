package processor.gastgateway.visitors;

import exceptions.ModifierNotFoundException;
import exceptions.ReturnNotFoundException;
import models.entities.aggregates.Function;

import java.util.ArrayList;

public interface IFrameDSL {

    void createFunction();
    void createParameter();

    void writeFunction();

    void writeFunctionPackage(String name);
    void writeFunctionClass(String name);
    void writeFunctionModifier(String name) throws ModifierNotFoundException;
    void writeFunctionName(String name);
    void writeFunctionReturn(String name) throws ReturnNotFoundException;

    void writeFunctionParameter();

    void writeStaticFunction();

    void writeFunctionParameterName(String name);
    void writeFunctionParameterType(String name);

    ArrayList<Function> getFunctions();

}
