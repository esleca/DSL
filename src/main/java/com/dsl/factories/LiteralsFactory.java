package com.dsl.factories;

import static com.dsl.utils.Constants.*;

import ASTMCore.ASTMSyntax.Expression.Literal;
import ASTMCore.ASTMSyntax.Expression.BooleanLiteral;
import ASTMCore.ASTMSyntax.Expression.CharLiteral;
import ASTMCore.ASTMSyntax.Expression.IntegerLiteral;
import ASTMCore.ASTMSyntax.Expression.StringLiteral;


public class LiteralsFactory {

	public static Literal createLiteralExpression(String inType) {
		Literal literal = new Literal();
		
		switch (inType){
	        case VALUE_TYPE_STRING:
	        	literal = new StringLiteral(); break;
	        case VALUE_TYPE_BOOLEAN:
	        	literal = new BooleanLiteral(); break;
	        case VALUE_TYPE_INTEGER:
	        	literal = new IntegerLiteral(); break;
            case VALUE_TYPE_CHAR:
            	literal = new CharLiteral(); break;
                
	        //default:
	            //throw new LiteralNotFoundException();
		}
		
		return literal;
	}
}
