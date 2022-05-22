package com.dsl.logic.parameterscenarios;

import java.util.ArrayList;
import org.json.simple.JSONArray;

import com.dsl.exceptions.ValueTypeNotFoundException;
import com.dsl.models.parameters.ParameterScenario;

public interface IParameterScenarioHandler {

	ArrayList<ParameterScenario> getParameterScenarios(JSONArray paramsArray) throws ValueTypeNotFoundException;
}
