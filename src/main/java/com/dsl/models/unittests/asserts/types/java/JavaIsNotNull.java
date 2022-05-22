package com.dsl.models.unittests.asserts.types.java;

import com.dsl.models.unittests.asserts.types.IsNotNull;
import static com.dsl.utils.Constants.ASSERT_JAVA_IS_NOT_NULL;

public class JavaIsNotNull extends IsNotNull {

    public JavaIsNotNull() {
        this.name = ASSERT_JAVA_IS_NOT_NULL;
    }
}
