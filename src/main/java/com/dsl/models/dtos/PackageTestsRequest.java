package com.dsl.models.dtos;

public class PackageTestsRequest {

	private String packageName;

	public PackageTestsRequest(String packageName) {
		this.packageName = packageName;
	}
	
	public String getPackageName() {
		return packageName;
	}
}
