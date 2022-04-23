package com.dsl.factories;

import com.dsl.models.entities.imports.Import;

public class ImportsFactory {

    public static Import createImport(String name) {
        return new Import(name);
    }
}
