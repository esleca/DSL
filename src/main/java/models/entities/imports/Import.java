package models.entities.imports;

public class Import {

    private String library;

    public Import(String library){
        this.library = library;
    }

    public String getLibrary(){
        return this.library;
    }

}
