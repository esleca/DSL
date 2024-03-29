package com.dsl.logic.testableunits;

import com.dsl.models.aggregates.Function;
import com.dsl.models.modifiers.Modifier;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TestableUnitHandler implements ITestableUnitHandler {

    private List<String> modifiers;
    private List<String> returns;

    public TestableUnitHandler(){
        initValidModifiers();
        initRestrictedReturns();
    }

    private void initValidModifiers(){
        modifiers = new ArrayList<>();
        modifiers.add("public");
        modifiers.add("protected");
    }

    private void initRestrictedReturns(){
        returns = new ArrayList<>();
        returns.add("void");
    }

    
    @Override
    public ArrayList<Function> processTestableUnits(ArrayList<Function> functions){
        ArrayList<Function> testableUnits = new ArrayList<>();

        processTestableValues(functions);

        for (Function function: functions){
            if (function.isTestable()){
                testableUnits.add(function);
            }
        }
        return testableUnits;
    }

    
    private void processTestableValues(ArrayList<Function> functions){
        for (Function function: functions){
        	if (function != null){
        		boolean isTestable = isTestableUnit(function);
                function.setIsTestable(isTestable);
            }
        }
    }

    
    private boolean isTestableUnit(Function function){
    	if (isAbstract(function))
            return false;
        
    	if (!hasValidModifier(function))
            return false;
        
        if (!isValidFunctionReturn(function))
            return false;
        
        return true;
    }
    
    
    private boolean isAbstract(Function function) {
    	return function.isAbstract();
    }

    
    private boolean hasValidModifier(Function function){
    	for (Modifier modifier: function.getModifiers()){
    		if(modifiers.contains(modifier.getName()))
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
