package com.dsl.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public final static String JAVA_ASSERT_CLASS = null;
    public final static String CSHARP_ASSERT_CLASS = "Assert";

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
    
    public final static String ASSERT_JAVA_ARE_EQUAL = "assertEquals";
    public final static String ASSERT_JAVA_ARE_NOT_EQUAL = "assertNotEquals";
    public final static String ASSERT_JAVA_IS_TRUE = "assertTrue";
    public final static String ASSERT_JAVA_IS_FALSE = "assertFalse";
    public final static String ASSERT_JAVA_IS_NULL = "assertNull";
    public final static String ASSERT_JAVA_IS_NOT_NULL = "assertNotNull";
    public final static String ASSERT_JAVA_INSTANCE_OF = "assertInstanceOfType";
    
    public final static String ASSERT_CSHARP_ARE_EQUAL = "AreEqual";
    public final static String ASSERT_CSHARP_ARE_NOT_EQUAL = "AreNotEqual";
    public final static String ASSERT_CSHARP_IS_TRUE = "IsTrue";
    public final static String ASSERT_CSHARP_IS_FALSE = "IsFalse";
    public final static String ASSERT_CSHARP_IS_NULL = "IsNull";
    public final static String ASSERT_CSHARP_IS_NOT_NULL = "IsNotNull";
    public final static String ASSERT_CSHARP_INSTANCE_OF = "IsInstanceOfType";

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
    public final static String LANGUAGE_CSHARP = "CSHARP";
    public final static String LANGUAGE_PYTHON = "PYTHON";

    public final static String ARRAY_LIST = "ArrayList";
    public final static String LIST = "List";
    
    public final static String JAVA_TEST_ANNOTATION = "Test";
    public final static String CSHARP_TEST_ANNOTATION = "TestMethod";
    public final static String PYTHON_TEST_ANNOTATION = "-";
    
    public final static String JAVA_JUNIT_JUPITER = "org.junit.jupiter.api.Test";
    public final static String JAVA_JUNIT_ASSERT = "org.junit.Assert.*";
    
    public final static String CSHARP_SYSTEM = "System";
    public final static String CSHARP_SYSTEM_COLLECTIONS = "System.Collections.Generic";
    public final static String CSHARP_SYSTEM_LINQ = "System.Linq";
    public final static String CSHARP_SYSTEM_TEXT = "System.Text";
    public final static String CSHARP_SYSTEM_THREADING = "System.Threading.Tasks";
    public final static String CSHARP_UNITTEST = "Microsoft.VisualStudio.TestTools.UnitTesting";
    
}
