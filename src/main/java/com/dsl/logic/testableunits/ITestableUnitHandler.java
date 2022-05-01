package com.dsl.logic.testableunits;

import com.dsl.models.aggregates.Function;

import java.util.ArrayList;

public interface ITestableUnitHandler {

    ArrayList<Function> processTestableUnits(ArrayList<Function> functions);

}
