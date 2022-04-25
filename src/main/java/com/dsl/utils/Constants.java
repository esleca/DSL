package com.dsl.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public final static String ASSERT_CLASS = "Assert";

    public final static String MODIFIER_PUBLIC = "public";
    public final static String MODIFIER_PRIVATE = "private";
    public final static String MODIFIER_PROTECTED = "protected";
    public final static String MODIFIER_STATIC = "static";
    public final static String MODIFIER_ABSTRACT = "abstract";

    public final static String RETURN_INTEGER = "int";
    public final static String RETURN_STRING = "String";
    public final static String RETURN_BOOLEAN = "boolean";
    public final static String RETURN_FLOAT = "float";
    public final static String RETURN_LONG = "long";
    public final static String RETURN_DOUBLE = "double";
    public final static String RETURN_CHAR = "char";
    public final static String RETURN_VOID = "void";
    public final static String RETURN_PARAMETERIZED = "Parameterized";

    public final static String ASSERT_ARE_EQUAL = "areEqual";
    public final static String ASSERT_ARE_NOT_EQUAL = "areNotEqual";
    public final static String ASSERT_IS_TRUE = "isTrue";
    public final static String ASSERT_IS_FALSE = "isFalse";
    public final static String ASSERT_IS_NULL = "isNull";
    public final static String ASSERT_IS_NOT_NULL = "isNotNull";
    public final static String ASSERT_INSTANCE_OF = "isInstanceOfType";

    public final static String VALUE_TYPE_INTEGER = "int";
    public final static String VALUE_TYPE_STRING = "String";
    public final static String VALUE_TYPE_BOOLEAN = "boolean";
    public final static String VALUE_TYPE_FLOAT = "float";
    public final static String VALUE_TYPE_LONG = "long";
    public final static String VALUE_TYPE_DOUBLE = "double";
    public final static String VALUE_TYPE_CHAR = "char";
    
    public final static List<String> PRIM_VALUE_TYPES = Arrays.asList(
    		VALUE_TYPE_INTEGER, 
    		VALUE_TYPE_STRING,
    		VALUE_TYPE_BOOLEAN, 
    		VALUE_TYPE_FLOAT,
    		VALUE_TYPE_LONG, 
    		VALUE_TYPE_DOUBLE,
    		VALUE_TYPE_CHAR);

    public final static String ACT_RESULT_NAME = "result";

    public final static String ARGUMENT_EXPECTED = "expected";
    public final static String ARGUMENT_RESULT = "result";

    public final static String SYSTEM_UNDER_TEST = "sut";

    public final static String LANGUAGE_JAVA = "JAVA";

    public final static String ARRAY_LIST = "ArrayList";
    public final static String LIST = "List";
}
