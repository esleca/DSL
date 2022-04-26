package com.dsl.resources;

import com.dsl.models.entities.aggregates.Package;
import com.dsl.models.entities.aggregates.Class;
import com.dsl.models.entities.aggregates.Function;
import com.dsl.models.entities.parameters.ParameterFunction;
import com.dsl.models.entities.parameters.ParameterScenario;
import com.dsl.models.entities.returns.IntegerReturn;
import com.dsl.models.entities.returns.Return;
import com.dsl.models.entities.unittests.Declaration;
import com.dsl.models.entities.unittests.ExpectedResult;
import com.dsl.models.entities.unittests.ExpectedResultPrimitive;
import com.dsl.models.entities.unittests.TestScenario;
import com.dsl.models.entities.unittests.acts.Act;
import com.dsl.models.entities.unittests.acts.ActExecution;
import com.dsl.models.entities.unittests.acts.ActNewType;
import com.dsl.models.entities.unittests.acts.InstanceAct;
import com.dsl.models.entities.unittests.arranges.Arrange;
import com.dsl.models.entities.unittests.arranges.ArrangeDefinition;
import com.dsl.models.entities.unittests.arranges.ArrangeStatement;
import com.dsl.models.entities.unittests.asserts.Assert;
import com.dsl.models.entities.unittests.asserts.types.AreEqual;
import com.dsl.models.entities.unittests.asserts.types.AssertType;
import com.dsl.models.entities.valuetypes.LongType;
import com.dsl.models.entities.valuetypes.ValueType;
import com.dsl.testrun.config.TestScenarioRun;

import java.util.ArrayList;

public class DataTestHelper {

    public static TestScenarioRun getTestScenarioRun(){
        String function = "functionToTest";
        String name = "testScenarioName";
        ArrayList<ParameterScenario> parameterScenarios = getParameterScenarios();
        String assertion = "areEqual";
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
        long value = 1555555555;
        valueType.setValue(value);
        return valueType;
    }

    public static TestScenario getTestScenario(){
        Class fClass = getFClass();
        
        Function function = new Function(fClass);
        function.setName("functionToTest");
        
        Return freturn = getIntReturn();
        function.setReturn(freturn);
        
        ArrayList<ParameterScenario> params = getParameterScenarios();
        ExpectedResultPrimitive expected = getPrimitiveExpectedResult(); 
        AreEqual testAssert = getAreEqualAssert();
        
        return new TestScenario(function.getName(), function, params, expected, testAssert);
    }
    
    public static ExpectedResultPrimitive getPrimitiveExpectedResult() {
    	ValueType valueType = getValueType();
		return new ExpectedResultPrimitive(valueType);
    }
    
    public static ArrayList<ArrangeStatement> getArrangeStatements(){
    	ArrayList<ArrangeStatement> result = new ArrayList<ArrangeStatement>();
    	result.add(getArrangeStatement());
    	return result;
    }
    
    public static ArrangeStatement getArrangeStatement(){
    	Declaration declaration = getDeclaration();
        ArrangeDefinition definition = getArrangeDefinition();
    	return new ArrangeStatement(declaration, definition);
    }
    
    public static Declaration getDeclaration() {
    	return new Declaration("type", "name");
    }
    
    public static ArrangeDefinition getArrangeDefinition() {
    	ValueType valueType = getValueType();
    	return new ArrangeDefinition(valueType);
    }

    public static Arrange getArrange() {
    	ArrayList<ArrangeStatement> arrangeStatements = getArrangeStatements();
    	return new Arrange(arrangeStatements);
    }
    
    //TODO: complete 
    public static InstanceAct getInstanceAct() {
    	ActNewType actNewType = null;
    	ActExecution actExecution = null;
    	
    	return new InstanceAct(actNewType, actExecution);
    }
    
    public static Assert getAssert() {

    	return new Assert(null);
    }
    
    public static AreEqual getAreEqualAssert() {
		return new AreEqual();
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
