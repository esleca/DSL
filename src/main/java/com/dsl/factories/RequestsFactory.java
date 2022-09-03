package com.dsl.factories;

import com.dsl.fachade.models.DSLModel;
import com.dsl.models.dtos.ClassTestsRequest;

public class RequestsFactory {

    public static ClassTestsRequest createClassTestsRequest(DSLModel model){
    	var dslClass = model.getlClass();
    	String packageName = dslClass.getPackage().getName();
    	String className = dslClass.getName();
    	
    	ClassTestsRequest classRequest = new ClassTestsRequest(packageName, className);
        return classRequest;
    }
}
