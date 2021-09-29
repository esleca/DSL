package exceptions;

public class AssertNotFoundException extends Exception{

    public AssertNotFoundException(){
        super("Invalid DSL unit test assert");
    }
}
