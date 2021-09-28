package processor.unittests;

import factories.UnitTestFactory;
import models.entities.parameters.ParameterScenario;
import models.entities.unittests.*;
import models.entities.unittests.arranges.Arrange;
import models.entities.unittests.arranges.ArrangeStatement;
import models.entities.unittests.arranges.Declaration;
import models.entities.unittests.arranges.Definition;

import java.util.ArrayList;

public class ProcessorHandlerUnitTesterArranger implements IProcessorHandlerUnitTesterArranger {

    private UnitTestFactory unitTestFactory;

    public ProcessorHandlerUnitTesterArranger(){
        unitTestFactory = new UnitTestFactory();
    }

    /**
     * Create the Arrange section of the unit test
     *
     * @param testScenario
     * @return Arrange section
     */
    @Override
    public Arrange getArrange(TestScenario testScenario) {
        ArrayList<ArrangeStatement> arranges = new ArrayList<>();
        ArrayList<ParameterScenario> parameterScenarios = testScenario.getParameters();

        for (ParameterScenario parameterScenario : parameterScenarios){
            // Declaration
            String type = parameterScenario.getParameterFunction().getType();
            String name = parameterScenario.getParameterFunction().getName();
            Declaration declaration = unitTestFactory.createArrangeStatementDeclaration(type, name);

            // Definition
            Definition definition = unitTestFactory.createArrangeStatementDefinition(parameterScenario.getValueType());

            // Arrange Statement
            ArrangeStatement arrangeStatement = unitTestFactory.createArrangeStatement(declaration, definition);
            arranges.add(arrangeStatement);
        }

        return unitTestFactory.createArrange(arranges);
    }
}
