package com.dsl.tests.factories;

import ASTMCore.ASTMSyntax.Expression.Literal;
import ASTMCore.ASTMSyntax.Expression.RealLiteral;
import ASTMCore.ASTMSyntax.Expression.BooleanLiteral;
import ASTMCore.ASTMSyntax.Expression.CharLiteral;
import ASTMCore.ASTMSyntax.Expression.IntegerLiteral;
import ASTMCore.ASTMSyntax.Expression.StringLiteral;

import org.junit.jupiter.api.Test;
import com.dsl.factories.LiteralsFactory;

import static org.junit.Assert.assertTrue;


public class LiteralsFactoryTests {

	
	//_______________________________________________
    // test_createLiteralExpression_InstanceOfInteger
    //
    // GIVEN: createLiteralExpression is called
    // WHEN:  int type is passed
    // THEN:  IntegerLiteral instance is returned
    //_______________________________________________
	@Test
	public void test_createLiteralExpression_InstanceOfInteger() {
		//Arrange
		String type = "int";
		
		//Act
		Literal literal = LiteralsFactory.createLiteralExpression(type);
		
		//Assert
		assertTrue(literal instanceof IntegerLiteral);
	}
	
	
	//_______________________________________________
    // test_createLiteralExpression_InstanceOfString
    //
    // GIVEN: createLiteralExpression is called
    // WHEN:  String type is passed
    // THEN:  StringLiteral instance is returned
    //_______________________________________________
	@Test
	public void test_createLiteralExpression_InstanceOfString() {
		//Arrange
		String type = "String";
		
		//Act
		Literal literal = LiteralsFactory.createLiteralExpression(type);
		
		//Assert
		assertTrue(literal instanceof StringLiteral);
	}
	
	
	//_______________________________________________
    // test_createLiteralExpression_InstanceOfBoolean
    //
    // GIVEN: createLiteralExpression is called
    // WHEN:  Boolean type is passed
    // THEN:  BooleanLiteral instance is returned
    //_______________________________________________
	@Test
	public void test_createLiteralExpression_InstanceOfBoolean() {
		//Arrange
		String type = "boolean";
		
		//Act
		Literal literal = LiteralsFactory.createLiteralExpression(type);
		
		//Assert
		assertTrue(literal instanceof BooleanLiteral);
	}
	
	
	//_____________________________________________
    // test_createLiteralExpression_InstanceOfFloat
    //
    // GIVEN: createLiteralExpression is called
    // WHEN:  Float type is passed
    // THEN:  RealLiteral instance is returned
    //_____________________________________________
	@Test
	public void test_createLiteralExpression_InstanceOfFloat() {
		//Arrange
		String type = "float";
		
		//Act
		Literal literal = LiteralsFactory.createLiteralExpression(type);
		
		//Assert
		assertTrue(literal instanceof RealLiteral);
	}
	
	
	//_____________________________________________
    // test_createLiteralExpression_InstanceOfLong
    //
    // GIVEN: createLiteralExpression is called
    // WHEN:  Long type is passed
    // THEN:  RealLiteral instance is returned
    //_____________________________________________
	@Test
	public void test_createLiteralExpression_InstanceOfLong() {
		//Arrange
		String type = "long";
		
		//Act
		Literal literal = LiteralsFactory.createLiteralExpression(type);
		
		//Assert
		assertTrue(literal instanceof RealLiteral);
	}
	
	
	//_______________________________________________
    // test_createLiteralExpression_InstanceOfDouble
    //
    // GIVEN: createLiteralExpression is called
    // WHEN:  Double type is passed
    // THEN:  RealLiteral instance is returned
    //_______________________________________________
	@Test
	public void test_createLiteralExpression_InstanceOfDouble() {
		//Arrange
		String type = "double";
		
		//Act
		Literal literal = LiteralsFactory.createLiteralExpression(type);
		
		//Assert
		assertTrue(literal instanceof RealLiteral);
	}
	
	
	//_____________________________________________
    // test_createLiteralExpression_InstanceOfChar
    //
    // GIVEN: createLiteralExpression is called
    // WHEN:  Char type is passed
    // THEN:  CharLiteral instance is returned
    //_____________________________________________
	@Test
	public void test_createLiteralExpression_InstanceOfChar() {
		//Arrange
		String type = "char";
		
		//Act
		Literal literal = LiteralsFactory.createLiteralExpression(type);
		
		//Assert
		assertTrue(literal instanceof CharLiteral);
	}
	
}
