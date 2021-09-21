package factories;

import models.entities.aggregates.Class;
import models.entities.aggregates.Function;

public class AggregatesFactory {

    public Class createClass(String name){
        Class fClass = new Class(name);
        return fClass;
    }

    public Function createFunction(Class fileClass, String gPackage){
        Function function = new Function(fileClass, gPackage);
        return function;
    }

}
