package com.dsl.logic.unittests;

import com.dsl.models.entities.aggregates.Function;

import java.util.ArrayList;

public interface ITestableUnitHandler {

    ArrayList<Function> processTestableUnits(ArrayList<Function> functions);

}
