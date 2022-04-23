package com.dsl.logic.unittests;

import com.dsl.factories.UnitTestFactory;
import com.dsl.models.entities.parameters.ParameterScenario;
import com.dsl.models.entities.unittests.*;
import com.dsl.models.entities.unittests.arranges.Arrange;
import com.dsl.models.entities.unittests.arranges.ArrangeStatement;
import com.dsl.models.entities.unittests.Declaration;
import com.dsl.models.entities.unittests.arranges.ArrangeDefinition;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
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
