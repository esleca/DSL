package processor.unittests;

import exceptions.AssertNotFoundException;
import factories.AssertsFactory;
import factories.UnitTestFactory;
import models.entities.unittests.asserts.Assert;
import models.entities.unittests.TestScenario;
import models.entities.unittests.asserts.AssertExpression;
import models.entities.unittests.asserts.AssertParameter;
import models.entities.unittests.asserts.types.AssertType;

import java.util.ArrayList;

public class ProcessorHandlerUnitTesterAsserter implements IProcessorHandlerUnitTesterAsserter {

    private UnitTestFactory unitTestFactory;
    private AssertsFactory assertsFactory;

    public ProcessorHandlerUnitTesterAsserter(){
        unitTestFactory = new UnitTestFactory();
        assertsFactory = new AssertsFactory();
    }

    @Override
    public Assert getAssert(TestScenario testScenario) throws AssertNotFoundException {
        ArrayList<AssertExpression> expressions = new ArrayList<>();

        String calledFunction = "Assert";
        String assertName = testScenario.getAssertType().getName();
        AssertType assertType = assertsFactory.createAssertType(assertName);

        ArrayList<AssertParameter> assertParameters = this.getAssertParameters();

        AssertExpression expression = new AssertExpression(calledFunction, assertType, assertParameters);
        expressions.add(expression);
        return unitTestFactory.createAssert(expressions);
    }

    private ArrayList<AssertParameter> getAssertParameters(){

        ArrayList<AssertParameter> assertParameters = new ArrayList<>();


        return assertParameters;
    }
}
