package com.dsl.logic.testscenarios;

import java.util.ArrayList;
import org.json.simple.JSONArray;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.entities.parameters.ParameterScenario;

public interface IParameterScenarioHandler {

	ArrayList<ParameterScenario> getParameterScenarios(JSONArray paramsArray) throws ValueTypeNotFoundException;
}
