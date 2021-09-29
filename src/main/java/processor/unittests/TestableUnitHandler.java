package processor.unittests;

import factories.TestableFactory;
import models.entities.aggregates.Function;
import models.entities.unittests.TestableUnit;

import java.util.ArrayList;
import java.util.List;

public class TestableUnitHandler implements ITestableUnitHandler {

    private List<String> modifiers;
    private List<String> returns;
    private TestableFactory factory;

    public TestableUnitHandler(){
        initializePermitModifiers();
        initializeExcludedReturns();
        factory = new TestableFactory();
    }

    private void initializePermitModifiers(){
        modifiers = new ArrayList<>();
        modifiers.add("public");
    }

    private void initializeExcludedReturns(){
        returns = new ArrayList<>();
        returns.add("void");
    }

    @Override
    public ArrayList<TestableUnit> processTestableUnits(ArrayList<Function> functions){
        ArrayList<TestableUnit> testableUnits = new ArrayList<>();

        for (Function function: functions){
            if (isTestableUnit(function)){
                TestableUnit testableUnit = factory.createTestableUnit(function);
                testableUnits.add(testableUnit);
            }
        }
        return testableUnits;
    }

    private boolean isTestableUnit(Function function){
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
