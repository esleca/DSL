package com.dsl.logic.unittests;

import com.dsl.factories.UnitTestFactory;
import com.dsl.models.parameters.ParameterScenario;
import com.dsl.models.unittests.*;
import com.dsl.models.unittests.arranges.Arrange;
import com.dsl.models.unittests.arranges.ArrangeStatement;
import com.dsl.models.unittests.Declaration;
import com.dsl.models.unittests.arranges.ArrangeDefinition;

import static com.dsl.utils.Constants.ARGUMENT_EXPECTED;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class UnitTestArrangeHandler implements IUnitTestArrangeHandler {

    @Override
    public Arrange processUnitTestArrange(TestScenario testScenario) {
        ArrayList<ArrangeStatement> arranges = new ArrayList<>();
        ArrayList<ParameterScenario> parameterScenarios = testScenario.getParameters();

        for (ParameterScenario parameterScenario : parameterScenarios){
            ArrangeStatement arrangeStatement = getArrangeStatement(parameterScenario);
            arranges.add(arrangeStatement);
        }
        
        if(testScenario.getExpectedResult().getValueType() != null) {
        	ArrangeStatement expectedStatement = getExpectedArrange(testScenario.getExpectedResult());
        	arranges.add(expectedStatement);
        }
        
        return UnitTestFactory.createArrange(arranges);
    }
    
    
    private ArrangeStatement getArrangeStatement(ParameterScenario parameterScenario) {
    	String type = parameterScenario.getParameterFunction().getType();
        String name = parameterScenario.getParameterFunction().getName();

        Declaration declaration = UnitTestFactory.createDeclaration(type, name);
        ArrangeDefinition definition = UnitTestFactory.createArrangeStatementDefinition(parameterScenario.getValueType());
        
        return UnitTestFactory.createArrangeStatement(declaration, definition);
    }
    
    
    private ArrangeStatement getExpectedArrange(ExpectedResult inExpected) {
        Declaration declaration = UnitTestFactory.createDeclaration(inExpected.getExpectedType(), ARGUMENT_EXPECTED);
        ArrangeDefinition definition = UnitTestFactory.createArrangeStatementDefinition(inExpected.getValueType());
        
        return UnitTestFactory.createArrangeStatement(declaration, definition);
    }

}
