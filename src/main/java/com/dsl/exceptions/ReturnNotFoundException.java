package com.dsl.exceptions;

public class ReturnNotFoundException extends Exception{

    public ReturnNotFoundException(){
        super("Invalid DSL function return");
    }
}
