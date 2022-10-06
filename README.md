# How to use the DSL Project
This project use [Maven](https://maven.apache.org/index.html) as the Software Project Management.

## Requirements
Make sure the following folders are created before using the DSL to generate unit tests or query reports.
```
C:\TestDSL
C:\TestPrinter
```

## Installation
In order to use the DSL services, include the following dependency in the pom.xml file of the client.
```
<dependency>
    <groupId>avib.coderetriever</groupId>
    <artifactId>avib.coderetriever.dsl</artifactId>
    <version>1.0</version>
</dependency>
```

## Fachade
The following code snippet shows the DSL interface that can be used to generate unit tests and reports. 
The ```generateUnitTest``` method inserts a new unit test or updates it if it already exists in the datastore. 
The get methods receive a specific request object and returns a ```UnitTestResponse``` object with some details to be
displayed in the ```SWT-plugin``` client.

```java
public interface IDSLFachade {

    UnitTestResponse generateUnitTest(UnitTestRequest unitTestRequest);
    
    void removeUnitTest(UnitTestRequest unitTestRequest);
    
    List<UnitTestResponse> getFunctionUnitTests(FunctionTestsRequest functionRequest);
    
    List<UnitTestResponse> getClassUnitTests(ClassTestsRequest classRequest);
    
    List<UnitTestResponse> getPackageUnitTests(PackageTestsRequest packageRequest);
    
    List<ClassFunctionsResponse> getClassFunctions(ClassFunctionsRequest classRequest);
}
```

## Requests 

The following code snippets shows the Request objects of the DSL fachade.

### UnitTestRequest

This object is used to insert or update a unit test.

```java
public class UnitTestRequest {
    private String classPath;
    private String language;
    private String outputPath;
    private String function;
    private String testName;
    private JSONArray parameters;
    private ValueType expected;
    private String assertion;
}
```

### FunctionTestsRequest

This object is used to get a function unit tests list.

```java
public class FunctionTestsRequest {
    private String packageName;
    private String className;
    private String functionName;
}
```

### ClassTestsRequest

This object is used to get a class unit tests list.

```java
public class ClassTestsRequest {
    private String packageName;
    private String className; 
}
```

### PackageTestsRequest

This object is used to get a package unit tests list.

```java
public class PackageTestsRequest { 
    private String packageName;
}
```

### ClassFunctionsRequest

This object is used to get a class functions list.

```java
public class ClassFunctionsRequest {
    private String classPath;
    private String language;
}
```


## Responses

The following code snippets shows the Responses objects of the DSL fachade.

### UnitTestResponse

This object is used to represent the response of creating or updating a unit test.

```java
public class UnitTestResponse {
    private String language;
    private String packageName;
    private String className;
    private String functionName;
    private String testName;
    private String assertion;
}
```

### ClassFunctionsResponse

This object is used to represent the response of a class functions list.

```java
public class ClassFunctionsResponse {
    private String name;
    private String returns;
    private ArrayList<ParameterFunction> parameters; 
}
```
