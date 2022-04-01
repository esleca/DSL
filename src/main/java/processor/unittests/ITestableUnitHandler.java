package processor.unittests;

import models.entities.aggregates.Function;

import java.util.ArrayList;

public interface ITestableUnitHandler {

    ArrayList<Function> processTestableFunctions(ArrayList<Function> functions);

}
