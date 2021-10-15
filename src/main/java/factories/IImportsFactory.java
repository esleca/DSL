package factories;

import models.entities.imports.Import;

public interface IImportsFactory {

    Import createImport(String name);
}
