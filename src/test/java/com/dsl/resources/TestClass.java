package com.dsl.resources;

// Do not update TestClass
// Class is used to generate unit tests compilation units
public class TestClass {
	
	/******************************************/
	/****** functions without parameters ******/
	/******************************************/
	public String returnStringWithoutParams(){
		return privateReturnString();
	}
	
	public boolean returnBoolWithoutParams() {
		return privateReturnBool();
	}
	
	public int returnIntWithoutParams() {
		return privateReturnInt();
	}
	
	public objResponse returnObjWithoutParams() {
		return privateReturnObj();
	}
	
	
	/******************************************/
	/******* functions with parameters ********/
	/******************************************/
	public String returnStringWithParams(String inText){
		return "mock " + inText;
	}
	
	public boolean returnBoolWithParams(boolean inResponse) {
		return inResponse;
	}
	
	public int returnIntWithParams(int inInt) {
		return -1 * inInt;
	}
	
	public objResponse returnObjWithParams(String inText) {
		return new objResponse();
	}
	
	
	/******************************************/
	/******** functions with no return ********/
	/******************************************/
	public void noReturnWithParams(String param){
		// body..
	}
	
	
	/******************************************/
	/************ private functions ***********/
	/******************************************/
	private String privateReturnString(){
		return "mock test";
	}
	
	private boolean privateReturnBool() {
		return true;
	}
	
	private int privateReturnInt() {
		return -1;
	}
	
	private objResponse privateReturnObj() {
		return new objResponse();
	}
	
	
	// reference test class
	class objResponse{} 
	
}
