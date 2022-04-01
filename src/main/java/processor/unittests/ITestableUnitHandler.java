package processor.unittests;

import models.entities.aggregates.Function;

import java.util.ArrayList;

public interface ITestableUnitHandler {

    ArrayList<Function> processTestableUnits(ArrayList<Function> functions);

}
