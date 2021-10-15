package factories;

import models.entities.aggregates.Class;
import models.entities.aggregates.Function;
import models.entities.aggregates.Package;

public class AggregatesFactory implements IAggregatesFactory {

    @Override
    public Package createPackage(String name){
        Package aPackage = new Package(name);
        return aPackage;
    }

    @Override
    public Class createClass(String name, Package gpackage){
        Class fClass = new Class(name, gpackage);
        return fClass;
    }

    @Override
    public Function createFunction(Class fileClass){
        Function function = new Function(fileClass);
        return function;
    }

}
