package exceptions;

public class ValueTypeNotFoundException extends Exception{

    public ValueTypeNotFoundException(){
        super("Invalid DSL value type");
    }
}
