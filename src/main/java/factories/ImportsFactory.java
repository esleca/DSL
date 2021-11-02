package factories;

import models.entities.imports.Import;

public class ImportsFactory {

    public static Import createImport(String name) {
        return new Import(name);
    }
}
