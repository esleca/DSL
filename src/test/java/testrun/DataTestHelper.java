package testrun;

import models.entities.aggregates.Package;
import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.parameters.ParameterFunction;
import models.entities.parameters.ParameterScenario;
import models.entities.returns.IntegerReturn;
import models.entities.returns.Return;
import models.entities.valuetypes.LongType;
import models.entities.valuetypes.ValueType;
import testrun.config.TestScenarioRun;

import java.util.ArrayList;

public class DataTestHelper {

    public static TestScenarioRun getTestScenarioRun(){
        String function = "functionToTest";
        String name = "testScenarioName";
        ArrayList<ParameterScenario> parameterScenarios = getParameterScenarios();
        //String expected = "1";
        String assertion = "areEqual";
        //TestScenarioRun tsr = new TestScenarioRun(function, name, parameterScenarios, expected, assertion);
        //TestScenarioRun tsr = new TestScenarioRun(function, name, parameterScenarios, null, assertion);
        //return tsr;
        return null;
    }

    public static ArrayList<ParameterScenario> getParameterScenarios(){
        ArrayList<ParameterScenario> parameterScenarios = new ArrayList<>();
        ParameterFunction parameterFunction = getParameterFunction();
        ValueType valueType = getValueType();
        ParameterScenario parameterScenario = new ParameterScenario(parameterFunction, valueType);
        parameterScenarios.add(parameterScenario);
        return parameterScenarios;
    }

    public static ParameterFunction getParameterFunction(){
        String type = "int";
        String name = "param";
        ParameterFunction parameterFunction = new ParameterFunction(type, name);
        return parameterFunction;
    }

    public static ValueType getValueType(){
        ValueType valueType = new LongType();
        long value = 1;
        valueType.setValue(value);
        return valueType;
    }

    public static Function getFunction(){
        Class fClass = getFClass();
        Function function = new Function(fClass);
        function.setName("functionToTest");
        Return freturn = getIntReturn();
        function.setReturn(freturn);
        return function;
    }

    public static Return getIntReturn(){
        Return fReturn = new IntegerReturn();
        return fReturn;
    }


    public static Package getPackage(){
        Package pkg = new Package("TestPackage");
        return pkg;
    }

    public static Class getFClass(){
        Package fpackage = getPackage();
        Class fClass = new Class("TestClass", fpackage);
        return fClass;
    }
}
