package com.dsl.factories;

import com.dsl.models.imports.Import;

public class ImportsFactory {

    public static Import createImport(String name) {
        return new Import(name);
    }
}
