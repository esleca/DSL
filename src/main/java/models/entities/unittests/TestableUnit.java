package models.entities.unittests;

import models.entities.aggregates.Function;

public class TestableUnit {

    private Function function;

    public TestableUnit(Function function){
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

}
