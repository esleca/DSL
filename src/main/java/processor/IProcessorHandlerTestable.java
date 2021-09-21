package processor;

import models.entities.aggregates.Function;
import models.entities.unittests.TestableUnit;

import java.util.ArrayList;

public interface IProcessorHandlerTestable {

    ArrayList<TestableUnit> getTestableUnits(ArrayList<Function> functions);

}
