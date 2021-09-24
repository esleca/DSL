package processor;

import factories.TestableFactory;
import models.entities.aggregates.Function;
import models.entities.unittests.TestableUnit;

import java.util.ArrayList;
import java.util.List;

public class ProcessorHandlerTestable implements IProcessorHandlerTestable {

    private List<String> modifiers;

    /**
     * Constructor
     */
    public ProcessorHandlerTestable(){
        initializePermitModifiers();
    }


    /**
     * Initialize the permitted modifiers
     * Public
     */
    private void initializePermitModifiers(){
        modifiers = new ArrayList<>();
        modifiers.add("public");
    }

    /**
     * Check the functions list and return a list of testable units
     *
     * @param functions
     * @return
     */
    @Override
    public ArrayList<TestableUnit> getTestableUnits(ArrayList<Function> functions){
        ArrayList<TestableUnit> testableUnits = new ArrayList<>();
        TestableFactory factory = new TestableFactory();

        for (Function function: functions){
            if (isTestableUnit(function)){
                TestableUnit testableUnit = factory.createTestableUnit(function);
                testableUnits.add(testableUnit);
            }
        }
        return testableUnits;
    }

    /**
     * Check function modifiers, only public are testable functions
     *
     * @param function
     * @return
     */
    private boolean isTestableUnit(Function function){
        if (function != null){
            String modifier = function.getModifier().getName();
            if (modifiers.contains(modifier)){
                return true;
            }
        }
        return false;
    }

}
