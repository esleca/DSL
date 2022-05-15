package com.dsl.factories;

import com.dsl.models.aggregates.Class;
import com.dsl.models.aggregates.Function;
import com.dsl.models.aggregates.Package;

public class AggregatesFactory {

    public static Package createPackage(String name){
        return new Package(name);
    }

    public static Class createClass(String language, String name, Package gpackage){
        return new Class(language, name, gpackage);
    }

    public static Function createFunction(Class fileClass){
        return new Function(fileClass);
    }

}
