package factories;

import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.aggregates.Package;

public class AggregatesFactory {

    public static Package createPackage(String name){
        return new Package(name);
    }

    public static Class createClass(String name, Package gpackage){
        return new Class(name, gpackage);
    }

    public static Function createFunction(Class fileClass){
        return new Function(fileClass);
    }

}
