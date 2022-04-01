package processor.unittests;

import models.entities.aggregates.Function;

import java.util.ArrayList;
import java.util.List;

public class TestableUnitHandler implements ITestableUnitHandler {

    private List<String> modifiers;
    private List<String> returns;

    public TestableUnitHandler(){
        initializePermitModifiers();
        initializeExcludedReturns();
    }

    private void initializePermitModifiers(){
        modifiers = new ArrayList<>();
        modifiers.add("public");
        modifiers.add("protected");
    }

    private void initializeExcludedReturns(){
        returns = new ArrayList<>();
        returns.add("void");
    }

    @Override
    public ArrayList<Function> processTestableFunctions(ArrayList<Function> functions){
        ArrayList<Function> testableFunctions = new ArrayList<>();

        for (Function function: functions){
            if (isTestableFunction(function)){
                testableFunctions.add(function);
            }
        }
        return testableFunctions;
    }

    private boolean isTestableFunction(Function function){
        if (function != null){
            if (!isValidFunctionModifier(function))
                return false;
            if (!isValidFunctionReturn(function)){
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isValidFunctionModifier(Function function){
        String funcModifier = function.getModifier().getName();

        if (modifiers.contains(funcModifier)){
            return true;
        }
        return false;
    }

    private boolean isValidFunctionReturn(Function function){
        String funcReturn = function.getReturn().getName();

        if (!returns.contains(funcReturn)){
            return true;
        }
        return false;
    }

}
