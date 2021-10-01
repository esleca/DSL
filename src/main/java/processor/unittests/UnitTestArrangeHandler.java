package processor.unittests;

import factories.UnitTestFactory;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.*;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.Declaration;
import models.entities.unittests.arranges.ArrangeDefinition;

import java.util.ArrayList;

public class UnitTestArrangeHandler implements IUnitTestArrangeHandler {

    private UnitTestFactory unitTestFactory;

    public UnitTestArrangeHandler(UnitTestFactory unitTestFactory){
        this.unitTestFactory = unitTestFactory;
    }

    /**
     * Create the Arrange section of the unit test
     *
     * @param testScenario
     * @return Arrange section
     */
    @Override
    public Arrange processUnitTestArrange(TestScenario testScenario) {
        ArrayList<ArrangeStatement> arranges = new ArrayList<>();
        ArrayList<ParameterScenario> parameterScenarios = testScenario.getParameters();

        for (ParameterScenario parameterScenario : parameterScenarios){
            String type = parameterScenario.getParameterFunction().getType();
            String name = parameterScenario.getParameterFunction().getName();

            Declaration declaration = unitTestFactory.createDeclaration(type, name);
            ArrangeDefinition definition = unitTestFactory.createArrangeStatementDefinition(parameterScenario.getValueType());

            ArrangeStatement arrangeStatement = unitTestFactory.createArrangeStatement(declaration, definition);
            arranges.add(arrangeStatement);
        }

        return unitTestFactory.createArrange(arranges);
    }
}
