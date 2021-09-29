package exceptions;

public class ModifierNotFoundException extends Exception{

    public ModifierNotFoundException(){
        super("Invalid DSL function modifier");
    }
}
