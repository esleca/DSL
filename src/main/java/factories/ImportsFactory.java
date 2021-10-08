package factories;

import models.entities.imports.Import;

public class ImportsFactory implements IImportsFactory {

    @Override
    public Import createImport(String name) {
        return new Import(name);
    }
}
