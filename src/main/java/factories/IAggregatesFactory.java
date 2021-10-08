package factories;

import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.aggregates.Package;

public interface IAggregatesFactory {

    Package createPackage(String name);

    Class createClass(String name, Package aPackage);

    Function createFunction(Class fileClass);
}
