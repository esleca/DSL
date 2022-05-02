package com.dsl.exceptions;

public class LiteralNotFoundException extends Exception {

	public LiteralNotFoundException() {
		super("Invalid DSL literal type");
	}
}
