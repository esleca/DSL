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

    @Override
    public Arrange processUnitTestArrange(TestScenario testScenario) {
        ArrayList<ArrangeStatement> arranges = new ArrayList<>();
        ArrayList<ParameterScenario> parameterScenarios = testScenario.getParameters();

        for (ParameterScenario parameterScenario : parameterScenarios){
            String type = parameterScenario.getParameterFunction().getType();
            String name = parameterScenario.getParameterFunction().getName();

            Declaration declaration = UnitTestFactory.createDeclaration(type, name);
            ArrangeDefinition definition = UnitTestFactory.createArrangeStatementDefinition(parameterScenario.getValueType());

            ArrangeStatement arrangeStatement = UnitTestFactory.createArrangeStatement(declaration, definition);
            arranges.add(arrangeStatement);
        }

        return UnitTestFactory.createArrange(arranges);
    }

}
